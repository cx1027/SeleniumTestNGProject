package com.tanmaysarkar.common;

public enum Url {
    BASEURL("http://demo.tanmaysarkar.com/"),
    SAMPLE01("/sample_01.html"),
	SAMPLE02("/sample_02.html");

    String url;

    Url(String url){
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}