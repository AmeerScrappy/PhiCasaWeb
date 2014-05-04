/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.CMT;
import com.ameer.phicasaweb.repository.CMTRepository;
import com.ameer.phicasaweb.services.TotalCMTService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalCMTServiceImpl implements TotalCMTService{
    
    @Autowired
    private CMTRepository customerRepository;
    
    @Override
    public List<CMT> getTotal() {
    return customerRepository.findAll();    
    }
}
