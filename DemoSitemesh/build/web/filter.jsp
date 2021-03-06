<%-- 
    Document   : filter
    Created on : Apr 7, 2016, 10:24:28 PM
    Author     : Gunner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:if test="${not empty param.brandName}"><title>${param.brandName}</title></c:if>
        <c:if test="${ empty param.brandName}"><title>${param.catalogName}</title></c:if>
        </head>
        <body>
            <div class="items">
                <div class="container" id = "productDiv">
                    <div class="row">
                        <div class="col-md-3 col-sm-3 hidden-xs">

                            <h5 class="title">Categories</h5>
                            <!-- Sidebar navigation -->
                            <nav>
                                <ul id="nav">
                                    <!-- Main menu. Use the class "has_sub" to "li" tag if it has submenu. -->
                                    <li><a href="./">Home</a></li>
                                    <c:forEach items="${requestScope.brands}" var="brand">
                                        <c:url var="brandURL" value="CenterServlet">
                                            <c:param name="btnAction" value="filterName"></c:param>
                                            <c:param name="brandID" value="${brand.id}"></c:param>
                                            <c:param name="brandName" value="${brand.brandName}"></c:param>
                                            <c:param name="catalogName" value="${param.catalogName}"></c:param>
                                            <c:param name="catalogId" value="${param.catalogId}"></c:param>
                                        </c:url>
                                    <li><a href="${brandURL}">${brand.brandName}</a> </li>
                                    </c:forEach>
                            </ul>
                        </nav>
                        <br />


                    </div>
                    <!-- Main content -->
                    <div class="col-md-9 col-sm-9">

                        <!-- Breadcrumb -->
                        <ul class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="items.html">${param.catalogName}</a></li>

                            <li class="active">${param.brandName}</li>
                        </ul>

                        <!-- Title -->
                        <h4 class="pull-left">${param.brandName}</h4>


                        <!-- Sorting -->
                        <div class="form-group pull-right">                               
                            <select class="form-control" id="slSort" onchange="fnSort()">
                                <c:if test="${param.slSort != null}">
                                    <option  value="">Sắp xếp theo</option>
                                </c:if>
                                <c:if test="${param.slSort == null}">
                                    <option selected="selected" value="">Sắp xếp theo</option>
                                </c:if>
                                <c:if test="${param.slSort eq 'AZ'}">
                                    <option value="AZ" selected="selected">Tên sản phẩm (A-Z)</option>
                                </c:if>
                                <c:if test="${param.slSort != 'AZ'}">
                                    <option value="AZ" >Tên sản phẩm (A-Z)</option>
                                </c:if>
                                <c:if test="${param.slSort eq 'ZA'}">
                                    <option value="ZA" selected="selected">Tên sản phẩm (Z-A)</option>
                                </c:if>
                                <c:if test="${param.slSort != 'ZA'}">
                                    <option value="ZA" > Tên sản phẩm (Z-A)</option>
                                </c:if>
                                <c:if test="${param.slSort eq 'ASD'}">
                                    <option value="ASD" selected="selected">Giá (thấp-cao)</option>
                                </c:if>
                                    <c:if test="${param.slSort != 'ASD'}">
                                    <option value="ASD" >Giá (thấp-cao)</option>
                                </c:if>
                                <c:if test="${param.slSort eq 'DESC'}">
                                    <option value="DESC" selected="selected">Giá (cao-thấp)</option>
                                </c:if>
                                    <c:if test="${param.slSort != 'DESC'}">
                                    <option value="DESC">giá (cao-thấp)</option>
                                </c:if>
                                <option>Ratings</option>
                            </select>  
                        </div>

                        <div class="clearfix"></div>

                        <div class="row" >

                            <c:forEach items="${requestScope.products}" var="item">
                                <div class="col-md-4 col-sm-6">
                                    <!-- Each item should be enclosed in "item" class -->
                                    <div class="item">
                                        <!-- Item image -->
                                        <c:url var="viewDevice" value="CenterServlet">
                                            <c:param name="btnAction" value="View"></c:param>
                                            <c:param name="deviceID" value="${item.id}"></c:param>
                                            <c:param name="brandID" value="${param.brandID}"></c:param>
                                            <c:param name="brandName" value="${param.brandName}"></c:param>
                                            <c:param name="catalogName" value="${param.catalogName}"></c:param>
                                            <c:param name="catalogId" value="${param.catalogId}"></c:param>
                                            <c:param name="productName" value="${item.productName}"></c:param>
                                        </c:url>
                                        <div class="item-image">
                                            <a href="${viewDevice}"><img src="${item.imageLink}" alt="" class="img-responsive" /></a>
                                        </div>
                                        <!-- Item details -->
                                        <div class="item-details">
                                            <!-- Name -->
                                            <!-- Use the span tag with the class "ico" and icon link (hot, sale, deal, new) -->
                                            <h5><a href="${viewDevice}">${item.productName}</a> <br/><span> <font color="red"> ${item.source}</font></span></h5>
                                            <div class="clearfix"></div>
                                            <!-- Para. Note more than 2 lines. -->

                                            <hr />
                                            <!-- Price -->
                                            <fmt:setLocale value="en_US"/>
                                            <div class="item-price pull-left"><fmt:formatNumber  pattern="###,###" type="number" value="${item.price}"></fmt:formatNumber>đ</div>
                                                <!-- Add to cart -->
                                                <div class="button pull-right"><a href="#" name="addtocart" onclick="addcart(${item.id})" id ="${item.id}">Mua ngay</a></div>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>
                            <c:set var="defaultpage" value="${param.p}"></c:set>
                                <div class="col-md-9 col-sm-9">

                                    <div class="paging">
                                    <c:set var="action" value="${param.btnAction}"></c:set>
                                    <c:if test="${action eq 'filter'}">
                                        <c:forEach items="${requestScope.sizeBrand}" var="size">

                                            <c:url var="viewDevicepage" value="CenterServlet">
                                                <c:param name="btnAction" value="filter"></c:param>
                                                <c:param name="brandID" value="${param.brandID}"></c:param>
                                                <c:param name="brandName" value="${param.brandName}"></c:param>
                                                <c:param name="catalogName" value="${param.catalogName}"></c:param>
                                                <c:param name="catalogId" value="${param.catalogId}"></c:param>
                                                <c:param name="p" value="${size}"></c:param>
                                                <c:param name="slSort" value="${param.slSort}"></c:param>
                                            </c:url>
                                            <!-- Pagination -->    

                                            <c:if test="${size != param.p}">
                                                <a href='${viewDevicepage}'>${size}</a>
                                            </c:if>
                                            <c:if test="${size == param.p}">
                                                <span href='${viewDevicepage}' class="current">${size}</span>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${action eq 'filterName'}">
                                        <c:forEach items="${requestScope.size}" var="size">

                                            <c:url var="viewDevicepage" value="CenterServlet">
                                                <c:param name="btnAction" value="filterName"></c:param>
                                                <c:param name="brandID" value="${param.brandID}"></c:param>
                                                <c:param name="brandName" value="${param.brandName}"></c:param>
                                                <c:param name="catalogName" value="${param.catalogName}"></c:param>
                                                <c:param name="catalogId" value="${param.catalogId}"></c:param>
                                                <c:param name="p" value="${size}"></c:param>
                                                <c:param name="slSort" value="${param.slSort}"></c:param>
                                            </c:url>
                                            <!-- Pagination -->    

                                            <c:if test="${size != param.p}">
                                                <a href='${viewDevicepage}'>${size}</a>
                                            </c:if>
                                            <c:if test="${size == param.p}">
                                                <span href='${viewDevicepage}' class="current">${size}</span>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </div>

                            </div>           

                        </div>
                    </div>  
                </div>
            </div>
        </div>
    </body>
</html>
