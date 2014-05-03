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
    public List<Client> getAmtSpendAbove(Double i) {
        List<Client> clients = new ArrayList<>();
        List<Client> allClients = clientRepository.findAll();
        
        for (Client client : allClients) {
            
            if (client.getSpending() >= i){
                clients.add(client);
            }            
        }
        
        return clients;
    }

    @Override
    public List<Client> getAmtSpendBelow(Double i) {
        List<Client> clients = new ArrayList<>();
        List<Client> allClients = clientRepository.findAll();
        
        for (Client client : allClients) {
            
            if (client.getSpending() <= i){
                clients.add(client);
            }            
        }
        
        return clients;
    }
    
}
