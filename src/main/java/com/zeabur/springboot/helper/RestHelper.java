package com.zeabur.springboot.helper;

import org.springframework.http.ResponseEntity;


public interface RestHelper {

    <T> T doGet(String url, Class<T> responseClass);

    <T> ResponseEntity<T> doGetForEntity(String url, Class<T> responseClass);
}
