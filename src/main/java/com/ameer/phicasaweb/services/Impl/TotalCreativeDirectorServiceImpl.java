/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.CreativeDirector;
import com.ameer.phicasaweb.repository.CreativeDirectorRepository;
import com.ameer.phicasaweb.services.TotalCreativeDirectorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalCreativeDirectorServiceImpl implements TotalCreativeDirectorService{
    
    @Autowired
    private CreativeDirectorRepository customerRepository;
    
    @Override
    public List<CreativeDirector> getTotal() {
    return customerRepository.findAll();    
    }
}
