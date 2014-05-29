/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.restapi;

import com.ameer.phicasaweb.domain.customer.Client;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Scrappy
 */
public class ClientRestController {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8084/phicasaweb/";
    
    @Test
    public void testCreate() {
        Client customer = new Client.Builder("Twisp").build();
        HttpEntity<Client> requestEntity = new HttpEntity<>(customer, getContentType());
        ResponseEntity<String> responseEntity = restTemplate
                .exchange(URL + "api/client/create", HttpMethod.PUT, requestEntity, String.class);
        
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
    
    @Test
    public void testReadbyName(){
        
        String name = "Scrappy";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Client> responseEntity = restTemplate.exchange(URL + "api/client/name/" + 
                name, HttpMethod.GET, requestEntity, Client.class);
        Client customer = responseEntity.getBody();
        
        Assert.assertNotNull(customer);
    }
    
    @Test
    public void testGetAllCustomer(){
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Client[]> responseEntity = restTemplate.exchange(URL + "api/client/client", HttpMethod.GET, requestEntity, Client[].class);
        Client[] customers = responseEntity.getBody();
        for(Client customer : customers){
            System.out.println("The Customer's Name is " + customer.getName());
        }
        
        Assert.assertTrue(customers.length > 0);
    }
    
    private HttpEntity<?> getHttpEntity(){
         HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
}
