package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"checkout\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <h4 class=\"title\">Khách hàng mới/Đăng nhập</h4>\n");
      out.write("                    <h5 class=\"title\">\n");
      out.write("                        <input type=\"radio\" name=\"rdLogin\" id=\"rdLoginopt\" value=\"oldCus\" checked=\"checked\"/> Tôi đã có tài khoản <br/>\n");
      out.write("                        <input type=\"radio\" name=\"rdLogin\" id=\"rdLoginopt\" value=\"newCus\" /> Tôi là khách hàng mới \n");
      out.write("                    </h5>\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <div class=\"formy well\">\n");
      out.write("                            <h4 class=\"title\">Login to Your Account</h4>\n");
      out.write("                            <div class=\"form\">\n");
      out.write("\n");
      out.write("                                <!-- Login  form (not working)-->\n");
      out.write("                                <form class=\"form-horizontal\">                                         \n");
      out.write("                                    <!-- Username -->\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label class=\"control-label col-md-3\" for=\"username2\">Username</label>\n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"username2\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Password -->\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <label class=\"control-label col-md-3\" for=\"password2\">Password</label>\n");
      out.write("                                        <div class=\"controls col-md-8\">\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" id=\"password2\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Checkbox -->\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-3\">\n");
      out.write("                                            <label class=\"checkbox-inline\">\n");
      out.write("                                                <input type=\"checkbox\" id=\"inlineCheckbox3\" value=\"agree\"> Remember Password\n");
      out.write("                                            </label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div> \n");
      out.write("\n");
      out.write("                                    <!-- Buttons -->\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <!-- Buttons -->\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-3\">\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-danger\">Login</button>\n");
      out.write("                                            <button type=\"reset\" class=\"btn btn-default\">Reset</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                                <hr>\n");
      out.write("                                <h5>New Account</h5>\n");
      out.write("                                Don't have an Account? <a href=\"register.html\">Register</a>\n");
      out.write("                            </div> \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
