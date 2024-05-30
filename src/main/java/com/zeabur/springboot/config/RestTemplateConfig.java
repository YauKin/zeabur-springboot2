package com.zeabur.springboot.config;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /**
     * Creates a standard RestTemplate bean with default HTTP settings.
     *
     * @return a configured RestTemplate instance.
     */
    @Bean
    public RestTemplate restTemplate() {
        // Configure HTTP client with redirects enabled.
        RequestConfig config = RequestConfig.custom()
                .setRedirectsEnabled(true) // Enable redirects
                .build();

        // Create a CloseableHttpClient with the above configuration.
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build();

        // Create a factory to use the HttpClient with the RestTemplate.
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        // Return a new RestTemplate instance using the factory.
        return new RestTemplate(factory);
    }


}

