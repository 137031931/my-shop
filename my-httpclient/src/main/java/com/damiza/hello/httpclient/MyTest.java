package com.damiza.hello.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class MyTest {
    public static void main(String[] args) {
        //创建HttpClient客户端,打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
    }
}
