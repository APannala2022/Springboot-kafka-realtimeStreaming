package com.kafka.helper;

import java.net.URISyntaxException;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.kafka.util.GenericRestClient;
import com.cbre.host.platform.exception.HostException;
import com.cbre.host.platform.exception.HostBusinessException;
import com.cbre.host.platform.models.ResponseMessage;


import com.kafka.dto.SpaceRequest;
import com.kafka.util.RestClientRequestMapper;
import com.kafka.constant.ApplicationConstant;

@Component
public class kafkaHelper {

	
    @Value("${host.space.api.url}")
    private String spaceUrl;
    
    @Value("${host.space.api.version}")
    private String spaceVersion;
    
    @Autowired
    private GenericRestClient restClient;
    
    public String updateSpace(SpaceRequest spaceRequestBody, String authorization, String idToken, String provider, Boolean isPatchUpdate) throws HostException {

    	//SpaceRequest spaceRequestBody = new SpaceRequest();
        //spaceRequestBody.setId(id);
    	System.out.println("Inside update");
        spaceUrl = spaceUrl+"/"+spaceRequestBody.getId();

        RestClientRequestMapper spaceRequest = new RestClientRequestMapper(spaceUrl, HttpMethod.PUT);
        spaceRequest.setHeaderMap(ApplicationConstant.HEADER_KEY_AUTHORIZATION, authorization);
        spaceRequest.setHeaderMap(ApplicationConstant.HEADER_KEY_ID_TOKEN, idToken);
        spaceRequest.setHeaderMap(ApplicationConstant.HEADER_KEY_API_VERSION, spaceVersion);
        spaceRequest.setHeaderMap(ApplicationConstant.HEADER_KEY_PROVIDER, provider);
        spaceRequest.setHeaderMap(ApplicationConstant.HEADER_KEY_CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());

        try {
        	System.out.println("Inside update - try block");
            ResponseEntity<SpaceRequest> response = restClient.execute(spaceRequest, spaceRequestBody, SpaceRequest.class);
            System.out.println(response);
            if (response != null && ObjectUtils.isNotEmpty(response.getBody())) {
            	System.out.println("Inside update - if  block");
                return response.getBody().getId();
            }
        } catch (URISyntaxException | RestClientException e) {
            String errorMessage = "Error occurred while Creating Space for Customer :  "+spaceRequestBody.getId();
            throw new HostBusinessException(errorMessage, new ResponseMessage(
                    HttpStatus.INTERNAL_SERVER_ERROR.toString(), errorMessage, HttpStatus.INTERNAL_SERVER_ERROR));
        }
        System.out.println("Returning from update");
        return null;
    }
    //manageSpaceService.updateSpace(val, authorization, idToken, provider, isPatchUpdate);
}
