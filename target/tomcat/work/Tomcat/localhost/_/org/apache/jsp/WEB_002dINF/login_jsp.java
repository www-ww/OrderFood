/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-26 03:26:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>用户登录</title>\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"https://cdn.staticfile.org/html5shiv/r29/html5.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("    <style>\r\n");
      out.write("        .main-body {top:50%;left:50%;position:absolute;-webkit-transform:translate(-50%,-50%);-moz-transform:translate(-50%,-50%);-ms-transform:translate(-50%,-50%);-o-transform:translate(-50%,-50%);transform:translate(-50%,-50%);overflow:hidden;}\r\n");
      out.write("        .login-main .login-bottom .center .item input {display:inline-block;width:227px;height:22px;padding:0;position:absolute;border:0;outline:0;font-size:14px;letter-spacing:0;}\r\n");
      out.write("        .login-main .login-bottom .tip .icon-nocheck {display:inline-block;width:10px;height:10px;border-radius:2px;border:solid 1px #9abcda;position:relative;top:2px;margin:1px 8px 1px 1px;cursor:pointer;}\r\n");
      out.write("        .login-main .login-bottom .tip .icon-check {margin:0 7px 0 0;width:14px;height:14px;border:none;background:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/plugins/layui/images/icon-login.png) no-repeat -111px -48px;}\r\n");
      out.write("        .login-main .login-bottom .center .item .icon {display:inline-block;width:33px;height:22px;}\r\n");
      out.write("        .login-main .login-bottom .center .item {width:288px;height:35px;border-bottom:1px solid #dae1e6;margin-bottom:35px;}\r\n");
      out.write("        .login-main {width:428px;position:relative;float:left;}\r\n");
      out.write("        .login-main .login-top {height:117px;background-color:#148be4;border-radius:12px 12px 0 0;font-family:SourceHanSansCN-Regular;font-size:30px;font-weight:400;font-stretch:normal;letter-spacing:0;color:#fff;line-height:117px;text-align:center;overflow:hidden;-webkit-transform:rotate(0);-moz-transform:rotate(0);-ms-transform:rotate(0);-o-transform:rotate(0);transform:rotate(0);}\r\n");
      out.write("        .login-main .login-top .bg1 {display:inline-block;width:74px;height:74px;background:#fff;opacity:.1;border-radius:0 74px 0 0;position:absolute;left:0;top:43px;}\r\n");
      out.write("        .login-main .login-top .bg2 {display:inline-block;width:94px;height:94px;background:#fff;opacity:.1;border-radius:50%;position:absolute;right:-16px;top:-16px;}\r\n");
      out.write("        .login-main .login-bottom {width:428px;background:#fff;border-radius:0 0 12px 12px;padding-bottom:53px;}\r\n");
      out.write("        .login-main .login-bottom .center {width:288px;margin:0 auto;padding-top:40px;padding-bottom:15px;position:relative;}\r\n");
      out.write("        .login-main .login-bottom .tip {clear:both;height:16px;line-height:16px;width:288px;margin:0 auto;}\r\n");
      out.write("        input::-webkit-input-placeholder {color:#a6aebf;}\r\n");
      out.write("        input::-moz-placeholder {/* Mozilla Firefox 19+ */            color:#a6aebf;}\r\n");
      out.write("        input:-moz-placeholder {/* Mozilla Firefox 4 to 18 */            color:#a6aebf;}\r\n");
      out.write("        input:-ms-input-placeholder {/* Internet Explorer 10-11 */            color:#a6aebf;}\r\n");
      out.write("        input:-webkit-autofill {/* 取消Chrome记住密码的背景颜色 */            -webkit-box-shadow:0 0 0 1000px white inset !important;}\r\n");
      out.write("        html {height:100%;}\r\n");
      out.write("        .login-main .login-bottom .tip {clear:both;height:16px;line-height:16px;width:288px;margin:0 auto;}\r\n");
      out.write("        .login-main .login-bottom .tip .login-tip {font-family:MicrosoftYaHei;font-size:12px;font-weight:400;font-stretch:normal;letter-spacing:0;color:#9abcda;cursor:pointer;}\r\n");
      out.write("        .login-main .login-bottom .tip .forget-password {font-stretch:normal;letter-spacing:0;color:#1391ff;text-decoration:none;position:absolute;right:62px;}\r\n");
      out.write("        .login-main .login-bottom .login-btn {width:288px;height:40px;background-color:#1E9FFF;border-radius:16px;margin:24px auto 0;text-align:center;line-height:40px;color:#fff;font-size:14px;letter-spacing:0;cursor:pointer;border:none;}\r\n");
      out.write("        .login-main .login-bottom .center .item .validateImg {position:absolute;right:1px;cursor:pointer;height:36px;border:1px solid #e6e6e6;}\r\n");
      out.write("        .footer {left:0;bottom:0;color:#fff;width:100%;position:absolute;text-align:center;line-height:30px;padding-bottom:10px;text-shadow:#000 0.1em 0.1em 0.1em;font-size:14px;}\r\n");
      out.write("        .padding-5 {padding:5px !important;}\r\n");
      out.write("        .footer a,.footer span {color:#fff;}\r\n");
      out.write("        .register {font-stretch:normal;letter-spacing:0;color:#1391ff;text-decoration:none;}\r\n");
      out.write("        @media screen and (max-width:428px) {.login-main {width:360px !important;}\r\n");
      out.write("            .login-main .login-top {width:360px !important;}\r\n");
      out.write("            .login-main .login-bottom {width:360px !important;}\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"main-body\">\r\n");
      out.write("    <div class=\"login-main\">\r\n");
      out.write("        <div class=\"login-top\">\r\n");
      out.write("            <span>用户登录</span>\r\n");
      out.write("            <span class=\"bg1\"></span>\r\n");
      out.write("            <span class=\"bg2\"></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <form class=\"layui-form login-bottom\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login.do\" method=\"get\">\r\n");
      out.write("            <div class=\"center\">\r\n");
      out.write("                <div class=\"item\">\r\n");
      out.write("                    <input type=\"text\" name=\"username\" lay-verify=\"required\"  placeholder=\"请输入登录账号\" maxlength=\"24\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"item\">\r\n");
      out.write("                    <input type=\"password\" name=\"password\" lay-verify=\"required\"  placeholder=\"请输入密码\" maxlength=\"20\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"tip\">\r\n");
      out.write("                <a href=\"register.jsp\" class=\"register\">没有账号？立即快速注册</a>\r\n");
      out.write("                <a href=\"javascript:\" class=\"forget-password\">忘记密码？</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"layui-form-item\" style=\"text-align:center; width:100%;height:100%;margin:0px;\">\r\n");
      out.write("                <input type=\"submit\" class=\"login-btn\"  lay-filter=\"login\" value=\"立即登录\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
