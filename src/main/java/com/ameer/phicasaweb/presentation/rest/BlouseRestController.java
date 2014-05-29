/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.presentation.rest;

import com.ameer.phicasaweb.domain.garment.Blouse;
import com.ameer.phicasaweb.services.BlouseService;
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
@RequestMapping(value = "api/blouse")
public class BlouseRestController {
    
    @Autowired
    private BlouseService blouseService;
    
    @RequestMapping(value = "create",method = RequestMethod.PUT) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody Blouse customer) { // @RequestBody for converting incoming JSON call to Object
        blouseService.persist(customer);
        
        System.out.println(" Create the Called ");
        return "Blouses Created";
    }
    
    @RequestMapping(value = "name/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public Blouse getByName(@PathVariable String name){
        Blouse customer = blouseService.getBlouseByName(name);
        if(customer != null){
            return customer;
        }
        
        return null;
    }
    
    @RequestMapping(value = "blouse",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Blouse> getCustomers() {
        System.out.println("All blouse");
        return blouseService.findAll();
    }
}
