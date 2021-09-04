package com.edu.ww.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.edu.ww.pojo.Order;
import com.edu.ww.service.OrderService;
import com.edu.ww.utils.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program:OrderFood
 * @description:支付接口
 * @author:ww
 * @create:2021-09-02 09:14
 */
@Controller
@RequestMapping("/Alipay")
public class PayController {
    long l = System.currentTimeMillis();

    @Autowired
    OrderService service;
    /**
     * 购物车
     *
     * @return
     */
    @RequestMapping(value = "/Shopcart")
    public String Shopcart() {
        return  "pay";
    }

    /**
     * 结算界面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/PayPage")
    public String  payController (HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("payPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");

        HttpSession session=request.getSession();
        System.out.println(session.getAttribute("lastorder"));
        Order order=(Order)session.getAttribute("lastorder");

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no =""+order.getOrderid();
        System.out.println(out_trade_no);
        //付款金额，必填  ShopName
        String total_amount =""+order.getAllprice();
        System.out.println(total_amount);
        //订单名称，必填
        String subject ="订单:"+order.toString();
        System.out.println(subject);
        //商品描述，可空
        String body =request.getParameter("购物测试");
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
        return form;
    }

    /**
     * 同步跳转
     *
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/returnUrl")
    public void returnUrl(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 获取支付宝GET过来反馈信息（官方固定代码）
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.sign_type); // 调用SDK验证签名

        // 返回界面
        if (signVerified) {
            System.out.println("前往支付成功页面");
            response.sendRedirect("/index.do");
        } else {
            System.out.println("前往支付失败页面");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            HttpSession session=request.getSession();
            System.out.println(session.getAttribute("lastorder"));
            Order order=(Order)session.getAttribute("lastorder");
            service.delSer(order.getOrderid());
            printWriter.print("<script>alert('支付失败！！！');window.location='/myorder.do';</script>");

        }
    }

    /**
     * 支付宝服务器异步通知
     *
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.sign_type); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            // 修改数据库
        } else {
            System.out.println("异步通知失败");
        }
    }
}

