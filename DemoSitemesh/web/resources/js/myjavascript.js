/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                            }
                        }
                    }
                    if (productID != "" && imageLnk != "" && productName != "" && price != "") {
                        result = "<div class='col-md-4 col-sm-6'><div class='item'><div class='item-image'>" +
                                "<a href='./CenterServlet?btnAction=View&deviceID=" + productID + "&catalogId=" + catalogID + "&productName=" + productName + "'><img src='" + imageLnk + "'  class='img-responsive' /></a></div>" +
                                "<div class='item-details'>" +
                                "<h5><a href='./CenterServlet?btnAction=View&deviceID=" + productID + "&catalogId=" + catalogID + "&productName=" + productName + "'>" + productName + "</a>" +
                                "<span class='ico'><img src='resources/img/hot.png' alt='' /></span>" + "</h5>" +
                                " <div class='clearfix'></div>" +
                                "<hr />" +
                                "<div class='item-price pull-left'>" + formatNumber(price) + 'đ' + "</div>" +
                                "<div class='button pull-right'><a href='#'>Add to Cart</a></div>" +
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
                    numberDevices + " Item(s) in your <i class='fa fa-shopping-cart'></i>" +
                    "</a> -<span class='bold'> " + formatNumber(totalPrice) + " VND" + "</span>";
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
            cartTabl.innerHTML = result + "<tr>" + "<th></th>" + "<th></th><th></th>" + "<th>Total:</th>" + "<th>" + formatNumber(totalOrder) 
                    + " VND" + "</th>" + "<th></th></tr>";
            var cartDetail = document.getElementById("cartDetail");
            cartDetail.innerHTML = "<a href='#cart' role='button' data-toggle='modal'>" +
                    sizeCart + " Item(s) in your <i class='fa fa-shopping-cart'></i>" +
                    "</a> -<span class='bold'> " + formatNumber(totalprice) + " VND" + "</span>";
        }
    }
}