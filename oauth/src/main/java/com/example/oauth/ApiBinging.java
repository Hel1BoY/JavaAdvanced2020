package com.example.oauth;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class ApiBinging {
    
    protected RestTemplate restTemplate;

    public ApiBinging(String accessToken){
        this.restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(generateInterceptors(accessToken));
    }

    public ClientHttpRequestInterceptor generateInterceptors(String accessToken){
        return new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest httpRequest,
                                                byte[] bytes,
                                                ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
                httpRequest.getHeaders().add("Authorization","Bearer" + accessToken);
                return clientHttpRequestExecution.execute(httpRequest, bytes);
            }
        };
    }

}
