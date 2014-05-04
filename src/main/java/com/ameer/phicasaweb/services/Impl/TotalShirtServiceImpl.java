/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Shirt;
import com.ameer.phicasaweb.repository.ShirtRepository;
import com.ameer.phicasaweb.services.TotalShirtService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalShirtServiceImpl implements TotalShirtService{
    
    @Autowired
    private ShirtRepository customerRepository;
    
    @Override
    public List<Shirt> getTotal() {
    return customerRepository.findAll();    
    }
    
}
