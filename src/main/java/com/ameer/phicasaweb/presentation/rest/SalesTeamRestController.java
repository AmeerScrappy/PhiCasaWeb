/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.presentation.rest;

import com.ameer.phicasaweb.domain.employee.SalesTeam;
import com.ameer.phicasaweb.services.SalesTeamService;
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
@RequestMapping(value = "api/salesteam")
public class SalesTeamRestController {
    
    @Autowired
    private SalesTeamService salesTeamService;
    
    @RequestMapping(value = "create",method = RequestMethod.PUT) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody SalesTeam customer) { // @RequestBody for converting incoming JSON call to Object
        salesTeamService.persist(customer);
        
        System.out.println(" Create the Called ");
        return "SalesTeams Created";
    }
    
    @RequestMapping(value = "name/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/club/football
    @ResponseBody
    public SalesTeam getByName(@PathVariable String name){
        SalesTeam customer = salesTeamService.getSalesPersonByName(name);
        if(customer != null){
            return customer;
        }
        
        return null;
    }
    
    @RequestMapping(value = "salesteam",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<SalesTeam> getCustomers() {
        System.out.println("All People");
        return salesTeamService.findAll();
    }
    
}
