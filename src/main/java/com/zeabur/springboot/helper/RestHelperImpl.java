package com.zeabur.springboot.helper;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.BasicHttpClientConnectionManager;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.GeneralSecurityException;
import java.util.Map;

@Service
public class RestHelperImpl implements RestHelper {
    private static final Logger logger = LoggerFactory.getLogger(RestHelperImpl.class);

    private final RestTemplate restTemplate;
    private RestTemplate restTemplateIgnoreSSL;

    public RestHelperImpl() {
        this.restTemplate = new RestTemplate();
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
            logger.error("URL or ResponseClass provided is null");
            return null;
        }
        // Create and populate HttpHeaders
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headersMap != null) {
            headersMap.forEach(httpHeaders::set);
        }

        // Prepare an HttpEntity; you might not need a body so just pass the headers
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        try {
            RestTemplate client = ignoreSSL ? getRestTemplateIgnoreSSL() : restTemplate;
            // Log the API call
            logger.info("Calling API for URL: {}", url);
            ResponseEntity<T> responseEntity = client.exchange(url, HttpMethod.GET, entity, responseClass);
            // Log the API call success
            logger.info("API called successfully for URL: {}", url);
            return responseEntity;
        } catch (Exception e) {
            logException(e);
        }
        return null;
    }

    private synchronized RestTemplate getRestTemplateIgnoreSSL() {
        try {
            restTemplateIgnoreSSL = createRestTemplateWithTrustAllCerts();
        } catch (GeneralSecurityException e) {
            logException(e);
        }
        return restTemplateIgnoreSSL;
    }

    private RestTemplate createRestTemplateWithTrustAllCerts() throws GeneralSecurityException {
        TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();

        HttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(socketFactoryRegistry);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }

    private void logException(Exception e) {
        logger.error("Error during REST operation", e);
    }
//    private Map<String, String> getRequestAttributes() {
//        Map<String, String> attributeMap = new HashMap<>();
//        try {
//            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//            if (requestAttributes != null) {
//                for (String key : requestAttributes.getAttributeNames(RequestAttributes.SCOPE_REQUEST)) {
//                    Object value = requestAttributes.getAttribute(key, RequestAttributes.SCOPE_REQUEST);
//                    if (value instanceof String) { // 检查属性值是否为String类型
//                        attributeMap.put(key, (String) value);
//                    } else {
//                        // 如果值不是字符串，你可以选择如何处理它
//                        // 例如，记录一个警告，或者转换为字符串
//                        logger.warn("Request attribute value for key " + key + " is not a String: " + value);
//                        // 如果你决定将非字符串值转换为字符串，可以取消注释下面的代码行
//                        String valueStr = (value != null) ? value.toString() : ""; // 或者选择其他非null值处理方式
//                        attributeMap.put(key, valueStr);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("Error getting request attributes", e);
//        }
//        return attributeMap;
//    }
}
