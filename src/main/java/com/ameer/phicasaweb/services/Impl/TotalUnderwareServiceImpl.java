/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Underware;
import com.ameer.phicasaweb.repository.UnderwareRepository;
import com.ameer.phicasaweb.services.TotalUnderwareService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalUnderwareServiceImpl implements TotalUnderwareService{
    
    @Autowired
    private UnderwareRepository customerRepository;
    
    @Override
    public List<Underware> getTotal() {
    return customerRepository.findAll();    
    }
}
