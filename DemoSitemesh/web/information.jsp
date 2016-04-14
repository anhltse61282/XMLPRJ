<%-- 
    Document   : information
    Created on : Apr 13, 2016, 10:27:49 PM
    Author     : Gunner
--%>

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
                    <form class="form-horizontal" method="POST" action="CenterServlet">
                    <div class="col-md-6">

                        <!-- Checkout page title -->
                        <h4 class="title"><i class="fa fa-shopping-cart"></i> Thanh toán</h4>

                        <!-- Sub title -->
                        <h5 class="title">Thông tin khách hàng</h5>
                        
                        <!-- Address and Shipping details form -->
                        <div class="form form-small">
                            <!-- Register form (not working)-->
                            
                                <!-- Name -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="name1">Họ tên:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtFullname">
                                    </div>
                                </div>   
                                <!-- Email -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="email1">Email</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtemail1">
                                    </div>
                                </div>
                                <!-- Telephone -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="telephone">Số điện thoại:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txttelephone">
                                    </div>
                                </div>  
                                <!-- Address -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="address">Địa chỉ:</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" rows="5" name="txtaddress"></textarea>
                                    </div>
                                </div>                           

                                <!-- State -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="city">Quận/huyện:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtstate">
                                    </div>
                                </div>                                               
                                <!-- City -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="city">Thành phố</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtcity">
                                    </div>
                                </div>    

                            
                        </div>

                        <hr />

                        <h5 class="title">Hình thức thanh toán:</h5>

                    <!-- Radio buttons to select payment type -->

                    <label class="radio-inline">
                        <input type="radio" name="optionsRadios" id="optionsRadios1" value="1" checked>
                        Debit Card
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadios" id="optionsRadios2" value="2">
                        Credit Card
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadios" id="optionsRadios3" value="3">
                        Internet Banking
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadios" id="optionsRadios4" value="4">
                        Cash On Delivery
                    </label>          
                    <label class="radio-inline">
                        <input type="radio" name="optionsRadios" id="optionsRadios5" value="5">
                        Paypal
                    </label>  
                        <!-- Payment details section -->
                        <!-- Title -->


                    </div>
                    <div class="col-md-6">
                        <h4 class="title">&nbsp;</h4>
                        <h5 class="title">Thông tin giao hàng</h5>
                        <div class="form form-small">
                            <!-- Register form (not working)-->
                            <form class="form-horizontal">
                                <!-- Name -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="name1">Họ tên:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtDelFullname">
                                    </div>
                                </div>   
                                <!-- Email -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="email1">Email</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtDelemail1">
                                    </div>
                                </div>
                                <!-- Telephone -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="telephone">Số điện thoại:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtDeltelephone">
                                    </div>
                                </div>  
                                <!-- Address -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="address">Địa chỉ:</label>
                                    <div class="col-md-6">
                                        <textarea class="form-control" rows="5" name="txtDeladdress"></textarea>
                                    </div>
                                </div>                           

                                <!-- State -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="city">Quận/huyện:</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtDelstate">
                                    </div>
                                </div>                                               
                                <!-- City -->
                                <div class="form-group">
                                    <label class="control-label col-md-2" for="city">Thành phố</label>
                                    <div class="col-md-6">
                                        <input type="text" class="form-control" name="txtDelcity">
                                    </div>
                                </div>    

                        </div>
                    </div>
                    <hr/>
                                      

                    <hr />
                    <input type="checkbox" name="chkCopy" onclick="copyInfor()"/> Giao hàng theo thông tin của tôi.
                    <!-- Confirm order button -->
                    <div class="row">
                        <div class="col-md-4 col-md-offset-8">
                            <div class="pull-right">
                                <button type="submit" name="btnAction" value="payment" class="btn btn-danger">Xác nhận</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
