/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.SalesTeam;
import com.ameer.phicasaweb.repository.SalesTeamRepository;
import com.ameer.phicasaweb.services.SalesTeamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalSalesTeamServiceImpl implements SalesTeamService{
    
    @Autowired
    private SalesTeamRepository customerRepository;
    
    @Override
    public List<SalesTeam> getTotal() {
    return customerRepository.findAll();    
    }
    
}
