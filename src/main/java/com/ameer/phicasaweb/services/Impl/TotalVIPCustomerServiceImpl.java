/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.customer.VIPCustomer;
import com.ameer.phicasaweb.repository.VIPCustomerRepository;
import com.ameer.phicasaweb.services.TotalVIPCustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalVIPCustomerServiceImpl implements TotalVIPCustomerService{
    
    @Autowired
    private VIPCustomerRepository customerRepository;
    
    @Override
    public List<VIPCustomer> getTotal() {
    return customerRepository.findAll();    
    }
}
