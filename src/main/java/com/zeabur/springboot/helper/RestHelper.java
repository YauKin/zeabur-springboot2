package com.zeabur.springboot.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public interface RestHelper {

    <T> T doGet(String url, Class<T> responseClass, Map<String, String> headersMap);

    <T> T doGet(String url, Class<T> responseClass, Map<String, String> headersMap, boolean ignoreSSL);

    <T> T doGet(String url, TypeReference<T> typeRef, Map<String, String> headersMap, boolean ignoreSSL) throws Exception;

    <T> ResponseEntity<T> doGetForEntity(String url, Class<T> responseClass, Map<String, String> headersMap);

    <T> ResponseEntity<T> doGetForEntity(String url, Class<T> responseClass, boolean ignoreSSL, Map<String, String> headersMap);

    <T> ResponseEntity<T> doGetForEntity(String url, TypeReference<T> typeRef, boolean ignoreSSL, Map<String, String> headersMap);
}
