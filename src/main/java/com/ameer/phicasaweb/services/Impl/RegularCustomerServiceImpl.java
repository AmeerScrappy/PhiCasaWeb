/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.customer.RegularCustomer;
import com.ameer.phicasaweb.repository.RegularCustomerRepository;
import com.ameer.phicasaweb.services.RegularCustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class RegularCustomerServiceImpl implements RegularCustomerService{
    
    @Autowired
    private RegularCustomerRepository customerRepository;

    @Override
    public RegularCustomer find(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public RegularCustomer persist(RegularCustomer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public RegularCustomer merge(RegularCustomer entity) {
        if(entity.getId() != null){
            return customerRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(RegularCustomer entity) {
        customerRepository.delete(entity);
    }

    @Override
    public List<RegularCustomer> findAll() {
        return customerRepository.findAll();
    }
    
    @Override
    public List<RegularCustomer> getAmtSpendAbove(Double i) {
        List<RegularCustomer> customers = new ArrayList<>();
        List<RegularCustomer> allCustomers = customerRepository.findAll();
        
        for(RegularCustomer customer : allCustomers){
            if(customer.getPaid() >= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public List<RegularCustomer> getAmtSpendBelow(Double i) {
        List<RegularCustomer> customers = new ArrayList<>();
        List<RegularCustomer> allCustomers = customerRepository.findAll();
        
        for(RegularCustomer customer : allCustomers){
            if(customer.getPaid() <= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public RegularCustomer getCustomerByName(String name) {
        List<RegularCustomer> customer = findAll();
        RegularCustomer customerFound = null;
        for(RegularCustomer rc : customer){
            if(rc.getName().equalsIgnoreCase(name)){
                customerFound = rc;
            }
        }
        
        return customerFound;
    }

    @Override
    public int getNumberOfCustomer() {
        List<RegularCustomer> rcs = findAll();
        return rcs.size();
    }

    

}
