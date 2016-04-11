<%-- 
    Document   : checkout
    Created on : Apr 11, 2016, 2:20:53 PM
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
                    <h4 class="title">Khách hàng mới/Đăng nhập</h4>
                    <h5 class="title">
                        <input type="radio" name="rdLogin" value="oldCus" checked="checked" onclick="radiohandler()"/> Tôi đã có tài khoản <br/>
                        <input type="radio" name="rdLogin"  value="newCus" onclick="radiohandler()"/> Tôi là khách hàng mới 
                    </h5>
                    <div class="col-md-6">
                        <div class="formy well" id="formAuth">
                            <h4 class="title">Login to Your Account</h4>
                            <div class="form">

                                <!-- Login  form (not working)-->
                                <form class="form-horizontal" >                                         
                                    <!-- Username -->
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="username2">Username</label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="username2">
                                        </div>
                                    </div>
                                    <!-- Password -->
                                    <div class="form-group">
                                        <label class="control-label col-md-3" for="password2">Password</label>
                                        <div class="controls col-md-8">
                                            <input type="password" class="form-control" id="password2">
                                        </div>
                                    </div>
                                    <!-- Checkbox -->
                                    <div class="form-group">
                                        <div class="col-md-8 col-md-offset-3">
                                            <label class="checkbox-inline">
                                                <input type="checkbox" id="inlineCheckbox3" value="agree"> Remember Password
                                            </label>
                                        </div>
                                    </div> 

                                    <!-- Buttons -->
                                    <div class="form-group">
                                        <!-- Buttons -->
                                        <div class="col-md-8 col-md-offset-3">
                                            <button type="submit" class="btn btn-danger">Login</button>
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
                </div>
            </div>
        </div>
    </body>
</html>
