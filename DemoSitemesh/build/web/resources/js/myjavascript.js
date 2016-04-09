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
    httpRequest.onreadystatechange = responseHandler;
    httpRequest.open('POST', url, true);
    httpRequest.send(url);
}
function responseHandler() {
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
            var productName = "";
            var productID = "";
            var imageLnk = "";
            var price = "";
            var brandID = "";
            var catalogID = "";
            var list = [];
            var result = "";
            var details = xmlDoc.getElementsByTagName("Devices")[0].childNodes;
            for (var i = 0; i < details.length; i++) {
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
                }
                if (productID != "" && imageLnk != "" && productName != "" && price != "") {
                    result = "<div class='col-md-4 col-sm-6'><div class='item'><div class='item-image'>" +
                            "<a href='./CenterServlet?btnAction=View&deviceID=" + productID + "&catalogId=" + productID + "&productName=" + productName + "'><img src='" + imageLnk + "'  class='img-responsive' /></a></div>" +
                            "<div class='item-details'>" +
                            "<h5><a href='./CenterServlet?btnAction=View&deviceID=" + productID + "&catalogId=" + productID + "&productName=" + productName + "'>" + productName + "</a></h5>" +
                            " <div class='clearfix'></div>" +
                            "<hr />" +
                            "<div class='item-price pull-left'>" + price + 'đ' + "</div>" +
                            "<div class='button pull-right'><a href='#'>Add to Cart</a></div>" +
                            "<div class='clearfix'></div>" +
                            "</div>" + " </div>" + " </div> ";
//                alert(result);
//                alert(productName + " " + imageLnk + " " + price);

                }
                list.push(result);
//                alert(result);
            }
            var elemetn = "";
            for (var i = 0; i < list.length; i++) {
                elemetn += list[i];
            }
            container.innerHTML = elemetn;
        }
    }
}
