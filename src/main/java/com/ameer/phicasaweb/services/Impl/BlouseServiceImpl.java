/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Blouse;
import com.ameer.phicasaweb.repository.BlouseRepository;
import com.ameer.phicasaweb.services.BlouseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class BlouseServiceImpl implements BlouseService{
    
    @Autowired
    private BlouseRepository blouseRepository;

    @Override
    public Blouse find(Long id) {
        return blouseRepository.findOne(id);
    }

    @Override
    public Blouse persist(Blouse entity) {
        return blouseRepository.save(entity);
    }

    @Override
    public Blouse merge(Blouse entity) {
        if(entity.getId() != null){
            return blouseRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Blouse entity) {
        blouseRepository.delete(entity);
    }

    @Override
    public List<Blouse> findAll() {
        return blouseRepository.findAll();
    }
    
    @Override
    public List<Blouse> getAmtPriceAbove(Double i) {
        List<Blouse> customers = new ArrayList<>();
        List<Blouse> allCustomers = blouseRepository.findAll();
        
        for(Blouse customer : allCustomers){
            if(customer.getPrice()>= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public List<Blouse> getAmtPriceBelow(Double i) {
        List<Blouse> customers = new ArrayList<>();
        List<Blouse> allCustomers = blouseRepository.findAll();
        
        for(Blouse customer : allCustomers){
            if(customer.getPrice()<= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public Blouse getBlouseByName(String name) {
        List<Blouse> customer = findAll();
        Blouse customerFound = null;
        for(Blouse rc : customer){
            if(rc.getName().equalsIgnoreCase(name)){
                customerFound = rc;
            }
        }
        
        return customerFound;
    }

    @Override
    public int getNumberOfBlouse() {
        List<Blouse> rcs = findAll();
        return rcs.size();
    }
    
    
}
