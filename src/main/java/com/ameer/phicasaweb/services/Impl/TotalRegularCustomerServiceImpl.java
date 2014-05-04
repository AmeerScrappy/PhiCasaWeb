/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.customer.RegularCustomer;
import com.ameer.phicasaweb.repository.RegularCustomerRepository;
import com.ameer.phicasaweb.services.TotalRegularCustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalRegularCustomerServiceImpl implements TotalRegularCustomerService{
    
    @Autowired
    private RegularCustomerRepository customerRepository;
    
    @Override
    public List<RegularCustomer> getTotal() {
    return customerRepository.findAll();    
    }
}
