package com.utilexample.utilexample.util;

import okhttp3.*;

import java.io.IOException;

/**
 * @author 马锴梁
 * @version 1.0
 * @date 2019/12/12 12:59
 */
public class OkHttpUtil {
//   Post请求String
    public static final MediaType MEDIA_TYPE_MARKDOWN= MediaType.parse("text/x-markdown; charset=utf-8");
//    Post请求Json
    public static  final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
//  同步的get请求
    public static String getSyn(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String postText(String url,String postBody){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, postBody))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String postJson(String url,String json){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String postJsonToken(String url,String json,String token){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization","Bearer "+token)
                .post(requestBody)
                .build();
        try {
            System.out.println(request.toString());
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
