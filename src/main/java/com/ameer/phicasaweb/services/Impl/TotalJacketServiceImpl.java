/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.garment.Jacket;
import com.ameer.phicasaweb.repository.JacketRepository;
import com.ameer.phicasaweb.services.TotalJacketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalJacketServiceImpl implements TotalJacketService{
    
    @Autowired
    private JacketRepository customerRepository;
    
    @Override
    public List<Jacket> getTotal() {
    return customerRepository.findAll();    
    }
}
