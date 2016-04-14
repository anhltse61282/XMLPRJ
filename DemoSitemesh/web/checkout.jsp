<%-- 
    Document   : checkout
    Created on : Apr 11, 2016, 2:20:53 PM
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
        <div class="checkout">
            <div class="container">
                <div class="row">
                    <h4 class="title">Khách hàng mới/Đăng nhập</h4>
                    <h5 class="title">
                        <input type="radio" name="rdLogin" value="oldCus" checked="checked" onclick="radiohandler()"/> Tôi đã có tài khoản <br/>
                        <input type="radio" name="rdLogin"  value="newCus" onclick="radiohandler()"/> Tôi là khách hàng mới 
                    </h5>
                    <div class="col-md-6">
                        <div class="formy well" id="formAuth">
                            <h4 class="title">Đăng nhập</h4>
                            <div class="form">

                                <!-- Login  form (not working)-->
                                <form class="form-horizontal" >                                         
                                    <!-- Username -->
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="username2">Tài khoản</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="username2">
                                        </div>
                                    </div>
                                    <!-- Password -->
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="password2">Mật Khẩu</label>
                                        <div class="controls col-md-8">
                                            <input type="password" class="form-control" id="password2">
                                        </div>
                                    </div>
                                   

                                    <!-- Buttons -->
                                    <div class="form-group">
                                        <!-- Buttons -->
                                        <div class="col-md-8 col-md-offset-3">
                                            <button type="submit" class="btn btn-danger">Đăng nhập</button>
                                            <button type="reset" class="btn btn-default">Reset</button>
                                        </div>
                                    </div>
                                </form>
                                <hr>
                                <h5>New Account</h5>
                                Don't have an Account? <a href="register.html">Register</a>
                            </div> 
                        </div>

                    </div>
                    <div class="col-md-6">
                        <div class="formy well" id="formAuth">
                            <h4 class="title">Đơn hàng:</h4>
                            <div class="form">
                                <table class="table table-striped tcart">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Đơn giá</th>
                                            <th>Tổng</th>
                                            <th>Xóa</th>
                                        </tr>
                                    </thead>
                                    <tbody id="cartViewChk">
                                        <c:forEach items="${sessionScope.Cart.cart}" var="item" varStatus="count">
                                            <!-- Login  form (not working)-->


                                            <tr>
                                                <td>${count.count}</td>
                                                <td>${item.value.deviceName}</td>
                                                <td>${item.value.quantity}</td>
                                                <fmt:setLocale value="en_US"/>
                                                <td><fmt:formatNumber  pattern="###,###" type="number" value="${item.value.price}"></fmt:formatNumber>VND</td>
                                                <td><fmt:formatNumber  pattern="###,###" type="number" value="${item.value.totalPrice}"></fmt:formatNumber>VND</td>
                                                <td><div class='hlinks' data-toggle='modal'><a href='#' role='button' onclick="deletecart(${item.value.id})">Xóa</a></div></td>
                                            </tr>


                                        </c:forEach>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th>Tổng cộng:</th>
                                                <th><fmt:formatNumber  pattern="###,###" type="number" value="${sessionScope.Cart.total}"></fmt:formatNumber>VND</th>
                                                <th></th>
                                                
                                            </tr>
                                    </tbody>
                                    <tfoot>
                                    <form method="GET" action="CenterServlet">
                                        <tr>
                                            <td colspan="6"> <button class="btn btn-danger" name="btnAction" value="chkOutWthout" type="submit">Tiếp tục mà không cần đăng nhập</button></td>
                                        </tr>
                                    </form>
                                    </tfoot>
                                </table>
                                <hr>

                            </div> 
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
