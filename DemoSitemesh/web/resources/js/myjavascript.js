/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validateReg() {
    var chekCopy = document.getElementsByName("chkCopy")[0];
    var txtname = document.getElementsByName("txtFullname")[0];
    var txtemail = document.getElementsByName("txtemail1")[0];
    var txtphone = document.getElementsByName("txttelephone")[0];
    var txtadd = document.getElementsByName("txtaddress")[0];
    var txtstate = document.getElementsByName("txtstate")[0];
    var txtcity = document.getElementsByName("txtcity")[0];
    var txtDelname = document.getElementsByName("txtDelFullname")[0];
    var txtDelemail = document.getElementsByName("txtDelemail1")[0];
    var txtDelphone = document.getElementsByName("txtDeltelephone")[0];
    var txtDeladd = document.getElementsByName("txtDeladdress")[0];
    var txtDelstate = document.getElementsByName("txtDelstate")[0];
    var txtDelcity = document.getElementsByName("txtDelcity")[0];
    var userErr = document.getElementById("userErr");
    if (txtname.value == "") {
        alert("false");
        userErr.innerHTML = "Tên không được để trống";
        return false;
    }
}
function fnSort() {
    var select = document.getElementById("slSort");
    var value = select.options[select.selectedIndex].value;
    var url = window.location.href;
    var contain = window.location.href.indexOf("&slSort") > -1;
    var reUrl;
    if (contain === true) {
        reUrl = url.split("&slSort=");
        reUrl = reUrl[0] + "&slSort=" + value;
    } else {
        reUrl = url + "&slSort=" + value;
    }
    contain = window.location = reUrl;

}
function radiohandler() {
    var ex1 = document.querySelector('input[name = "rdLogin"]:checked').value;
    var form = document.getElementById("formAuth");
    if (ex1 == "newCus") {
        form.innerHTML = "<h4 class='title'>Đăng ký tài khoản</h4>" +
                "<div class='form' >" +
                "<form class='form-horizontal' method='Post' action='CenterServlet'>" +
                "<div class='form-group'>" +
                "<label class='control-label col-md-3' for='username2'>Tài khoản</label>" +
                "<div class='col-md-8'>" +
                "<input type='text' class='form-control' id='username2' name='txtUsername'>" +
                "</div>" +
                "</div>" +
                "<!-- Password -->" +
                " <div class='form-group'>" +
                "<label class='control-label col-md-3' for='password2'>Mật khẩu</label>" +
                "<div class='controls col-md-8'>" +
                "<input type='password' class='form-control' id='password2' name='txtPassword'>" +
                "</div>" +
                "</div>" +
                " <div class='form-group'>" +
                "<label class='control-label col-md-3' for='password2'>Nhập lại</label>" +
                "<div class='controls col-md-8'>" +
                "<input type='password' class='form-control' id='password2' name='txtRePassword'>" +
                "</div>" +
                "</div>" +
                "<div class='form-group'>" +
                "<div class='col-md-8 col-md-offset-3'>" +
                "<button type='submit' class='btn btn-danger' name='btnAction' value='Register'>Đăng kỳ</button>" +
                "<button type='reset' class='btn btn-default'>Reset</button>" +
                "</div>" +
                "</div></form></div>";
    } else {
        form.innerHTML =
                "<h4 class='title'>Đăng nhập</h4>" +
                "<div class='form' method='Post' action='CenterServlet'>" +
                "<form class='form-horizontal'>" +
                "<div class='form-group'>" +
                "<label class='control-label col-md-3' for='username2'>Tài khoản</label>" +
                "<div class='col-md-8'>" +
                "<input type='text' class='form-control' id='username2' name='txtUsername'>" +
                "</div>" +
                "</div>" +
                "<!-- Password -->" +
                " <div class='form-group'>" +
                "<label class='control-label col-md-3' for='password2'>Mật Khẩu</label>" +
                "<div class='controls col-md-8'>" +
                "<input type='password' class='form-control' id='password2' name='txtUsername'>" +
                "</div>" +
                "</div>" +
                "<div class='form-group'>" +
                "<div class='col-md-8 col-md-offset-3'>" +
                "<button type='submit' class='btn btn-danger' name='btnAction' value='Login'>Đăng nhập</button>" +
                "<button type='reset' class='btn btn-default'>Reset</button>" +
                "</div>" +
                "</div></form></div>";
    }
}
var httpRequest;
function searchByName() {

    var txtSearch = document.getElementById("txtSearch");
    var url = "/DemoSitemesh/CenterServlet?btnAction=Search&txtSearch=" + txtSearch.value;
//    alert(url);
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    }
    httpRequest.onreadystatechange = responseSearchHandler;
    httpRequest.open('GET', url, true);
    httpRequest.send(url);
}
function responseSearchHandler() {
    if (httpRequest.readyState == 4) {
        if (httpRequest.status == 200) {
            var line = httpRequest.responseText;
            var container = document.getElementById("productDiv");

//            alert(container);
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(line, "text/xml");
//            var node = document.createElement("div");
//            var textnode = document.createTextNode(  xmlDoc.getElementsByTagName("productName")[0].childNodes[0].nodeValue );         // Create a text node
//            node.appendChild(textnode);
//            container.appendChild(node);
            var list = [];
            var details = xmlDoc.getElementsByTagName("Devices")[0].childNodes;
            for (var i = 0; i < details.length; i++) {
                var productName = "";
                var productID = "";
                var imageLnk = "";
                var price = "";
                var brandID = "";
                var catalogID = "";
                var source = "";
                var result = "";
                if (details[i].childNodes) {
                    for (var j = 0; j < details[i].childNodes.length; j++) {
                        var detail = details[i].childNodes[j];
                        if (detail.nodeType === 1) {
                            if (detail.nodeName == "id") {
                                productID = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "productName") {
                                productName = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "price") {
                                price = detail.firstChild.nodeValue;
                            } else if (detail.nodeName == "catalogID") {
                                catalogID = detail.firstChild.nodeValue;
                            } else if (detail.nodeName == "brandID") {
                                brandID = detail.firstChild.nodeValue;
                            } else if (detail.nodeName == "imageLink") {
                                imageLnk = detail.firstChild.nodeValue;
                            } else if (detail.nodeName == "source") {
                                source = detail.firstChild.nodeValue;
                            }
                        }
                    }
                    if (productID != "" && imageLnk != "" && productName != "" && price != "") {
                        result = "<div class='col-md-4 col-sm-6'><div class='item'><div class='item-image'>" +
                                "<a href='./CenterServlet?btnAction=View&deviceID=" + productID + "&catalogId=" + catalogID + "&productName=" + productName + "'><img src='" + imageLnk + "'  class='img-responsive' /></a></div>" +
                                "<div class='item-details'>" +
                                "<h5><a href='./CenterServlet?btnAction=View&deviceID=" + productID + "&catalogId=" + catalogID + "&productName=" + productName + "'>" + productName + "</a>" +
                                "<span ><br/>" + source + "</span>" + "</h5>" +
                                " <div class='clearfix'></div>" +
                                "<hr />" +
                                "<div class='item-price pull-left'>" + formatNumber(price) + 'đ' + "</div>" +
                                "<div class='button pull-right'><a href='#' onclick='addcart(" + productID.trim() + ")'>Mua ngay</a></div>" +
                                "<div class='clearfix'></div>" +
                                "</div>" + " </div>" + " </div> ";
//                alert(result);
//                alert(productName + " " + imageLnk + " " + price);
                        list.push(result);
                    }
                }


//                alert(result);
            }
            var element = "";
            for (var i = 0; i < list.length; i++) {
                element += list[i];

            }
            container.innerHTML = "<div class='col-md-12'>" +
                    "<h3 class='title'>Kết quả tìm kiếm:</h3>" +
                    "</div>" + element;
        }
    }
}
function formatNumber(number)
{
    number = parseInt(number).toFixed(0) + '';
    x = number.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}
function addcart(id) {

    var deviceID = id;
    var url = "/DemoSitemesh/CenterServlet?btnAction=Addtocart&deviceID=" + deviceID;
//    alert(url);
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    }
    httpRequest.onreadystatechange = responseAddCartHandler;
    httpRequest.open('GET', url, true);
    httpRequest.send(url);
}
function responseAddCartHandler() {
    if (httpRequest.readyState == 4) {
        if (httpRequest.status == 200) {
            var responseText = httpRequest.responseText;

            var cartDetail = document.getElementById("cartDetail");
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(responseText, "text/xml");

            var numberDevices = xmlDoc.getElementsByTagName("numberdevive")[0].childNodes[0].nodeValue;
            var totalPrice = xmlDoc.getElementsByTagName("totalPrice")[0].childNodes[0].nodeValue;

            cartDetail.innerHTML = "<a href='#cart' role='button' data-toggle='modal'>" +
                    numberDevices + " sản phẩm trong <i class='fa fa-shopping-cart'></i>" +
                    "</a> - <span class='bold'> " + formatNumber(totalPrice) + " VND" + "</span>";
            viewCart();
        }
    }
}
function viewCart() {

    var url = "/DemoSitemesh/CenterServlet?btnAction=ViewCart";
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    }
    httpRequest.onreadystatechange = responseViewCartHandler;
    httpRequest.open('GET', url, true);
    httpRequest.send(url);
//    alert(cartTabl.innerHTML);
}
function responseViewCartHandler() {
    if (httpRequest.readyState == 4) {
        if (httpRequest.status == 200) {
            var responseText = httpRequest.responseText;

            parser = new DOMParser();
            xmlDoc = parser.parseFromString(responseText, "text/xml");
            var details = xmlDoc.getElementsByTagName("order")[0].childNodes;
            var result = "";
            var totalOrder = 0;
            var count = 0;
            for (var i = 0; i < details.length; i++) {
                var deviceName = "";
                var quantity = "";
                var price = "";
                var totalPrice = "";
                var id = "";
                if (details[i].childNodes) {
                    for (var j = 0; j < details[i].childNodes.length; j++) {
                        var detail = details[i].childNodes[j];
                        if (detail.nodeType === 1) {
                            if (detail.nodeName == "id") {
                                id = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "deviceName") {
                                deviceName = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "quantity") {
                                quantity = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "price") {
                                price = detail.firstChild.nodeValue;
                            } else if (detail.nodeName == "totalPrice") {
                                totalPrice = detail.firstChild.nodeValue;
                            }
                        }
                    }
                }
                if (deviceName != "" || quantity != "" || price != "" || totalPrice != "") {
                    count = count + 1;
                    result = result + "<tr>" +
                            "<td>" +
                            count +
                            "</td>" +
                            "<td>" +
                            deviceName +
                            "</td>" +
                            "<td>" +
                            quantity +
                            "</td>" +
                            "<td>" +
                            formatNumber(price) + " VND" +
                            "</td>" +
                            "<td>" +
                            formatNumber(totalPrice) + " VND" +
                            "</td>" +
                            "<td>" +
                            "<div class='hlinks' data-toggle='modal'><a href='#' role='button' onclick='deletecart( " + id + " )'>Xóa</a></div>" +
                            "</td>" +
                            "</tr>";
                    totalOrder = parseInt(totalOrder) + parseInt(totalPrice);
                }
            }

            var cartTabl = document.getElementById("cartView");
            cartTabl.innerHTML = result + "<tr>" + "<th></th>" + "<th></th><th></th>" + "<th>Total:</th>" + "<th>" + formatNumber(totalOrder) + " VND" + "</th>" + "<th></th></tr>";

        }
    }
}
function deletecart(id) {
//    alert(id);
    var url = "/DemoSitemesh/CenterServlet?btnAction=removeCart&deviceID=" + id;
    if (window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    }
    httpRequest.onreadystatechange = responseRemoveCartHandler;
    httpRequest.open('GET', url, true);
    httpRequest.send(url);
//    alert(cartTabl.innerHTML);

}
function responseRemoveCartHandler() {
    if (httpRequest.readyState == 4) {
        if (httpRequest.status == 200) {
            var response = httpRequest.responseText;
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(response, "text/xml");

            var details = xmlDoc.getElementsByTagName("order")[0].childNodes;
            var result = "";
            var sizeCart = xmlDoc.getElementsByTagName("order")[0].getAttribute("size");
            var totalprice = xmlDoc.getElementsByTagName("order")[0].getAttribute("total");

            var totalOrder = 0;
            var count = 0;
            for (var i = 0; i < details.length; i++) {
                var deviceName = "";
                var quantity = "";
                var price = "";
                var totalPrice = "";
                var id = "";
                if (details[i].childNodes) {
                    for (var j = 0; j < details[i].childNodes.length; j++) {
                        var detail = details[i].childNodes[j];
                        if (detail.nodeType === 1) {
                            if (detail.nodeName == "id") {
                                id = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "deviceName") {
                                deviceName = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "quantity") {
                                quantity = detail.firstChild.nodeValue;
//                                alert("details node " + (i + 1) + ": " + detail.nodeName + "=" + detail.firstChild.nodeValue);
                            } else if (detail.nodeName == "price") {
                                price = detail.firstChild.nodeValue;
                            } else if (detail.nodeName == "totalPrice") {
                                totalPrice = detail.firstChild.nodeValue;
                            }
                        }
                    }
                }
                if (deviceName != "" || quantity != "" || price != "" || totalPrice != "") {
                    count = count + 1;
                    result = result + "<tr>" +
                            "<td>" +
                            count +
                            "</td>" +
                            "<td>" +
                            deviceName +
                            "</td>" +
                            "<td>" +
                            quantity +
                            "</td>" +
                            "<td>" +
                            formatNumber(price) + " VND" +
                            "</td>" +
                            "<td>" +
                            formatNumber(totalPrice) + " VND" +
                            "</td>" +
                            "<td>" +
                            "<div class='hlinks' data-toggle='modal'><a href='#' role='button' onclick='deletecart( " + id + " )'>Xóa</a></div>" +
                            "</td>" +
                            "</tr>";
                    totalOrder = parseInt(totalOrder) + parseInt(totalPrice);
                }
            }
            var cartTabl = document.getElementById("cartView");
            var cartTable2 = document.getElementById("cartViewChk");
            if (cartTabl != null) {
                cartTabl.innerHTML = result + "<tr>" + "<th></th>" + "<th></th><th></th>" + "<th>Total:</th>" + "<th>" + formatNumber(totalOrder)
                        + " VND" + "</th>" + "<th></th></tr>";
            }
            if (cartTable2 != null) {
                cartTable2.innerHTML = result + "<tr>" + "<th></th>" + "<th></th><th></th>" + "<th>Total:</th>" + "<th>" + formatNumber(totalOrder)
                        + " VND" + "</th>" + "<th></th></tr>";
            }
            var cartDetail = document.getElementById("cartDetail");
            cartDetail.innerHTML = "<a href='#cart' role='button' data-toggle='modal'>" +
                    sizeCart + " sản phẩm trong <i class='fa fa-shopping-cart'></i>" +
                    "</a> - <span class='bold'> " + formatNumber(totalprice) + " VND" + "</span>";
        }
    }
}
function copyInfor() {
    var chekCopy = document.getElementsByName("chkCopy")[0];
    var txtname = document.getElementsByName("txtFullname")[0];
    var txtemail = document.getElementsByName("txtemail1")[0];
    var txtphone = document.getElementsByName("txttelephone")[0];
    var txtadd = document.getElementsByName("txtaddress")[0];
    var txtstate = document.getElementsByName("txtstate")[0];
    var txtcity = document.getElementsByName("txtcity")[0];
    var txtDelname = document.getElementsByName("txtDelFullname")[0];
    var txtDelemail = document.getElementsByName("txtDelemail1")[0];
    var txtDelphone = document.getElementsByName("txtDeltelephone")[0];
    var txtDeladd = document.getElementsByName("txtDeladdress")[0];
    var txtDelstate = document.getElementsByName("txtDelstate")[0];
    var txtDelcity = document.getElementsByName("txtDelcity")[0];
    if (chekCopy.checked) {


        txtDelname.value = txtname.value;
        txtDelname.readOnly = true;
        txtDelemail.value = txtemail.value;
        txtDelemail.readOnly = true;
        txtDelphone.value = txtphone.value;
        txtDelphone.readOnly = true;
        txtDeladd.value = txtadd.value;
        txtDeladd.readOnly = true;
        txtDelcity.value = txtcity.value;
        txtDelcity.readOnly = true;
        txtDelstate.value = txtstate.value;
        txtDelstate.readOnly = true;
    } else {

        txtDelname.value = "";
        txtDelname.readOnly = false;
        txtDelemail.value = "";
        txtDelemail.readOnly = false;
        txtDelphone.value = "";
        txtDelphone.readOnly = false;
        txtDeladd.value = "";
        txtDeladd.readOnly = false;
        txtDelcity.value = "";
        txtDelcity.readOnly = false;
        txtDelstate.value = "";
        txtDelstate.readOnly = false;
    }
}