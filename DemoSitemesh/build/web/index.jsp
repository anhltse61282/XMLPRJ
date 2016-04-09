<%-- 
    Document   : index
    Created on : Apr 7, 2016, 10:57:45 AM
    Author     : Gunner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
    </head>
    <body>

        <div class="items">
            <div class="container"  id="productDiv">
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="title">HOT</h3>
                    </div>
                    <!-- Item #1 -->
                    <c:set var="countStt" value="0"></c:set>
                    <c:forEach items="${requestScope.devices}" var="item" begin="${countStt}" end="8">
                        <div class="col-md-3 col-sm-4">
                            <div class="item">
                                <!-- Item image -->
                                <c:url var="viewDevice" value="CenterServlet">
                                    <c:param name="btnAction" value="View"></c:param>
                                    <c:param name="deviceID" value="${item.id}"></c:param>
                                </c:url>
                                <div class="item-image">
                                    <a href="${viewDevice}"><img src="${item.imageLink}" alt="" /></a>
                                </div>
                                <!-- Item details -->
                                <div class="item-details">
                                    <!-- Name -->
                                    <!-- Use the span tag with the class "ico" and icon link (hot, sale, deal, new) -->

                                    <h5><a href="${viewDevice}">${item.productName}</a><span class="ico"><img src="<c:url value="resources/img/hot.png"></c:url>" alt="" /></span></h5>
                                        <div class="clearfix"></div>
                                        <!-- Para. Note more than 2 lines. -->

                                        <hr />
                                        <!-- Price -->
                                        <fmt:setLocale value="en_US"/>
                                        <div class="item-price pull-left"><fmt:formatNumber  pattern="###,###" type="number" value="${item.price}"></fmt:formatNumber>đ</div>
                                        <!-- Add to cart -->
                                        <div class="button pull-right"><a href="#">Add to Cart</a></div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                    </c:forEach>

                </div>
            </div>
        </div>

    </body>
</html>
