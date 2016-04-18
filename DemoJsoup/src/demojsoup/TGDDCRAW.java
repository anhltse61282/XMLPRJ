/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojsoup;

import java.io.IOException;
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
public class TGDDCRAW {

    public static void main(String[] args) {
        
        try {
                CrawlVTA dthoai = new CrawlVTA("Điện thoại");
                dthoai.setBrandSelect("ul.clearlist.menu-dt>li>a");
                dthoai.setSqlBrand("ĐIỆN THOẠI");
                CrawlVTA mtb = new CrawlVTA("Tablet");
                mtb.setBrandSelect("ul.mn-sub>div[style=background-image: url(/Content/images/bg/bg-menu-tablet.jpg)]>ul.clearlist>li>a");
                mtb.setSqlBrand("MÁY TÍNH BẢNG");
                CrawlVTA pkien = new CrawlVTA("Phụ kiện");
                pkien.setBrandSelect("ul.mn-sub>div[style=background-image: url(/Content/images/bg/bg-menu-phukien.jpg)]>ul.clearlist>li>a");
             pkien.setSqlBrand("PHỤ KIỆN");
                Thread t1 = new Thread(dthoai);
                Thread t2 = new Thread(mtb);
                Thread t3 = new Thread(pkien);
                t1.start();
                t2.start();
                t3.start();
//            System.out.println(doc.toString());

//            System.out.println(doc.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
