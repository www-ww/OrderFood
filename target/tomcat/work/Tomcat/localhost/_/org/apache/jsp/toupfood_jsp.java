/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-31 07:28:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class toupfood_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>??????????????????????????????</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\"  media=\"all\">\r\n");
      out.write("    <link href=\"https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- ????????????????????????????????????????????????????????????css?????????????????????????????? -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("    <div class=\"layui-header\">\r\n");
      out.write("        <div class=\"layui-logo layui-hide-xs layui-bg-black\">????????????????????????</div>\r\n");
      out.write("        <!-- ????????????????????????layui ???????????????????????? -->\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-left\">\r\n");
      out.write("            <!-- ??????????????? -->\r\n");
      out.write("            <li class=\"layui-nav-item layui-show-xs-inline-block layui-hide-sm\" lay-header-event=\"menuLeft\">\r\n");
      out.write("                <i class=\"layui-icon layui-icon-spread-left\"></i>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li class=\"layui-nav-item layui-hide-xs\"><a href=\"/userlist.do\">????????????</a></li>\r\n");
      out.write("            <li class=\"layui-nav-item layui-hide-xs\"><a href=\"/mafoods.do\">????????????</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-right\">\r\n");
      out.write("            <li class=\"layui-nav-item layui-hide layui-show-md-inline-block\">\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <img src=\"//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg\" class=\"layui-nav-img\">\r\n");
      out.write("                    admin\r\n");
      out.write("                </a>\r\n");
      out.write("                <dl class=\"layui-nav-child\">\r\n");
      out.write("                    <dd><a href=\"login.jsp\">????????????</a></dd>\r\n");
      out.write("                </dl>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"layui-nav-item\" lay-header-event=\"menuRight\" lay-unselect>\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <i class=\"layui-icon layui-icon-more-vertical\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-side layui-bg-black\">\r\n");
      out.write("        <div class=\"layui-side-scroll\">\r\n");
      out.write("            <!-- ??????????????????????????????layui???????????????????????? -->\r\n");
      out.write("            <ul class=\"layui-nav layui-nav-tree\" lay-filter=\"test\">\r\n");
      out.write("                <li class=\"layui-nav-item layui-nav-itemed\">\r\n");
      out.write("                    <a class=\"\" href=\"/foodlist.do\">????????????</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\">\r\n");
      out.write("                        <dd><a href=\"addfood.jsp\">????????????</a></dd>\r\n");
      out.write("                        <dd><a href=\"/foodlist.do\">??????/????????????</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-nav-itemed\">\r\n");
      out.write("                    <a href=\"/orderlist.do\">????????????</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\">\r\n");
      out.write("                        <dd><a href=\"/orderlist.do\">????????????</a></dd>\r\n");
      out.write("                        <dd><a href=\"/orderlist.do\">????????????</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"layui-nav-item\"><a href=\"/userlist.do\">????????????</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item\"><a href=\"/m-comlist.do\">????????????</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-body\" style=\"margin-top:100px\">\r\n");
      out.write("        <center><h1>????????????</h1></center>\r\n");
      out.write("        <!-- ?????????????????? -->\r\n");
      out.write("        <form class=\"layui-form\" action=\"/tofoodup.do\" style=\"margin-top:70px;margin-left:250px;margin-right: 500px;\">\r\n");
      out.write("            <div style=\"float: left;\">\r\n");
      out.write("                <input type=\"hidden\" name=\"foodid\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.foodid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("                <div class=\"layui-form-item\" width=\"100px\">\r\n");
      out.write("                    <label class=\"layui-form-label\">?????????</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"foodname\"  placeholder=\"??????????????????\"  class=\"layui-input\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.foodname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">????????????</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"number\" name=\"number\" required  lay-verify=\"required\" placeholder=\"???????????????\"  class=\"layui-input\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.number}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">??????</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"number\" name=\"price\" required  lay-verify=\"required\" placeholder=\"???????????????\" autocomplete=\"off\" class=\"layui-input\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.price}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">??????</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"sort\"  placeholder=\"???????????????\" autocomplete=\"off\" class=\"layui-input\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.sort}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">??????</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <input type=\"text\" name=\"storeid\"  placeholder=\"???????????????\" autocomplete=\"off\" class=\"layui-input\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${food.storeid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"float: right\">\r\n");
      out.write("                <div class=\"layui-upload\" style=\"width: 80px;height: 180px\">\r\n");
      out.write("                    <button type=\"button\" class=\"layui-btn\" id=\"test1\" >????????????</button>\r\n");
      out.write("                    <div class=\"layui-upload-list\">\r\n");
      out.write("                        <img class=\"layui-upload-img\" id=\"demo1\" style=\"width:100px;height: 160px\">\r\n");
      out.write("                        <p id=\"demoText\"></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div style=\"width: 95px;\">\r\n");
      out.write("                        <div class=\"layui-progress layui-progress-big\" lay-showpercent=\"yes\" lay-filter=\"demo\">\r\n");
      out.write("                            <div class=\"layui-progress-bar\" lay-percent=\"\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"layui-form-item\">\r\n");
      out.write("                <div class=\"layui-input-block\">\r\n");
      out.write("                    <button class=\"layui-btn\">????????????</button>\r\n");
      out.write("                    <button type=\"reset\" class=\"layui-btn layui-btn-primary\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <script src=\"layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("        <!-- ???????????????????????????????????????????????????????????? JS ?????????????????????????????? -->\r\n");
      out.write("        <script>\r\n");
      out.write("            layui.use(['upload', 'element', 'layer'], function() {\r\n");
      out.write("                var $ = layui.jquery\r\n");
      out.write("                    , upload = layui.upload\r\n");
      out.write("                    , element = layui.element\r\n");
      out.write("                    , layer = layui.layer;\r\n");
      out.write("\r\n");
      out.write("                //???????????? - ??????????????????\r\n");
      out.write("                var uploadInst = upload.render({\r\n");
      out.write("                    elem: '#test1'\r\n");
      out.write("                    , url: '/upload.do' //??????????????????????????? http ?????????????????????????????????????????????????????????????????????\r\n");
      out.write("                    , before: function (obj) {\r\n");
      out.write("                        //????????????????????????????????????ie8\r\n");
      out.write("                        obj.preview(function (index, file, result) {\r\n");
      out.write("                            $('#demo1').attr('src', result); //???????????????base64???\r\n");
      out.write("                        });\r\n");
      out.write("\r\n");
      out.write("                        element.progress('demo', '0%'); //???????????????\r\n");
      out.write("                        layer.msg('?????????', {icon: 16, time: 0});\r\n");
      out.write("                    }\r\n");
      out.write("                    , done: function (res) {\r\n");
      out.write("                        //??????????????????\r\n");
      out.write("                        if (res.code > 0) {\r\n");
      out.write("                            return layer.msg('????????????');\r\n");
      out.write("                        }\r\n");
      out.write("                        //???????????????????????????\r\n");
      out.write("                        //??????\r\n");
      out.write("                        if(res.code==0){\r\n");
      out.write("                            $('.layui-btn-img').text(\"????????????,????????????\");\r\n");
      out.write("                            return layer.msg('????????????',{time:700});\r\n");
      out.write("                        }\r\n");
      out.write("                        // $('#demoText').html(''); //???????????????????????????\r\n");
      out.write("                    }\r\n");
      out.write("                    // , error: function () {\r\n");
      out.write("                    //     //????????????????????????????????????\r\n");
      out.write("                    //     var demoText = $('#demoText');\r\n");
      out.write("                    //     demoText.html('<span style=\"color: #FF5722;\">????????????</span> <a class=\"layui-btn layui-btn-xs demo-reload\">??????</a>');\r\n");
      out.write("                    //     demoText.find('.demo-reload').on('click', function () {\r\n");
      out.write("                    //         uploadInst.upload();\r\n");
      out.write("                    //     });\r\n");
      out.write("                    // }\r\n");
      out.write("                    //?????????\r\n");
      out.write("                    , progress: function (n, elem, e) {\r\n");
      out.write("                        element.progress('demo', n + '%'); //????????? layui ?????????????????????\r\n");
      out.write("                        if (n == 100) {\r\n");
      out.write("                            layer.msg('????????????', {icon: 1});\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-footer\">\r\n");
      out.write("        Copyright ?? 2021.8.25 @author ww\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script src=\"./layui/layui.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    //JS\r\n");
      out.write("    layui.use(['element', 'layer', 'util'], function(){\r\n");
      out.write("        var element = layui.element\r\n");
      out.write("            ,layer = layui.layer\r\n");
      out.write("            ,util = layui.util\r\n");
      out.write("            ,$ = layui.$;\r\n");
      out.write("\r\n");
      out.write("        //????????????\r\n");
      out.write("        util.event('lay-header-event', {\r\n");
      out.write("            //??????????????????\r\n");
      out.write("            menuLeft: function(othis){\r\n");
      out.write("                layer.msg('???????????????????????????', {icon: 0});\r\n");
      out.write("            }\r\n");
      out.write("            ,menuRight: function(){\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 1\r\n");
      out.write("                    ,content: '<div style=\"padding: 15px;\">???????????????????????????</div>'\r\n");
      out.write("                    ,area: ['260px', '100%']\r\n");
      out.write("                    ,offset: 'rt' //?????????\r\n");
      out.write("                    ,anim: 5\r\n");
      out.write("                    ,shadeClose: true\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
