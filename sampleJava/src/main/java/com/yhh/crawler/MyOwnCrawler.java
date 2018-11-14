package com.yhh.crawler;

import com.google.common.collect.Lists;
import com.yhh.common.PrintUtils;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

import static com.yhh.common.PrintUtils.println;

@Data
public class MyOwnCrawler {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private final HttpClientBuilder httpClientBuilder;
    private String charset;

    public MyOwnCrawler() {
        this.charset = DEFAULT_CHARSET;
        httpClientBuilder = HttpClientBuilder.create();
    }

    public MyOwnCrawler(String charset) {
        this.charset = charset;
        httpClientBuilder = HttpClientBuilder.create();
    }

    public static void main(String[] args) {
        MyOwnCrawler myOwnCrawler = new MyOwnCrawler();
        myOwnCrawler.execute("http://www.baidu.com");
    }

    public void execute(String url) {
        String content = getContentFromUrl(url);

        List<String> hrefList = getHrefOfContent(content);

        hrefList.forEach(PrintUtils::println);
    }

    public String getContentFromUrl(String url) {
        String responseBody = null;

        ResponseHandler<String> responseHandler = getResponseHandler();

        HttpGet httpGet = new HttpGet(url);

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        try {
            responseBody = closeableHttpClient.execute(httpGet, responseHandler);
            println("----------------------------------------");
            println(responseBody);
            println("----------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeableHttpClient.getConnectionManager().shutdown();
        }
        return responseBody;
    }

    public List<String> getHrefOfContent(String content) {
        PrintUtils.println("Begin.");
        String[] contents = content.split("href=\"");

        List<String> hrefList = Lists.newArrayList();

        for (int i = 0; i < contents.length; i++) {
            int endIndex = contents[i].indexOf("\"");
            String aHref = contents[i].substring(0, endIndex);

            hrefList.add(aHref);
        }
        return hrefList;
    }

    private ResponseHandler<String> getResponseHandler() {
        return response -> {
            int status = response.getStatusLine().getStatusCode();

            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity == null ? "" : EntityUtils.toString(entity, charset);
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
    }

}
