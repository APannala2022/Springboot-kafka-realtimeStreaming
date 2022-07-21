package com.kafka.util;

import java.net.URISyntaxException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @type: GenericRestClient: Wrapper class for generic RestTemplate calls
 *
 * @author: ssood
 * @created: Apr 1, 2019
 * @copyright CBRE 2019
 */

@Component
public class GenericRestClient {

	@Autowired
    private RestTemplate restTemplate;

    /**
     * Method to execute rest calls without request body
     *
     * @param request
     * @param responseType
     * @return ResponseEntity
     * @throws URISyntaxException
     */
    public <T> ResponseEntity<T> execute(RestClientRequestMapper request, Class<T> responseType)
            throws URISyntaxException {

        HttpEntity<?> requestEntity = new HttpEntity<>(request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType);
    }

    public <T> ResponseEntity<T> execute(RestClientRequestMapper request, ParameterizedTypeReference<T> responseType)
            throws URISyntaxException {

        HttpEntity<?> requestEntity = new HttpEntity<>(request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType);
    }

    /**
     * Method to execute rest calls with request body
     *
     * @param request
     * @param responseType
     * @param body
     * @return ResponseEntity
     * @throws URISyntaxException
     */
    public <T, V> ResponseEntity<V> execute(RestClientRequestMapper request, T body, Class<V> responseType)
            throws URISyntaxException {

        HttpEntity<T> requestEntity = new HttpEntity<>(body, request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType);
    }

    public <T, V> ResponseEntity<V> execute(RestClientRequestMapper request, T body, Class<V> responseType,
            Map<String, Object> uriVariables) throws URISyntaxException {

        HttpEntity<T> requestEntity = new HttpEntity<>(body, request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType,
                uriVariables);
    }

    public <T, V> ResponseEntity<V> execute(RestClientRequestMapper request, T body,
            ParameterizedTypeReference<V> responseType) throws URISyntaxException {

        HttpEntity<T> requestEntity = new HttpEntity<>(body, request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType);

    }

    public <T, V> ResponseEntity<V> execute(RestClientRequestMapper request, T body,
            ParameterizedTypeReference<V> responseType, Map<String, Object> uriVariables) throws URISyntaxException {

        HttpEntity<T> requestEntity = new HttpEntity<>(body, request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType,
                uriVariables);

    }

    public <T, V> ResponseEntity<V> execute(RestClientRequestMapper request, Class<V> responseType,
            Map<String, Object> uriVariables) throws URISyntaxException {

        HttpEntity<T> requestEntity = new HttpEntity<>(request.getHeaderMap());

        return restTemplate.exchange(request.getUrl(), request.getRequestType(), requestEntity, responseType,
                uriVariables);

    }

}
