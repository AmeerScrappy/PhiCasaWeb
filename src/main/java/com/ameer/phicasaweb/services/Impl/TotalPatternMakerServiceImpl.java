/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.PatternMaker;
import com.ameer.phicasaweb.repository.PatternMakerRepository;
import com.ameer.phicasaweb.services.TotalPatternMakerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalPatternMakerServiceImpl implements TotalPatternMakerService{
    
    @Autowired
    private PatternMakerRepository customerRepository;
    
    @Override
    public List<PatternMaker> getTotal() {
    return customerRepository.findAll();    
    }
}
