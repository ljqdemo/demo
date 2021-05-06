package com.example.demo.controller;

import com.alibaba.nacos.common.util.UuidUtils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gino
 * 2021-03-31
 */
@RestController
public class AliPlaycContoller {


    @RequestMapping("/play")
    public String play() throws AlipayApiException {
        //构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
        //设置应用Id
        certAlipayRequest.setAppId("2021002133692251");
        //设置应用私钥
        certAlipayRequest.setPrivateKey("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEZPFoZPQwEUB89Opghknj31puKq1krw4+eP6IXqsPfkLUefrhWi+nyf0nrJ/0RM66NzNOf9g1MSgctgxBA5uNKpBs5bGO/KnPqaaxT7lT8yadm7OXLniWExl1eJfCW91oyerNDbnynrgiVTAzGzrLXh/eu8hF3n+ngLOvjq+DWlYP3p0yRB1YtwHEbvBgcdPvX+zuUipvS1dWXwx7+vvImbRspJaooUmddZ0VUXEoSb2ZlsXSeFVEILNiTtRwGLBqvcsi9GFtdlrUM2hVyTioymcJs2yK/B+oLvnm1nkWY88WtZW/7z8LSSFMrEpzkcSQeuiL+u7FxS9acDWPcMUHAgMBAAECggEAZfNhnvVWwQkX8uGa9reSgOKHPZypp4XSXzNHNnZIHgcpqXtBQXX0iq3Vv06EYlL2KpnFbaavNM7kx688ongHud5UFzeN0sEodtx6m8H7wfTVALtcwYesnkyY50f0/VtGlaIfqMXwMjAdNXsKQeCvFtolipxqLbuX68IFHKSw7WFkbTwrfxhHjuyvJyWIUAwqUOgXphRDgRtMMiwetyVQkDyxO6g32TUMjE6qwaLh3Df7jMluxDEHMKHlaon6wqhSdHtSsSDjLPJ4IV+HsZaO0eHQilusoRzG/DRuf/Mj8nfeqnJOo9U7cc1o2oUpBGmi4SDB/zan2AWDhTzXu3h/aQKBgQD2s1QDX5a5IcN/zaxOYdHpsl6iSZeDOnqoHQx76EA8U2BJYm9l8dznjmID+rp0Aetq0WFaVJLBlA4GQptiZyKZS7y4iJik4EyE0RFoc4eatXpAS9dsHDednaCqbkGTp9LKtSogPHt1iLWg8xE3MqCY9iw3LD0ETSQnumODV1Lj8wKBgQCJYo30ilZ5Tjptd1+Fhi2LutwbP8ToMy7Ll7uIeDxYPhLNjbFiw2nnZ/ptaW4pcYkNHag15CwJ7BOZZ4MWLT7OR31qvhePF2eA4mFv+l7K6sCaqQpN/TRrbsIjj3s0M5kh8+uj/PZn3z+nFb00xpZNj2H/plbcOAHQCmkVf7xjnQKBgQCwLDX1xsBq6rqivOyseNyfp/o+qJEjbJKFFWGB5sRgkCX1oe7tfUAEuEA0mUunZmuIt4dvK3A1/xXY0J4IMqCZmmVl3l4rd+YM/wQQdFhFWg24drCbCreIvjUrIFuCJ1m32pH/vVFpCLyz+IC1y1i2gy3mJJhaRwBnwoooFCckkwKBgACwBZXbu2MQCSrTFh9M9J1magOY5htjZjCOqdmdAHBQnzd4JhMgdz85Pf+eL3b1ooH2TAk5Ax9plw+FfRp3T4Eoym/mU6fbriDvAR3WWvMZCa28eti5E7IV89LJvQwd1f5dgihn87PBYkgry66f79CjjxIAex7PCPNJmg0Jfp/hAoGACp4hN5I5Ow7eQcTRLRHHg2n80B7JrLULMoxgr1NIH1DoJLhqbghkQ0gk9KQJHkTF9hfx2EEO05x8zb4uIEnF2m5OfbThPO8aB8DC8u4J671uQ1c1IcIBYWM2u1wzgQ2R6keTMyeJQBTGE4avogJc18mLCrvMCwuv0VSZphLESuU=");
        //设置请求格式，固定值json
        certAlipayRequest.setFormat("json");
        //设置字符集
        certAlipayRequest.setCharset("UTF-8");
        //设置签名类型
        certAlipayRequest.setSignType("RSA2");
        //设置应用公钥证书路径
        certAlipayRequest.setCertPath("D:\\Documents\\WeChat Files\\wxid_17or7q9hnmh222\\FileStorage\\File\\2021-03\\b9660b1be0fcf304d80ebf45245e2873_fd6b817f0faac0a80399e40ed8708cfd_8.crt");
        //设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath("D:\\Documents\\WeChat Files\\wxid_17or7q9hnmh222\\FileStorage\\File\\2021-03\\8e12ad4f16edc42601e13563b41a5523_9e4f59f4b3fba695c74d87c7d8106e38_8.crt");
        //设置支付宝根证书路径
        certAlipayRequest.setRootCertPath("D:\\Documents\\WeChat Files\\wxid_17or7q9hnmh222\\FileStorage\\File\\2021-03\\b6612a80b13013892c8c5c0829f62367_62fe7d2dda5f6196f97de73aba741dad_8.crt");
        //构造client
        AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("我是测试数据");
        model.setSubject("App支付测试Java");
        model.setOutTradeNo(UuidUtils.generateUuid());
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("商户外网可以访问的异步地址");
        AlipayTradeAppPayResponse response = null;
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            response = alipayClient.sdkExecute(request);
            //就是orderString 可以直接给客户端请求，无需再做处理。
            System.out.println(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

}
