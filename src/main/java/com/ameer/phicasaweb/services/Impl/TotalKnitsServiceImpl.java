/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Knits;
import com.ameer.phicasaweb.repository.KnitsRepository;
import com.ameer.phicasaweb.services.TotalKnitsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalKnitsServiceImpl implements TotalKnitsService{
    
    @Autowired
    private KnitsRepository customerRepository;
    
    @Override
    public List<Knits> getTotal() {
    return customerRepository.findAll();    
    }
}
