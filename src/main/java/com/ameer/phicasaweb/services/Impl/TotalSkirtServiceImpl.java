/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Skirt;
import com.ameer.phicasaweb.repository.SkirtRepository;
import com.ameer.phicasaweb.services.TotalSkirtService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalSkirtServiceImpl implements TotalSkirtService{
    
    @Autowired
    private SkirtRepository customerRepository;
    
    @Override
    public List<Skirt> getTotal() {
    return customerRepository.findAll();    
    }
    
}
