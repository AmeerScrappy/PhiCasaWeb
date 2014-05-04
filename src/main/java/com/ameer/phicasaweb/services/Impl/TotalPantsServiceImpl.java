/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Pants;
import com.ameer.phicasaweb.repository.PantsRepository;
import com.ameer.phicasaweb.services.TotalPantsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalPantsServiceImpl implements TotalPantsService{
    
    @Autowired
    private PantsRepository customerRepository;
    
    @Override
    public List<Pants> getTotal() {
    return customerRepository.findAll();    
    }
}
