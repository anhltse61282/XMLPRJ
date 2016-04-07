<%-- 
    Document   : index
    Created on : Apr 7, 2016, 10:57:45 AM
    Author     : Gunner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${requestScope.catalogs}" var="catalog" varStatus="catalogcount">
            <div class="items">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="title">${catalog.catalogName}</h3>
                        </div>
                        <!-- Item #1 -->
                        <c:set var="countStt" value="0"></c:set>
                        <c:forEach items="${requestScope.devices}" var="item" varStatus="count">
                            
                            <c:if test="${countStt < 20}">
                                <c:if test="${item.catalogID eq catalog.ID}">
                                    <div class="col-md-3 col-sm-4">
                                        <div class="item">
                                            <!-- Item image -->
                                            <div class="item-image">
                                                <a href="single-item.html"><img src="${item.imageLink}" alt="" /></a>
                                            </div>
                                            <!-- Item details -->
                                            <div class="item-details">
                                                <!-- Name -->
                                                <!-- Use the span tag with the class "ico" and icon link (hot, sale, deal, new) -->
                                                <h5><a href="single-item.html">${item.productName}</a><span class="ico"><img src="img/hot.png" alt="" /></span></h5>
                                                <div class="clearfix"></div>
                                                <!-- Para. Note more than 2 lines. -->

                                                <hr />
                                                <!-- Price -->
                                                <div class="item-price pull-left"><fmt:formatNumber  value="${item.price}"></fmt:formatNumber>đ</div>
                                                    <!-- Add to cart -->
                                                    <div class="button pull-right"><a href="#">Add to Cart</a></div>
                                                    <div class="clearfix"></div>
                                                </div>
                                            </div>
                                        </div>
                                </c:if>
                            </c:if>
                            <c:if test="${countStt > 8}">
                                <c:set var="count.count" value="0"></c:set>
                            </c:if>
                            <c:set var="countStt" value="${countStt+1}"></c:set>
                        </c:forEach>

                        ${catalogcount.count}
                    </div>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
