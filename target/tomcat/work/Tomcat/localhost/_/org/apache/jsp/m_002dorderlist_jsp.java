/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-09-03 09:08:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class m_002dorderlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("    <title>大学食堂外卖点餐平台</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\"  media=\"all\">\r\n");
      out.write("    <link href=\"https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"layui-layout layui-layout-admin\">\r\n");
      out.write("    <div class=\"layui-header\">\r\n");
      out.write("        <div class=\"layui-logo layui-hide-xs layui-bg-black\">外卖点餐平台后台</div>\r\n");
      out.write("        <!-- 头部区域（可配合layui 已有的水平导航） -->\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-left\">\r\n");
      out.write("            <!-- 移动端显示 -->\r\n");
      out.write("            <li class=\"layui-nav-item layui-show-xs-inline-block layui-hide-sm\" lay-header-event=\"menuLeft\">\r\n");
      out.write("                <i class=\"layui-icon layui-icon-spread-left\"></i>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li class=\"layui-nav-item layui-hide-xs\"><a href=\"/userlist.do\">用户面板</a></li>\r\n");
      out.write("            <li class=\"layui-nav-item layui-hide-xs\"><a href=\"/mafoods.do\">展示面板</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <ul class=\"layui-nav layui-layout-right\">\r\n");
      out.write("            <li class=\"layui-nav-item layui-hide layui-show-md-inline-block\">\r\n");
      out.write("                <a href=\"javascript:;\">\r\n");
      out.write("                    <img src=\"//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg\" class=\"layui-nav-img\">\r\n");
      out.write("                    admin\r\n");
      out.write("                </a>\r\n");
      out.write("                <dl class=\"layui-nav-child\">\r\n");
      out.write("                    <dd><a href=\"login.jsp\">退出登录</a></dd>\r\n");
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
      out.write("            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->\r\n");
      out.write("            <ul class=\"layui-nav layui-nav-tree\" lay-filter=\"test\">\r\n");
      out.write("                <li class=\"layui-nav-item layui-nav-itemed\" >\r\n");
      out.write("                    <a class=\"\" href=\"/foodlist.do\">商品中心</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\" style=\"margin-bottom: 0\">\r\n");
      out.write("                        <dd><a href=\"addfood.jsp\">添加商品</a></dd>\r\n");
      out.write("                        <dd><a href=\"/foodlist.do\">删除/修改商品</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"layui-nav-item layui-nav-itemed\">\r\n");
      out.write("                    <a class=\"\" href=\"/orderlist.do\">订单中心</a>\r\n");
      out.write("                    <dl class=\"layui-nav-child\">\r\n");
      out.write("                        <dd><a href=\"/orderlist.do\">修改订单</a></dd>\r\n");
      out.write("                        <dd><a href=\"/orderlist.do\">删除订单</a></dd>\r\n");
      out.write("                    </dl>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"layui-nav-item\"><a href=\"/userlist.do\">用户管理</a></li>\r\n");
      out.write("                <li class=\"layui-nav-item\"><a href=\"/m-comlist.do\">投诉中心</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-body\">\r\n");
      out.write("        <!-- 内容主体区域 -->\r\n");
      out.write("        <div style=\"padding: 30px;\">\r\n");
      out.write("            <div style=\"float: left;margin-right: 30px\">\r\n");
      out.write("                <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/findorder.do\" method=\"get\">\r\n");
      out.write("                    <span style=\"color: red;font-weight: bold\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("                    <input type=\"text\" name=\"findcaete\" class=\"form-inline\" class=\"form-control\" placeholder=\"请输入订单编号\">\r\n");
      out.write("                    <input type=\"submit\" value=\"查询\" class=\"btn btn-primary\">\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <a  class=\"btn btn-primary\" href=\"/queryExportUser\">下载订单</a>\r\n");
      out.write("\r\n");
      out.write("            <form action=\"\" name=\"myForm\" style=\"margin-top:50px\">\r\n");
      out.write("                <table class=\"layui-table\" lay-data=\"{width: 1200, height:500, page:true, id:'idTest'}\" name=\"idTest\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th lay-data=\"{field:'foodid', width:120, sort: true}\">订单ID</th>\r\n");
      out.write("                        <th lay-data=\"{field:'foodname', width:120, sort: true}\">用户id</th>\r\n");
      out.write("                        <th lay-data=\"{field:'number', width:120, sort: true}\">状态</th>\r\n");
      out.write("                        <th lay-data=\"{field:'price', width:120, sort: true}\">价格</th>\r\n");
      out.write("                        <th lay-data=\"{field:'sort', width:200}\">配送地址</th>\r\n");
      out.write("                        <th lay-data=\"{field:'src', width:300, sort: true}\">下单时间</th>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <th lay-data=\"{field:'do', width:300}\">操作</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <!--循环读取值-->\r\n");
      out.write("                    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-footer\">\r\n");
      out.write("        Copyright © 2021.8.25 @author ww\r\n");
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
      out.write("        //头部事件\r\n");
      out.write("        util.event('lay-header-event', {\r\n");
      out.write("            //左侧菜单事件\r\n");
      out.write("            menuLeft: function(othis){\r\n");
      out.write("                layer.msg('展开左侧菜单的操作', {icon: 0});\r\n");
      out.write("            }\r\n");
      out.write("            ,menuRight: function(){\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    type: 1\r\n");
      out.write("                    ,content: '<div style=\"padding: 15px;\">处理右侧面板的操作</div>'\r\n");
      out.write("                    ,area: ['260px', '100%']\r\n");
      out.write("                    ,offset: 'rt' //右上角\r\n");
      out.write("                    ,anim: 5\r\n");
      out.write("                    ,shadeClose: true\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /m-orderlist.jsp(104,20) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/m-orderlist.jsp(104,20) '${list}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /m-orderlist.jsp(104,20) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("order");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                        <tr>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.orderid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.state}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.allprice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.to}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("\r\n");
          out.write("                            <td>\r\n");
          out.write("                                <a href=\"/orderup.do?orderid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.orderid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"layui-btn layui-btn-sm layui-btn-normal\">修改状态</a>\r\n");
          out.write("                                <a href=\"/orderdel.do?orderid=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${order.orderid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" class=\"layui-btn layui-btn-sm\">删除订单</a>\r\n");
          out.write("                            </td>\r\n");
          out.write("                        </tr>\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
