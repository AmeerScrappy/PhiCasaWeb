/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.DistributionTeam;
import com.ameer.phicasaweb.repository.DistributionTeamRepository;
import com.ameer.phicasaweb.services.TotalDistributionTeamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalDistributionTeamServiceImpl implements TotalDistributionTeamService{
    
    @Autowired
    private DistributionTeamRepository customerRepository;
    
    @Override
    public List<DistributionTeam> getTotal() {
    return customerRepository.findAll();    
    }
}
