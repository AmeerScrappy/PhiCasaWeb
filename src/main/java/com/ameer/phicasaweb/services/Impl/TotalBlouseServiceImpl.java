/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Blouse;
import com.ameer.phicasaweb.repository.BlouseRepository;
import com.ameer.phicasaweb.services.TotalBlouseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalBlouseServiceImpl implements TotalBlouseService{
    
    @Autowired
    private BlouseRepository customerRepository;
    
    @Override
    public List<Blouse> getTotal() {
    return customerRepository.findAll();    
    }
}
