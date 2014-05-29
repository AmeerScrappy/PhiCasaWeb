/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.customer.Client;
import com.ameer.phicasaweb.repository.ClientRepository;
import com.ameer.phicasaweb.services.ClientSpendService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class ClientSpendServiceImpl implements ClientSpendService{

    @Autowired
    private ClientRepository clientRepository;
    
    @Override
    public Client find(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client persist(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client merge(Client entity) {
        if(entity.getId() != null){
            return clientRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Client entity) {
        clientRepository.delete(entity);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
    
    @Override
    public List<Client> getAmtSpendAbove(Double i) {
        List<Client> customers = new ArrayList<>();
        List<Client> allCustomers = clientRepository.findAll();
        
        for(Client customer : allCustomers){
            if(customer.getSpending()>= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public List<Client> getAmtSpendBelow(Double i) {
        List<Client> customers = new ArrayList<>();
        List<Client> allCustomers = clientRepository.findAll();
        
        for(Client customer : allCustomers){
            if(customer.getSpending()<= i){
                customers.add(customer);
            }
        }
        
        return customers;
    }

    @Override
    public Client getClientByName(String name) {
        List<Client> customer = findAll();
        Client customerFound = null;
        for(Client rc : customer){
            if(rc.getName().equalsIgnoreCase(name)){
                customerFound = rc;
            }
        }
        
        return customerFound;
    }

    @Override
    public int getNumberOfClient() {
        List<Client> rcs = findAll();
        return rcs.size();
    }
    
}
