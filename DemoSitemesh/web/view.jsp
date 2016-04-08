<%-- 
    Document   : view
    Created on : Apr 8, 2016, 9:34:42 AM
    Author     : Gunner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.productName}</title>
    </head>
    <body>
        <!-- Items -->
        <div class="items">
            <div class="container">
                <div class="row">

                    <!-- Sidebar -->
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

                        <!-- Breadcrumbs -->
                        <ul class="breadcrumb">
                            <li><a href="./">Home</a></li>
                                <c:url value="CenterServlet" var="catalogUrl">
                                    <c:param name="btnAction" value="filter"></c:param>
                                    <c:param name="catalogName" value="${param.catalogName}"></c:param>
                                    <c:param name="catalogId" value="${param.catalogId}"></c:param>
                                </c:url>
                            <li><a href="${catalogUrl}">${param.catalogName}</a></li>
                                <c:if test="${not empty param.brandName}">
                                    <c:url var="brandURL" value="CenterServlet">
                                        <c:param name="btnAction" value="filterName"></c:param>
                                        <c:param name="brandID" value="${param.brandID}"></c:param>
                                        <c:param name="brandName" value="${param.brandName}"></c:param>
                                        <c:param name="catalogName" value="${param.catalogName}"></c:param>
                                        <c:param name="catalogId" value="${param.catalogId}"></c:param>
                                    </c:url>
                                <li><a href="${brandURL}">${param.brandName}</a></li>
                                <li class="active">${param.productName}</li>
                                </c:if>
                                <c:if test="${empty param.brandName}">
                                <li class="active">${param.productName}</li>
                                </c:if>
                        </ul>
                        <c:import url="WEB-INF/productxsl.xsl" var="productxsl" charEncoding="UTF-8"></c:import>
                        <x:transform xml="${requestScope.product}" xslt="${productxsl}"></x:transform>

                    </div>                                                                    
                </div>
            </div>
        </div>
    </body>
</html>
