package com.yhh.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestHttpGet {

    public static void main(String[] args) {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//
//            public String handleResponse(
//                    final HttpResponse response) throws ClientProtocolException, IOException {
//                int status = response.getStatusLine().getStatusCode();
//                if (status >= 200 && status < 300) {
//                    HttpEntity entity = response.getEntity();
//                    return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
//                } else {
//                    throw new ClientProtocolException("Unexpected response status: " + status);
//                }
//            }
//        };
//        HttpGet httpGet = new HttpGet("http://www.baidu.com");
//        try {
//            String responseBody = httpClient.execute(httpGet, responseHandler);
//            System.out.println("----------------------------------------");
//            System.out.println(responseBody);
//            System.out.println("----------------------------------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
