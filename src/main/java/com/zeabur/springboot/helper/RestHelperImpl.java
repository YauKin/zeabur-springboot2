package com.zeabur.springboot.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestHelperImpl implements RestHelper {
    private static final Logger logger = LoggerFactory.getLogger(RestHelperImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public <T> T doGet(String url, Class<T> responseClass) {
        ResponseEntity<T> responseEntity = doGetForEntity(url, responseClass);
        if (responseEntity != null) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }

    @Override
    public <T> ResponseEntity<T> doGetForEntity(String url, Class<T> responseClass) {
        if (url != null && responseClass != null) {
            try {
                return restTemplate.getForEntity(url, responseClass, getRequestAttributes());
            } catch (Exception e) {
                logger.error("Error getting response from Rest service GET", e);
                return null;
            }
        }
        return null;
    }

    private Map<String, String> getRequestAttributes() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                Map<String, String> attributeMap = new HashMap<>();
                for (String key : requestAttributes.getAttributeNames(RequestAttributes.SCOPE_REQUEST)) {
                    attributeMap.put(key, (String) requestAttributes.getAttribute(key, RequestAttributes.SCOPE_REQUEST));
                }
                return attributeMap;
            }
        } catch (Exception e) {
            logger.error("An error occurred while retrieving request attributes", e);
        }
        return new HashMap<>();
    }
}
