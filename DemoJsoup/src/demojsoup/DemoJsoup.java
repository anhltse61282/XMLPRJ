/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojsoup;

import com.demo.api.DBAPI;
import com.demo.device.Device;
import com.demo.device.Devices;
import com.demo.dto.Brands;
import com.demo.dto.Catalogs;
import com.demo.dto.Products;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Gunner
 */
public class DemoJsoup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException {
        // TODO code application logic here
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.hnammobile.com/").timeout(0).get();
            Elements elements = doc.select("div.up>a[class=nav-item]");
//            for (Element element : elements) {
//                DBAPI api = new DBAPI();
//                String query = "INSERT INTO TBL_Catalog(catalogName) VALUES(?)";
//                List<String> param = new ArrayList<String>();
//                param.add(element.text());
//                api.insertData(query, param);
//            }
            List<String> brandname = new ArrayList<String>();
            for (Element element : elements) {
                int numPage = 1;
                DBAPI dbi = new DBAPI();
                String query = "SELECT * FROM TBL_Catalog WHERE catalogName = ?";
                List<String> param = new ArrayList<String>();
                param.add(element.text());
                Integer Catalogid = ((Catalogs) dbi.searchByName(query, param, "TBL_Catalog")).getID();
                System.out.println("catalogID: " + Catalogid);
                System.out.println(element.text());
                System.out.println(element.attr("href"));
                String catalog = element.attr("href");
                for (int j = 1; j <= numPage; j++) {
                    if (numPage > 1) {
                        catalog = catalog + "?p=" + numPage + "#ds";
                    }
                    System.out.println("page:" + j);
                    Document docItem = Jsoup.connect(catalog).timeout(0).get();
                    Elements pagenum = docItem.select("div[id=paging]>a");

                    if (pagenum != null && pagenum.size() > 0) {
                        String urlPage = pagenum.get(pagenum.size() - 1).attr("href");

                        String number = urlPage.replaceAll("\\D+", "");
                        numPage = Integer.parseInt(number);
                        System.out.println(numPage);

                    }
                    int id = 0;
                    Elements productLink = docItem.select("li.pitem>a.product-item");
                    for (Element element1 : productLink) {
                        id++;
                        Device product = new Device();
                        product.setCatalogID(BigInteger.valueOf(Catalogid.intValue()));
                        if (element1.attr("href") != "#") {
                            String url = element1.attr("href");
                            if (!url.contains("http")) {
                                url = "http://www.hnammobile.com" + url;
                            }
                            Document docDetail = Jsoup.connect(url).timeout(0).get();
                            product.setId(BigInteger.valueOf(id));
                            Element productName = docDetail.select("div>h2.product-name.product-name2").first();
                            Element productprice = docDetail.select("div.price-block>span").first();
                            Element imageLnk = docDetail.select("p[style=text-align:center;]>a").first();
//                        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
//                        WebClient webCLient = new WebClient(BrowserVersion.FIREFOX_17);
//                        webCLient.getOptions().setThrowExceptionOnScriptError(false);
//                        webCLient.getOptions().setThrowExceptionOnFailingStatusCode(false);
//                        HtmlPage page = webCLient.getPage(url);
//                        Element image = Jsoup.parse(page.asXml()).select("p[slidesjs-index=0]>a").first();
                            if (imageLnk != null) {
                                System.out.println("Image: " + imageLnk.attr("href"));
                                product.setImageLink(imageLnk.attr("href"));
                            }
                            if (productName != null) {
                                System.out.println(productName.text());
                                product.setProductName(productName.text());
                                StringTokenizer stringTokenizer = new StringTokenizer(productName.text(), " ");
                                String brandName = stringTokenizer.nextToken();
                                int count = 0;
                                if (brandName.equals("Nắp") || brandName.equals("Năp") || brandName.equals("Bao")
                                        || brandName.equals("Tai") || brandName.equals("Ốp") || brandName.equals("Pin")
                                        || brandName.equals("Loa") || brandName.equals("Kính") || brandName.equals("Giá") || brandName.equals("Bộ") || brandName.equals("Bô")
                                        || brandName.equals("Camera") || brandName.equals("Combo") || brandName.equals("Dán")
                                        ||brandName.equals("Smart")||brandName.equals("Chuột")||brandName.equals("Đèn")||brandName.equals("Cân")||brandName.equals("Thẻ")) {
                                    brandName = "Phụ kiện";

                                }
                                for (int i = 0; i < brandname.size(); i++) {

                                    if (brandName.equals(brandname.get(i))) {
                                        count++;
                                    }
                                }
                                if (count == 0) {
                                    brandname.add(brandName);
                                    System.out.println("Brand:" + brandName);
                                }
                                query = "SELECT * FROM TBL_brand WHERE brandName = ?";
                                param = new ArrayList<String>();
                                param.add(brandName);
                                Integer brandid = ((Brands) dbi.searchByName(query, param, "TBL_brand")).getId();
                                System.out.println("BrandID: " + brandid);
                                product.setBrandID(BigInteger.valueOf(brandid.intValue()));
                            }
                            if (productprice != null) {
                                BigInteger priceMoney = null;
                                StringBuilder priceBuil = new StringBuilder(productprice.text());
                                System.out.println(productprice.text());
                                for (int i = 0; i < priceBuil.length(); i++) {
                                    if (priceBuil.charAt(i) == ',' || priceBuil.charAt(i) == 'đ') {
                                        priceBuil.deleteCharAt(i);
                                    }
                                }
                                try {
                                    if (priceBuil.length() > 1) {

                                        priceMoney = new BigInteger(priceBuil.toString());
                                    } else {
                                        priceMoney = new BigInteger("0");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                product.setPrice(priceMoney);
                                System.out.println("price:" + priceBuil);
                            }
                            Elements spec = docDetail.select("div#product-detail-left>div.line2");
                            for (Element element2 : spec) {
                                if (((Element) element2.childNode(1)).text().equals("Kích cỡ màn hình ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setMonitor(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Bộ nhớ trong ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setMemory(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Khe cắm thẻ nhớ ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setMemorycard(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Camera chính ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setMaincamera(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Camera phụ ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setSubCamera(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Hệ điều hành ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setOs(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Bộ xử lý ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setChipset(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Chipset ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setChipName(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Màu sắc ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setColor(((Element) size).text());
                                } else if (((Element) element2.childNode(1)).text().equals("Pin chuẩn ")) {
                                    Node size = element2.childNode(3);
                                    System.out.println(((Element) size).text());
                                    product.setBattery(((Element) size).text());
                                }
                            }
                        }
                        SchemaFactory scf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                        Schema schema;
                        Devices devices = new Devices();
                        devices.getDevice().add(product);
                        schema = scf.newSchema(new File("productSCH.xsd"));
                        JAXBContext jAXBContext;
                        jAXBContext = JAXBContext.newInstance("com.demo.device");
                        Marshaller marshaller;
                        marshaller = jAXBContext.createMarshaller();
                        marshaller.setSchema(schema);
                        marshaller.marshal(devices, new DefaultHandler());
                        query = "INSERT INTO TBL_Products(productname,monitor,memory,memorycard,maincamera,subCamera,OS,Chip,color,battery,price,catalogID,brandID,chipName,imageLink) "
                                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        param = new ArrayList<String>();
                        param.add(product.getProductName());
                        param.add(product.getMonitor());
                        param.add(product.getMemory());
                        param.add(product.getMemorycard());
                        param.add(product.getMaincamera());
                        param.add(product.getSubCamera());
                        param.add(product.getOs());
                        param.add(product.getChipset());
                        param.add(product.getColor());
                        param.add(product.getBattery());
                        param.add(product.getPrice().toString());
                        param.add(product.getCatalogID().toString());
                        param.add(product.getBrandID().toString());
                        param.add(product.getChipName());
                        param.add(product.getImageLink());
                        dbi.insertData(query, param);
                    }
                }
            }
//            for (int i = 0; i < brandname.size(); i++) {
//                DBAPI api = new DBAPI();
//                String query = "INSERT INTO TBL_brand(brandName) VALUES(?)";
//                List<String> param = new ArrayList<String>();
//                param.add(brandname.get(i));
//                api.insertData(query, param);
//            }
        } catch (IOException ex) {
            Logger.getLogger(DemoJsoup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(DemoJsoup.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
