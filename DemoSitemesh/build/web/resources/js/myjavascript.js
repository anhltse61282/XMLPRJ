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
            var container = document.getElementById("content");
//            alert(container);
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(line, "text/xml");
            var node = document.createElement("div");
            var textnode = document.createTextNode(  xmlDoc.getElementsByTagName("productName")[0].childNodes[0].nodeValue );         // Create a text node
            node.appendChild(textnode);
            container.appendChild(node);

        }
    }
}
