/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojsoup;

import com.demo.api.DBAPI;
import com.demo.device.Device;
import com.demo.device.Devices;
import com.demo.dbutil.XMLUtils;
import com.demo.dto.Brands;
import com.demo.dto.Catalogs;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Gunner
 */
public class CrawlVTA implements Runnable {

    private String catalogName;
    private String brandSelect;
    private String sqlBrand;

    public String getSqlBrand() {
        return sqlBrand;
    }

    public void setSqlBrand(String sqlBrand) {
        this.sqlBrand = sqlBrand;
    }

    public String getBrandSelect() {
        return brandSelect;
    }

    public void setBrandSelect(String brandSelect) {
        this.brandSelect = brandSelect;
    }

    public CrawlVTA() {
    }

    public CrawlVTA(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public synchronized void run() {
        try {
            Document doc = null;
            String selec = "ul.clearlist>li>a[data-original-title=" + catalogName + "]";
            String page = "https://vienthonga.vn/";
            doc = Jsoup.connect(page).timeout(0).get();
            Element catalogs = doc.select(selec).first();

            System.out.println(catalogs);
            DBAPI dbi = new DBAPI();
            String query = "SELECT * FROM TBL_Catalog WHERE catalogName = ?";
            List<String> param = new ArrayList<String>();
            param.add(sqlBrand);
            Integer Catalogid = ((Catalogs) dbi.searchByName(query, param, "TBL_Catalog")).getID();
            System.out.println("CatalogIS" + Catalogid);
            doc = Jsoup.connect(page + catalogs.attr("href")).timeout(0).get();
            Elements catalog = doc.select(brandSelect);
            for (Element element1 : catalog) {
                Device device = new Device();
                String brandName = element1.text();
                System.out.println(element1.text());
                if (catalogName.equals("Tablet")) {
                    brandName=brandName.replace("MÁY TÍNH BẢNG", "").trim();
                    if (brandName.equals("IPAD")) {
                        brandName = "Apple";
                    }
                    System.out.println(brandName);
                }
                if (catalogName.equals("Phụ kiện")) {
                    brandName= "PHỤ KIỆN";
                }
                query = "SELECT * FROM TBL_brand WHERE brandName = ?";
                param = new ArrayList<String>();
                param.add(brandName.toUpperCase());
                Brands brandid =  dbi.searchByName(query, param, "TBL_brand");
                if (brandid != null) {
                    System.out.println("BrandID: " + brandid.getId());
                    device.setBrandID(BigInteger.valueOf(brandid.getId().intValue()));
                } else {
                    DBAPI dbapi = new DBAPI();
                    String queryBrand = "INSERT INTO TBL_brand(brandName) VALUES(?)";
                    List<String> paramBrand = new ArrayList<String>();
                    paramBrand.add(brandName.toUpperCase());
                    device.setBrandID(BigInteger.valueOf(dbapi.insertData(queryBrand, paramBrand)));
                }

                device.setCatalogID(BigInteger.valueOf(Catalogid.intValue()));
                String url = page + element1.attr("href");
                doc = Jsoup.connect(url).timeout(0).get();
//                System.out.println(doc.toString());
                Elements brands = doc.select("a.product-link");
                int id = 0;
                for (Element element2 : brands) {
                    id++;
                    device.setId(BigInteger.valueOf(id));
                    doc = Jsoup.connect(page + element2.attr("href")).timeout(0).get();
                    Element deviceName = doc.select("h1.name").first();
                    Element imageLnk = doc.select("div.detail-img>img").first();
                    device.setImageLink(imageLnk.attr("src"));
                    Element devicePrice = doc.select("div[itemprop=price]").first();
                    Elements colors = doc.select("div.verdes-element>span.product-color");
                    Element status = doc.select("span.con-hang").first();
                    Elements detailTech = doc.select("table.table>tbody>tr");
                    String colorStr = "";
                    System.out.println("Device Name: " + deviceName.text() + " " + catalogName);
                    device.setProductName(deviceName.text());
                    device.setSource("VTA");
                    String priceDevice = devicePrice.text().replaceAll("\\D+", "").trim();
                    System.out.println(priceDevice);
                    if (!priceDevice.equals("")) {
                        BigInteger priceInt = new BigInteger(priceDevice);
                        device.setPrice(priceInt);
                    }else{
                        device.setPrice(BigInteger.ZERO);
                    }

                    device.setOrderLinkLink(page + element2.attr("href"));
                    for (Element color : colors) {
                        colorStr = colorStr + ", " + color.attr("title");
                    }
                    System.out.println("Color:" + colorStr);
                    System.out.println("Status: " + status.text());
                    for (Element detail : detailTech) {
                        if (((Element) detail.childNode(1)).text().equals("Loại")) {
                            System.out.println("Loại: " + ((Element) detail.childNode(3)).text());
                            device.setMonitor(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Bộ Nhớ Trong")) {
                            System.out.println("Bộ Nhớ Trong: " + ((Element) detail.childNode(3)).text());
                            device.setMemory(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Khe Cắm Thẻ Nhớ")) {
                            System.out.println("Khe Cắm Thẻ Nhớ: " + ((Element) detail.childNode(3)).text());
                            device.setMemorycard(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Camera chính")) {
                            System.out.println("Camera chính: " + ((Element) detail.childNode(3)).text());
                            device.setMaincamera(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Camera Phụ")) {
                            System.out.println("Camera Phụ: " + ((Element) detail.childNode(3)).text());
                            device.setSubCamera(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Hệ Điều Hành")) {
                            System.out.println("Hệ Điều Hành: " + ((Element) detail.childNode(3)).text());
                            device.setOs(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Chipset")) {
                            System.out.println("Chipset: " + ((Element) detail.childNode(3)).text());
                            device.setChipName(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("CPU")) {
                            System.out.println("CPU: " + ((Element) detail.childNode(3)).text());
                            device.setChipset(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Màu Sắc")) {
                            System.out.println("Màu Sắc: " + ((Element) detail.childNode(3)).text());
                            device.setColor(((Element) detail.childNode(3)).text());
                        } else if (((Element) detail.childNode(1)).text().equals("Loại Pin")) {
                            System.out.println("Loại Pin: " + ((Element) detail.childNode(3)).text());
                            device.setBattery(((Element) detail.childNode(3)).text());
                        }

                    }
                    device.setViewTime(BigInteger.ZERO);
                    Devices devices = new Devices();
                    devices.getDevice().add(device);

                    if (XMLUtils.validateJAXBObject(devices, "productSCH1.xsd")) {

                        query = "INSERT INTO TBL_Products(productname,monitor,memory,memorycard,maincamera,subCamera,OS,Chip,color,battery,price,catalogID,brandID,chipName,imageLink,"
                                + "purchaseLnk,viewTime,source) "
                                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        param = new ArrayList<String>();
                        param.add(device.getProductName());
                        param.add(device.getMonitor());
                        param.add(device.getMemory());
                        param.add(device.getMemorycard());
                        param.add(device.getMaincamera());
                        param.add(device.getSubCamera());
                        param.add(device.getOs());
                        param.add(device.getChipset());
                        param.add(device.getColor());
                        param.add(device.getBattery());
                        param.add(device.getPrice().toString());
                        param.add(device.getCatalogID().toString());
                        param.add(device.getBrandID().toString());
                        param.add(device.getChipName());
                        param.add(device.getImageLink());
                        param.add(device.getOrderLinkLink());
                        param.add(device.getViewTime().toString());
                        param.add(device.getSource());
                        System.out.println(dbi.insertData(query, param));
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(CrawlVTA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
