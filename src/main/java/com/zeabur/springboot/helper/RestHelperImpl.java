package com.zeabur.springboot.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class RestHelperImpl implements RestHelper {
    private final RestTemplate restTemplate;
    private final RestTemplate restTemplateWithTrustAllCerts;

    public RestHelperImpl(RestTemplate restTemplateWithTrustAllCerts) {
        this.restTemplate = new RestTemplate();
        this.restTemplateWithTrustAllCerts = restTemplateWithTrustAllCerts;
    }

    @Override
    public <T> T doGet(String url, Class<T> responseClass, Map<String, String> headersMap) {
        return doGet(url, responseClass, headersMap, false);
    }

    @Override
    public <T> T doGet(String url, Class<T> responseClass, Map<String, String> headersMap, boolean ignoreSSL) {
        ResponseEntity<T> responseEntity = doGetForEntity(url, responseClass, ignoreSSL, headersMap);
        return responseEntity != null ? responseEntity.getBody() : null;
    }

    @Override
    public <T> ResponseEntity<T> doGetForEntity(String url, Class<T> responseClass, Map<String, String> headersMap) {
        return doGetForEntity(url, responseClass, false, headersMap);
    }

    @Override
    public <T> ResponseEntity<T> doGetForEntity(String url, Class<T> responseClass, boolean ignoreSSL, Map<String, String> headersMap) {
        if (url == null || responseClass == null) {
            log.error("URL or ResponseClass provided is null");
            return null;
        }
        // Create and populate HttpHeaders
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            if (headersMap != null) {
                headersMap.forEach(httpHeaders::set);
            }
            RestTemplate client = ignoreSSL ? restTemplateWithTrustAllCerts : restTemplate;
            return client.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), responseClass);
        } catch (Exception e) {
            logException(e);
        }
        return null;
    }

    private void logException(Exception e) {
        log.error("Error during REST operation", e);
    }
}
