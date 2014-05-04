/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.Grader;
import com.ameer.phicasaweb.repository.GraderRepository;
import com.ameer.phicasaweb.services.TotalGraderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Scrappy
 */
@Service
public class TotaGraderServiceImpl implements TotalGraderService{
    
    @Autowired
    private GraderRepository customerRepository;
    
    @Override
    public List<Grader> getTotal() {
    return customerRepository.findAll();    
    }
}
