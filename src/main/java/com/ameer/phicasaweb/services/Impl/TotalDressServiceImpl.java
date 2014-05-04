/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Dress;
import com.ameer.phicasaweb.repository.DressRepository;
import com.ameer.phicasaweb.services.TotalDressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalDressServiceImpl implements TotalDressService{
    
    @Autowired
    private DressRepository customerRepository;
    
    @Override
    public List<Dress> getTotal() {
    return customerRepository.findAll();    
    }
}
