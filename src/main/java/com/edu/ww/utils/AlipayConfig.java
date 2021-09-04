package com.edu.ww.utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @program:OrderFood
 * @description:阿里沙箱支付接口
 * @author:ww
 * @create:2021-09-02 09:10
 */
public class AlipayConfig {

        // 应用ID
        public static String APP_ID  = "2021000118610808";

        // 商户私钥
        public static String APP_PRIVATE_KEY  = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqGWDLPFhXL59oIn1ApdDYHU703gAq5vCsbeaXDq/Vc1YF7m3ME5YbsjwlDzvSIi5eEpU87wSQbXw3Y0ArobFWL3gI1W6BSyYMbAYDTl6J/yVFovPt7pOHuVRSWSYmed2ya10LrZG2LHuXzDOQ/52FPRCXCqe2fVLiKuXzLQEw7BY64fYdgCvIYBwFYDh9Mm2E5pnB4tpHGL4ZlyHp0RZfX7FmckBufYuZ7CJG3/lBvU8vdDs6+BFHrWM/0UCunzTKModNW0Q1/fhWagCI1BLKI/E87ExYQ09HN4HOGJt7VoryF1IUKDVw6WzSkkM11hEUJweCyLtQZC9AgT5S29lJAgMBAAECggEAVrbtU26GEpxihXHfrI9bsnDuiYKLT1PAKgc04JlKJmTP2+I68yihA6mPY80qT+vA+5A5qICpMP+/rXTZh+S8RRWZ+dbkqOEomniPcCwJogwCckeqVwejCjP+uqRcAI1r6cM2AfgQKnDu6One9/J32S7SQE3cRfoJwObhp2CwFMHQlCJ6wUcAN2tayWY4XuzfUdyT0gnFXCrRwPllYR2Dux72n9YDgAesur+sdGQ4kJtB3WkNgNkS/vTHVwuI/wuqejtCQ/aysZqV22hXpIViXK13G8Q+nbFi0t+M6KA+BRsVcRcvUgnQVOhulReEOX3P59oP7gfXR6/hM/1a5AgZCQKBgQDmwVhvhevg+ksf3HNtOCKbgIiMx5Dy2a02SR/4Cpxy1FTXM++vJYyEW7jId+SHJ0a2KFpeVdBMQZVRXIgX0JDunWwAaZpT67i6QAlXdMg4QGAaPy27PwTDy69E4+dtDw61lrJJB6DHoCbuHATmLYuW8e9K5ECMS7ZaAwOunnUc4wKBgQC8tUPWWA9egmlgeEyq3U2+7p9SPbDQmBFEsYgEoPrzMkLCTMWSio2YcRdMG5H1RuQewwGQ7lxxJrTydUcqx08KSVuxunIx7Hki4tLWT3PXNlKy5FdGZ/+KdCxl+9pM5MFerkgNl00hejMe2FevoAVh5Hl7TfDbZQwqUwCM83CU4wKBgAZt6KrizlmsX595ovWuFLjEcgmKHe3GRt82Vl+w2/8PD3YXilwU7b9aVuGvBX0GiR/WK/5o4a7ePOzRaTFQrFkZpcK1LomcDb+SvS/knxeCI6tXi0ymStmxuSZwOyh8vOouUrVaMw6c1bjYqwJGzpbcEtDBX1MJYQFNCDM7UwQFAoGBAJ/s6snbpWLOGOol6augk8PtTN6Q46lURsY1wnVRzHuQq90o3QPdIjUAGuNoNiFta+TaFRizuWo3iIA2fhK2CLlKBEiyHxdKNjsnidEQUrcgFaQAOiqz9nBrFjlz4MTr1SkdgHjsMfTeMDbC2EVB023sCDxEiIwWreGsqDnMEixLAoGBALomIPyX/cuNpFaN1gGky1Go9VLs6UHKCjIsVrtkd4AKAsDILzvk/Ovq0VwKrbmshrMlw/yCE9q+W0u/BE3Dj9bQqYhXmL9nqAHDGSJw1G4Z6YkhhsGOxLGIZf0I4vPm8NRRqct/DX5D6RzSSLb59o+go8bGcGncqhKRd6MkSVN1";

        // 支付宝公钥
        public static String ALIPAY_PUBLIC_KEY  = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjw26+pktYLXc44BS0xiFc3/g31qHGgiJGXKUFILke/xFF6G/T2HM0sVzEvkMJDYvf65NPg7V3E22GYMxLUMopwwxciYF1WVfzLV0N5dXj1b9vNZBQ9qu6w3CUJWgK8JK658NPx0NJ0kJuuWDfNnrdKEGG+1rTQywys1P26P9BMi/jDQjTrLZn4OwM2Ajr2nu7yDvETzKEnZbrlj1oErKYWHlTqR/MBz1ZeTnR4stU8XNzj8Pp/i0uOqToOFyUCO2PaoX6IgVdbRoLSRvN8ChIGZb2cfKvayxYLmh1/0Me6tRltiosxLBprfx2kdHRNInsz1l1Q6VUDV0jt4873Yj/QIDAQAB";

        // 服务器异步通知页面路径
        public static String notify_url = "http://localhost:8080/Alipay/notifyUrl";

        // 页面跳转同步通知页面路径
        public static String return_url = "http://localhost:8080/Alipay/returnUrl";

        // 签名方式
        public static String sign_type = "RSA2";

        // 字符编码格式
        public static String CHARSET  = "utf-8";

        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

        //日志地址
        public static String log_path = "E:\\";

        /**
         * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
         * @param sWord 要写入日志里的文本内容
         */
        public static void logResult(String sWord) {
                FileWriter writer = null;
                try {
                        writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
                        writer.write(sWord);
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        if (writer != null) {
                                try {
                                        writer.close();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }

}
