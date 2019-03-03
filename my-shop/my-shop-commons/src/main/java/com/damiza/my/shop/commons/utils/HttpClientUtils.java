package com.damiza.my.shop.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * HttpClient工具类
 */
public class HttpClientUtils {

    private static final String GET = "get";
    private static final String POST = "post";

    private static final String REQUEST_HEADER_CONNECTION= "keep-alive";

    private static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.81 Safari/537.36";

    /**
     * Get请求
     * @param url 请求地址
     * @return
     */
    public static String doGet(String url){
        return createRequest(url,GET,null);
    }

    /**
     * Get请求
     * @param url 请求地址
     * @param cookie 请求地址
     * @return
     */
    public static String doGet(String url,String cookie){
        return createRequest(url,GET,cookie);
    }

    /**
     * Post请求
     * @param url 请求地址
     * @param params 请求参数(可选)
     * @return
     */
    public static String doPost(String url,BasicNameValuePair...params){
        return createRequest(url,POST,null,params);
    }

    /**
     * Post请求
     * @param url 请求地址
     * @param params 请求参数(可选)
     * @return
     */
    public static String doPost(String url, String cookie, BasicNameValuePair...params){
        return createRequest(url,POST,cookie,params);
    }

    /**
     * 创建请求
     * @param url 请求地址
     * @param requestMethod 请求方式
     * @param cookie cookie
     * @param params 请求参数仅限于POST请求
     * @return
     */
    private static String  createRequest(String url,String requestMethod, String cookie ,BasicNameValuePair...params){

        //创建HttpClient客户端,打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;

        try {
            //请求结果
            result = null;

            //请求方式
            HttpGet httpGet = null;
            HttpPost httpPost = null;

            //响应
            CloseableHttpResponse httpResponse = null;

            //如果请求方式是GET
            if (GET.equals(requestMethod)){
                httpGet = new HttpGet(url);
                httpGet.setHeader("Connection",REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("Cookie",cookie);
                httpGet.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);


                httpResponse = httpClient.execute(httpGet);

            }

            //如果请求方式是POST
            else if(POST.equals(requestMethod)) {
                httpPost = new HttpPost(url);
                httpPost.setHeader("Connection",REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("Cookie",cookie);
                httpPost.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);

                //post方式有参数进来
                if (params != null && params.length > 0){
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params),"UTF-8"));
                }

                httpResponse = httpClient.execute(httpPost);

            }

            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;

    }
}
