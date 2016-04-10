<%-- 
    Document   : layout
    Created on : Apr 6, 2016, 3:15:21 PM
    Author     : Gunner
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decor"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!-- Title here -->
        <title><decor:title></decor:title></title>
            <!-- Description, Keywords and Author -->
            <meta name="description" content="Your description">
            <meta name="keywords" content="Your,Keywords">
            <meta name="author" content="ResponsiveWebInc">


            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <!-- Styles -->
            <!-- Bootstrap CSS -->
            <link href="<c:url value="resources/css/bootstrap.min.css"></c:url>" rel="stylesheet">
            <!-- Sidebar nav -->
            <link href="<c:url value="resources/css/sidebar-nav.css"></c:url>" rel="stylesheet">
            <!-- Flex slider -->
            <link href="<c:url value="resources/css/flexslider.css"></c:url>" rel="stylesheet">
        <link href="<c:url value="resources/css/owl.carousel.css"></c:url>" rel="stylesheet">	
        <link href="<c:url value="resources/css/font-awesome.min.css"></c:url>" rel="stylesheet">		
            <!-- Custom CSS -->
            <link href="<c:url value="resources/css/style.css"></c:url>" rel="stylesheet">
            <!-- Stylesheet for Color -->
            <link href="<c:url value="resources/css/red.css"></c:url>" rel="stylesheet">

            <!-- Favicon -->
            <link rel="shortcut icon" href="<c:url value="resources/img/favicon/favicon-32x32.png"></c:url>">
        </head>

        <body onload="viewCart()">

            <!-- Cart, Login and Register form (Modal) -->
            <!-- Cart Modal starts -->

            <div id="cart" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4>Giỏ hàng của bạn:</h4>
                        </div>
                        <div class="modal-body">
                            <table class="table table-striped tcart">
                                <thead>
                                    <tr>
                                        <th>Tên sản phẩm</th>
                                        <th>Số lượng</th>
                                        <th>Đơn giá</th>
                                        <th>Tổng</th>
                                    </tr>
                                </thead>
                                <tbody id="cartView">
                                <c:if test="${ empty sessionScope.Cart}">
                                    <tr>
                                        <td colspan="4">Không có sản phẩm nào</td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="index.html" class="btn">Tiếp tực mua sắm</a>
                        <a href="checkout.html" class="btn btn-danger">Thanh Toán</a>
                    </div>
                </div>
            </div>
        </div>

        <!--/ Cart modal ends -->

        <!-- Login Modal starts -->
        <div id="login" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4>Login</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form">
                            <form class="form-horizontal">   
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="username">Username</label>
                                    <div class="col-md-7">
                                        <input type="text" class="form-control" id="username">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="email">Password</label>
                                    <div class="col-md-7">
                                        <input type="password" class="form-control" id="password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-7 col-md-offset-3">
                                        <div class="checkbox inline">
                                            <label>
                                                <input type="checkbox" id="inlineCheckbox1" value="agree"> Remember Password
                                            </label>
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="col-md-7 col-md-offset-3">
                                        <button type="submit" class="btn btn-default">Login</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
                                    </div>
                                </div>
                            </form>
                        </div> 
                    </div>
                    <div class="modal-footer">
                        <p>Dont have account? <a href="register.html">Register</a> here.</p>
                    </div>
                </div>
            </div>
        </div>
        <!--/ Login modal ends -->

        <!-- Register Modal starts -->
        <div id="register" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4>Register</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="name">Name</label>
                                    <div class="col-md-7">
                                        <input type="text" class="form-control" id="name">
                                    </div>
                                </div>   
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="email">Email</label>
                                    <div class="col-md-7">
                                        <input type="text" class="form-control" id="email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3">Drop Down</label>
                                    <div class="col-md-7">                               
                                        <select class="form-control">
                                            <option>&nbsp;</option>
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>  
                                    </div>
                                </div>           
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="username1">Username</label>
                                    <div class="col-md-7">
                                        <input type="text" class="form-control" id="username1">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3" for="password1">Password</label>
                                    <div class="col-md-7">
                                        <input type="password" class="form-control" id="password1">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-7 col-md-offset-3">
                                        <div class="checkbox inline">
                                            <label>
                                                <input type="checkbox" id="inlineCheckbox2" value="agree"> Agree with Terms and Conditions
                                            </label>
                                        </div>
                                    </div>
                                </div> 

                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button type="submit" class="btn btn-default">Register</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <p>Already have account? <a href="login.html">Login</a> here.</p>
                    </div>
                </div>
            </div>
        </div>
        <!--/ Register modal ends -->

        <!-- Header starts -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <!-- Logo. Use class "color" to add color to the text. -->
                        <div class="logo">
                            <h1><a href="#">T & A <span class="color bold">Mobile</span></a></h1>
                            <p class="meta">Mọi người cùng alo</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-md-offset-4">

                        <!-- Search form -->
                        <form role="form" method="Get" action="CenterServlet">
                            <div class="input-group">
                                <input type="text" class="form-control" id="txtSearch" placeholder="Search">
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-default" name="btnSearch" value="Search" onclick="searchByName()">Search</button>
                                </span>
                            </div>
                        </form>

                        <div class="hlinks">
                            <span  id="cartDetail">
                                <!-- item details with price -->
                                <c:set var="cart" value="${sessionScope.Cart}"></c:set>
                                <c:if test="${empty cart}">
                                    <a href="#cartViewModal" role="button" data-toggle="modal" >
                                        0 Item(s) in your <i class="fa fa-shopping-cart"></i>
                                    </a> -<span class="bold">$0</span>  
                                </span>
                            </c:if>
                            <c:if test="${not empty cart}">
                                <a href="#cart" role="button" data-toggle="modal" >
                                    ${cart.size} Item(s) in your <i class="fa fa-shopping-cart"></i>
                                </a> -<span class="bold"><fmt:formatNumber  pattern="###,###" type="number" value="${cart.total}"></fmt:formatNumber>VND</span>  
                                    </span>
                            </c:if>
                            </span>
                            <!-- Login and Register link -->
                            <span class="lr"><a href="#login" role="button" data-toggle="modal">Login</a>
                                or <a href="#register" role="button" data-toggle="modal">Register</a></span>
                        </div>

                    </div>
                </div>
            </div>
        </header>
        <!--/ Header ends -->

        <!-- Navigation -->
        <div class="navbar bs-docs-nav" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                    <ul class="nav navbar-nav">
                        <li >
                            <a href="/DemoSitemesh">TRANG CHỦ</a>

                        </li>
                        <c:forEach items="${requestScope.catalogs}" var="catalog">
                            <li >
                                <c:url value="CenterServlet" var="catalogUrl">
                                    <c:param name="btnAction" value="filter"></c:param>
                                    <c:param name="catalogName" value="${catalog.catalogName}"></c:param>
                                    <c:param name="catalogId" value="${catalog.ID}"></c:param>
                                </c:url>
                                <a href="${catalogUrl}" >${catalog.catalogName}</a>

                            </li>                   
                        </c:forEach>
                    </ul>
                </nav>
            </div>
        </div>
        <!--/ Navigation End -->
        <decor:body/>


        <!-- Footer starts -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="widget">
                                    <h5>Contact</h5>
                                    <hr />
                                    <div class="social">
                                        <a href="#"><i class="fa fa-facebook facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter twitter"></i></a>
                                        <a href="#"><i class="fa fa-linkedin linkedin"></i></a>
                                        <a href="#"><i class="fa fa-google-plus google-plus"></i></a> 
                                    </div>
                                    <hr />
                                    <i class="fa fa-home"></i> &nbsp; A10-03, An Loc Apartment, HCMC, Vietnam.
                                    <hr />
                                    <i class="fa fa-phone"></i> &nbsp; 0937199446
                                    <hr />
                                    <i class="fa fa-envelope-o"></i> &nbsp; <a href="mailto:#">anhltse61282@fpt.edu.vn</a>
                                    <hr />

                                </div>
                            </div>

                        </div>
                        <hr />
                        <!-- Copyright info -->

                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </footer> 	
        <!--/ Footer ends -->

        <!-- Scroll to top -->
        <span class="totop"><a href="#"><i class="fa fa-chevron-up"></i></a></span> 

        <!-- Javascript files -->
        <!-- jQuery -->
        <script src="<c:url value="resources/js/jquery.js"></c:url>"></script>
            <!-- Bootstrap JS -->
            <script src="<c:url value="resources/js/bootstrap.min.js"></c:url>"></script> 
        <script src="<c:url value="resources/js/owl.carousel.min.js"></c:url>"></script> 
        <script src="<c:url value="resources/js/filter.js"></c:url>"></script> 
            <!-- Flex slider -->
            <script src="<c:url value="resources/js/jquery.flexslider-min.js"></c:url>"></script> 
            <!-- Respond JS for IE8 -->
            <script src="<c:url value="resources/js/respond.min.js"></c:url>"></script>
            <!-- HTML5 Support for IE -->
            <script src="<c:url value="resources/js/html5shiv.js"></c:url>"></script>
            <!-- Custom JS -->
            <script src="<c:url value="resources/js/custom.js"></c:url>"></script>
        <script src="<c:url value="resources/js/myjavascript.js"></c:url>"></script>
    </body>	
</html>

