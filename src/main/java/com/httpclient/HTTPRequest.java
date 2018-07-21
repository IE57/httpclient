package com.httpclient;

import java.util.HashMap;


public class HTTPRequest {

    //请求URL：http://srh.bankofchina.com/search/whpj/search.jsp
    public String url;

    //GET/POST方法
    public HTTPMethod method;

    //JSON格式请求参数【扩展】
    public String body;

    public HashMap<String, String> headers;

    //请求查询参数
    public HashMap<String, String> parameters;

    public Integer connectTimeout;

    public Integer requestTimeout;


    public HTTPRequest(final HTTPMethod method, final String url) {
        super();
        this.method = method;
        this.url = url;

        this.headers = new HashMap<String, String>();
        this.parameters = new HashMap<String, String>();
    }

    public HTTPRequest setBody(String body) {
        this.body = body;
        return this;
    }

    public HTTPRequest addHeader(String name, String value) {
        headers.put(name, value);
        return this;
    }

    public HTTPRequest addQueryParameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    public HTTPRequest addQueryParameter(String name, Integer value) {
        parameters.put(name, String.valueOf(value));
        return this;
    }

    public HTTPRequest addQueryParameter(String name, long value) {
        parameters.put(name, String.valueOf(value));
        return this;
    }

    public HTTPRequest setConnectionTimeout(Integer connectionTimeout) {
        this.connectTimeout = connectionTimeout;
        return this;
    }

    public HTTPRequest setRequestTimeout(Integer requestTimeout) {
        this.requestTimeout = requestTimeout;
        return this;
    }
}
