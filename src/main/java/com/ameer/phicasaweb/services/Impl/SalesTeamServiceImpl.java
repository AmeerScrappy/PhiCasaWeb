/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.SalesTeam;
import com.ameer.phicasaweb.repository.SalesTeamRepository;
import com.ameer.phicasaweb.services.SalesTeamService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Scrappy
 */
@Service
public class SalesTeamServiceImpl implements SalesTeamService{
    
    @Autowired
    private SalesTeamRepository salesTeamRepository;

    @Override
    public List<SalesTeam> getAmtSalaryAbove(Double i) {
        List<SalesTeam> customers = new ArrayList<>();
        List<SalesTeam> allCustomers = salesTeamRepository.findAll();
        
        for(SalesTeam customer : allCustomers){
            if(customer.getSalary()>= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public List<SalesTeam> getAmtSalaryBelow(Double i) {
        List<SalesTeam> customers = new ArrayList<>();
        List<SalesTeam> allCustomers = salesTeamRepository.findAll();
        
        for(SalesTeam customer : allCustomers){
            if(customer.getSalary()<= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public SalesTeam getSalesPersonByName(String name) {
        List<SalesTeam> customer = findAll();
        SalesTeam customerFound = null;
        for(SalesTeam rc : customer){
            if(rc.getName().equalsIgnoreCase(name)){
                customerFound = rc;
            }
        }
        
        return customerFound;
    }

    @Override
    public int getNumberOfSalesPeople() {
        List<SalesTeam> rcs = findAll();
        return rcs.size();
    }

    @Override
    public SalesTeam find(Long id) {
        return salesTeamRepository.findOne(id);
    }

    @Override
    public SalesTeam persist(SalesTeam entity) {
        return salesTeamRepository.save(entity);
    }

    @Override
    public SalesTeam merge(SalesTeam entity) {
        if(entity.getId() != null){
            return salesTeamRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(SalesTeam entity) {
        salesTeamRepository.delete(entity);
    }

    @Override
    public List<SalesTeam> findAll() {
        return salesTeamRepository.findAll();
    }
    
    
    
}
