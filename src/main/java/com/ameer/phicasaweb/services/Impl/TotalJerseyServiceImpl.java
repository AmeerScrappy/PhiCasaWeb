/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Jersey;
import com.ameer.phicasaweb.repository.JerseyRepository;
import com.ameer.phicasaweb.services.TotalJerseyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalJerseyServiceImpl implements TotalJerseyService{
    
    @Autowired
    private JerseyRepository customerRepository;
    
    @Override
    public List<Jersey> getTotal() {
    return customerRepository.findAll();    
    }
}
