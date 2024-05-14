package com.zeabur.springboot.helper;

import lombok.extern.slf4j.Slf4j;
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
import javax.net.ssl.SSLContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.Map;

@Slf4j
@Service
public class RestHelperImpl implements RestHelper {
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
            log.error("URL or ResponseClass provided is null");
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
            apiLoggerInfo("3rd party API call for URL", url);
            ResponseEntity<T> responseEntity = client.exchange(url, HttpMethod.GET, entity, responseClass);
            // Log the API call success
            apiLoggerInfo("3rd party API called successfully for URL", url);
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
        log.error("Error during REST operation", e);
    }
    public static void apiLoggerInfo(String logMessage, String urlString) {
        try {
            URI uri = new URI(urlString);
            String path = uri.getPath();
            String apiName = extractApiNameFromPath(path);
            log.info("{}: {}", logMessage, apiName);
        } catch (URISyntaxException e) {
            log.error("Invalid URL syntax: {}", urlString, e);
        }
    }
    private static String extractApiNameFromPath(String path) {
        String[] pathParts = path.split("/");
        // Ensure there are enough parts in the path to extract the API name
        if (pathParts.length > 2) {
            return pathParts[1] + "/" + pathParts[2]+ "/" + pathParts[3];
        } else {
            return path;
        }
    }
}
