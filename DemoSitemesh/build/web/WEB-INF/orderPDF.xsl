<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : orderPDF.fo.xsl
    Created on : April 16, 2016, 9:10 AM
    Author     : Gunner
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" encoding="UTF-8"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
       
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="x" page-height="8.5in"
                                       page-width="10.3in" margin-top="0.5in" margin-bottom="0.5in"
                                       margin-left="1in" margin-right="1in">
                    <fo:region-body margin-top="2in" />
                    <fo:region-before extent="1.5in" />
                    <fo:region-after extent=".75in" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="x">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block font-size="30pt" font-family="Arial"
                              line-height="24pt" 
                              text-align="center"
                              padding-top="3pt">
                        Đơn hàng
                    </fo:block>
                    <fo:block font-size="15pt" font-family="Arial"
                              line-height="24pt" 
                              text-align="center"
                              padding-top="15pt">
                        T AND A Mobile
                        
                    </fo:block>
                    <fo:block font-size="15pt" font-family="Arial"
                              line-height="24pt" 
                              text-align="center"
                    >
                        
                        Địa chỉ: Chung Cư An Lộc, F17, Gò Vấp
                        
                    </fo:block>
                    <fo:block font-size="15pt" font-family="Arial"
                              line-height="24pt" 
                              space-after.optimum="15pt" text-align="center"
                    >
                        SDT: 0937199446
                    </fo:block>
                     
                </fo:static-content>
               
                <fo:flow flow-name="xsl-region-body" >
                    <fo:block >
                        <fo:table border= '0' space-after.optimum="15pt" >
                            <fo:table-column column-width="5cm" />
                            <fo:table-column column-width="9cm"/>
                            <fo:table-body>
                            
                                <fo:table-row>
                                    <fo:table-cell border-color="white"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="left" font-family="Arial">Tên khách hàng:</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="white"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="left" font-family="Arial">
                                            <xsl:value-of select="order/@cutomerName"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell border-color="white"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="left">SDT:</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="white"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="left" font-family="Arial">
                                            <xsl:value-of select="order/@customerPhone"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell border-color="white"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="left" font-family="Arial">Địa chỉ:</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="white"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="left" font-family="Arial">
                                            <xsl:value-of select="order/@delAddress"/>
                                            <xsl:text>, </xsl:text>
                                            <xsl:value-of select="order/@delState"/>
                                             <xsl:text>, </xsl:text>
                                             <xsl:value-of select="order/@delCity"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                        <xsl:text>&#xa;</xsl:text>
                        <fo:table border-collapse="collapse" table-layout="fixed">
                            <fo:table-column column-width="1cm"/>
                            <fo:table-column column-width="9cm"/>
                            <fo:table-column column-width="2cm"/>
                            <fo:table-column column-width="6cm"/>
                            <fo:table-column column-width="5cm"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell border-color="blue"
                                                   border-width="0.5pt"
                                                   border-style="solid">
                                        <fo:block text-align="center">No.</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="black"
                                                   border-width="0.5pt" border-style="solid">
                                        <fo:block text-align="center" font-family="Arial">Tên sản phẩm:</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="black"
                                                   border-width="0.5pt" border-style="solid">
                                        <fo:block text-align="center" font-family="Arial">Số lượng</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="black"
                                                   border-width="0.5pt" border-style="solid">
                                        <fo:block text-align="center">Giá</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="black"
                                                   border-width="0.5pt" border-style="solid">
                                        <fo:block text-align="center" font-family="Arial">Tổng</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <xsl:for-each select="order/orderdetail">
                                    <fo:table-row>
                                        <fo:table-cell border-color="black"
                                                       border-width="0.5pt" border-style="solid">
                                            <fo:block text-align="center">
                                                <xsl:number level="single" count="orderdetail"/>.
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-color="black"
                                                       border-width="0.5pt" border-style="solid">
                                            <fo:block text-align="center" font-family="Arial">
                                                <xsl:value-of select="productName"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-color="black"
                                                       border-width="0.5pt" border-style="solid">
                                            <fo:block text-align="center">
                                                <xsl:value-of select="quantity"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-color="black"
                                                       border-width="0.5pt" border-style="solid">
                                            <fo:block text-align="center">
                                                <xsl:value-of select='format-number(price,"###,###")'/>VND
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border-color="black"
                                                       border-width="0.5pt" border-style="solid">
                                            <fo:block text-align="center">
                                                <xsl:value-of select='format-number(total,"###,###")' />VND
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                                <fo:table-row>
                                    
                                    <fo:table-cell border-color="black"
                                                   border-width="0.5pt" border-style="solid" number-columns-spanned="4">
                                        <fo:block text-align="center" font-family="Arial">
                                            Tổng
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-color="black"
                                                   border-width="0.5pt" border-style="solid">
                                        <fo:block text-align="center">
                                            <xsl:value-of select='format-number(order/@total,"###,###")'/>VND
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                           
                        </fo:table>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>
