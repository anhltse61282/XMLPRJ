<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : productxsl.xsl
    Created on : April 8, 2016, 9:46 AM
    Author     : Gunner
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template>
        <xsl:apply-templates/>
    </xsl:template>
    
    <xsl:template match="device">
        <div class="product-main">
            <div class="row">
                <div class="col-md-6 col-sm-6">
                    <div class="product-slider">
                        <div class="product-image-slider flexslider">
                            <ul class="slides">
                                <!-- Each slide should be enclosed inside li tag. -->

                                <!-- Slide #1 -->
                                <li>
                                    <!-- Image -->
                                    <img>
                                        <xsl:attribute name="src"> 
                                            <xsl:value-of select="imageLink" />
                                        </xsl:attribute>
                                    </img>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6" style="z-index:999;">
                    <!-- Title -->
                    <h4 class="title">
                        <xsl:value-of select="productName"/>
                    </h4>
                    <h5>Giá chỉ có : <xsl:value-of select='format-number(price,"###,###")'/> VND</h5>
                    <p>Vận chuyển : Free</p>
                    <p>Tình trạng : <font color="red">Còn hàng</font></p>
                    <!-- Dropdown menu -->
                    <div class="form-group">                               
                        Bảo hành: 12 tháng
                    </div>

                    <!-- Quantity and add to cart button -->

                    <div class="row">
                        <div class="col-md-6">
                            <div class="input-group">
                                <input type="text" class="form-control input-sm" value="2"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-default btn-sm" type="button">
                                        <xsl:attribute name="onclick">
                                            addcart(<xsl:value-of select="id" />)
                                        </xsl:attribute>
                                        Add to Cart
                                    </button>
                                </span>								  
                            </div>
                        </div>
                    </div>

                    <!-- Add to wish list -->
                    <a href="wish-list.html">+ Add to Wish List</a>


                </div>   
            </div>
        </div>
        <br/>
        <ul class="nav nav-tabs">
            <!-- Use uniqe name for "href" in below anchor tags -->
            <li class="active">
                <a href="#tab1"  data-toggle="tab">Thông số kĩ thuật</a>
            </li>
            <li >
                <a href="#tab2" data-toggle="tab">Mô tả</a>
            </li>
            
        </ul>

        <!-- Tab Content -->
        <div class="tab-content">
            <!-- Description -->
            

            <!-- Sepcs -->
            <div class="tab-pane active" id="tab1">

                <h5 class="title">Thông số kỹ thuật</h5>
                <table class="table table-striped tcart">
                    <tbody>
                        <tr>
                            <td>
                                <strong>Tên sản phẩm</strong>
                            </td>
                            <td>
                                <xsl:value-of select="productName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Màn hình</strong>
                            </td>
                            <td>
                                <xsl:value-of select="monitor"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>CPU</strong>
                            </td>
                            <td>
                                <xsl:value-of select="chipset"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Bộ nhớ trong</strong>
                            </td>
                            <td>
                                <xsl:value-of select="memory"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Thẻ nhớ</strong>
                            </td>
                            <td>
                                <xsl:value-of select="memorycard"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Camera</strong>
                            </td>
                            <td>
                                <xsl:value-of select="maincamera"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Camera trước</strong>
                            </td>
                            <td>
                                <xsl:value-of select="subCamera"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Bộ vi xử lý</strong>
                            </td>
                            <td>
                                <xsl:value-of select="chipName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>HDH</strong>
                            </td>
                            <td>
                                <xsl:value-of select="os"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Pin</strong>
                            </td>
                            <td>
                                <xsl:value-of select="battery"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>Màu</strong>
                            </td>
                            <td>
                                <xsl:value-of select="color"/>
                            </td>
                        </tr>                                                                                                  
                    </tbody>
                </table>

            </div>
            <div class="tab-pane" id="tab2">
                <h5>
                    <xsl:value-of select="productName"/>
                </h5>
            </div>


        </div>
    </xsl:template>

</xsl:stylesheet>
