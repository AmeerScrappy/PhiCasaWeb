/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.presentation.rest;

import com.ameer.phicasaweb.domain.customer.Client;
import com.ameer.phicasaweb.services.ClientSpendService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Scrappy
 */
@Controller  // Annotation to make this class be detectable by the config as a controller
@RequestMapping(value = "api/client")
public class ClientRestController {
    
    @Autowired
    private ClientSpendService clientService;
    
    @RequestMapping(value = "create",method = RequestMethod.PUT) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody Client customer) { // @RequestBody for converting incoming JSON call to Object
        clientService.persist(customer);
        
        System.out.println(" Create the Called ");
        return "Blouses Created";
    }
    
    @RequestMapping(value = "name/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public Client getByName(@PathVariable String name){
        Client customer = clientService.getClientByName(name);
        if(customer != null){
            return customer;
        }
        
        return null;
    }
    
    @RequestMapping(value = "client",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Client> getCustomers() {
        System.out.println("All blouse");
        return clientService.findAll();
    }
    
}
