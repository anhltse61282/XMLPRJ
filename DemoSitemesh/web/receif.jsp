<%-- 
    Document   : receif
    Created on : Apr 14, 2016, 10:20:38 AM
    Author     : Gunner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receift</title>
    </head>
    <body>
        <div class="items">
            <div class="container">
                <div class="row">
                    <!-- Sidebar navigation-->

                    <c:set var="order" value="${requestScope.Order}"></c:set>
                        <div class="col-md-9 col-sm-9">
                            <!-- Title -->
                            <h4 class="title">Xác nhận:</h4>

                            <h4>Giao dịch thành công, cám ơn quý khách đã ủng hộ.</h4>
                            <p>Đơn hàng của bạn #id là <strong>${requestScope.orderID}</strong>.
                            <div class="formy well" id="formAuth">
                                <div class="form">
                                    <form class="form-horizontal" > 
                                        <div class="form-group">
                                            <label class="control-label col-md-3" for="password2">Tên khách hàng:</label>
                                            <div class="controls col-md-4">
                                                <label>${order.txtFullname}</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="password2">SDT:</label>
                                        <div class="controls col-md-4">
                                            <label>${order.txtphone}</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="password2">Email:</label>
                                        <div class="controls col-md-4">
                                            <label>${order.txtemail}</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="password2">Địa chỉ:</label>
                                        <div class="controls col-md-4">
                                            <label>${order.txtadd} ${order.txtstate} ${order.txtcity}</label>
                                        </div>
                                    </div>
                                </form > 
                                <hr>
                                <table class="table table-striped tcart">
                                    <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Đơn giá</th>
                                            <th>Tổng</th>

                                        </tr>
                                    </thead>
                                    <tbody id="cartViewChk">
                                        <c:forEach items="${requestScope.CartReq.cart}" var="item" varStatus="count">
                                            <!-- Login  form (not working)-->


                                            <tr>
                                                <td>${count.count}</td>
                                                <td>${item.value.deviceName}</td>
                                                <td>${item.value.quantity}</td>
                                        <fmt:setLocale value="en_US"/>
                                        <td><fmt:formatNumber  pattern="###,###" type="number" value="${item.value.price}"></fmt:formatNumber>VND</td>
                                        <td><fmt:formatNumber  pattern="###,###" type="number" value="${item.value.totalPrice}"></fmt:formatNumber>VND</td>

                                        </tr>


                                    </c:forEach>
                                    <tr>
                                        <th></th>
                                        <th></th>
                                        <th></th>
                                        <th>Tổng cộng:</th>
                                        <th><fmt:formatNumber  pattern="###,###" type="number" value="${requestScope.CartReq.total}"></fmt:formatNumber>VND</th>
                                    <th></th>

                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <form method="GET" action="CenterServlet">
                                        <tr>
                                            <td colspan="6"> <button class="btn btn-danger" name="btnAction" value="exportPDF" type="submit">Xuất hóa đơn ra pdf</button></td>
                                        </tr>
                                    </form>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>



                </div>
            </div>
        </div>
    </body>
</html>
