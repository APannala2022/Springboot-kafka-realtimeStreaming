package com.kafka.util;

import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.http.client.utils.URIBuilder;

/**
 * @type: RestClientRequestMapper: Mapper Class to build generic rest client requests by setting
 *        url, request type, request headers and query params. Mandatory headers are also set for
 *        each request. If query params are present, URL is constructed with query params.
 *
 * @author: ssood
 * @created: Apr 1, 2019
 * @copyright CBRE 2019
 */
public class RestClientRequestMapper {

    private String url;

    private HttpMethod requestType;

    private MultiValueMap<String, String> headerMap;

    private Map<String, String> queryParams;

    /**
     * Constructor for RestClientRequestMapper
     *
     * @param url
     * @param requestType
     */
    public RestClientRequestMapper(String url, HttpMethod requestType) {
        this.url = url;
        this.requestType = requestType;
        queryParams = new HashMap<>();
        headerMap = new LinkedMultiValueMap<>();
    }

    public MultiValueMap<String, String> getHeaderMap() {
        return headerMap;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public HttpMethod getRequestType() {
        return requestType;
    }

    /**
     * Method to get URL/constructed URL with query params
     *
     * @return String
     * @throws URISyntaxException
     */
    @SuppressWarnings("deprecation")
    public String getUrl() throws URISyntaxException {

        if (!queryParams.isEmpty()) {
            URIBuilder uriBuilder = new URIBuilder(url);
            queryParams.forEach(uriBuilder::addParameter);
            uriBuilder.build();
            return URLDecoder.decode(uriBuilder.toString());

        }

        return url;
    }

    /**
     * Method to set header map for given key value pair.
     *
     * @param headerKey
     * @param headerValue
     */
    public void setHeaderMap(String headerKey, String headerValue) {
        this.headerMap.add(headerKey, headerValue);
    }

    /**
     * Method to set query param map for given key value pair.
     *
     * @param key
     * @param value
     */
    public void setQueryParams(String key, String value) {
        this.queryParams.put(key, value);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
