package com.leaf.club.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiechao
 */
public class HttpUtils {

    private static Logger log = LoggerFactory.getLogger(HttpUtils.class);

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * 发送get请求
     * @param url
     * @return
     */
    public static String sendGet(String url){
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            log.error("http连接异常");
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            log.error("格式转换异常");
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                log.error("response关闭异常");
            }
        }
        return result;
    }

    /**
     * 发送post请求
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map){
        List<NameValuePair> params = new ArrayList<>();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            log.error("http连接异常");
        }
        String result = null;
        try {
            HttpEntity entity1 = response.getEntity();
            if(entity1 != null) {
                result = EntityUtils.toString(entity1);
            }
        } catch (ParseException | IOException e) {
            log.error("格式转换异常");
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                log.error("response关闭异常");
            }
        }
        return result;
    }

}
