/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.MarketingTeam;
import com.ameer.phicasaweb.repository.MarketingTeamRepository;
import com.ameer.phicasaweb.services.TotalMarketingTeamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalMarketingTeamServiceImpl implements TotalMarketingTeamService{
    
    @Autowired
    private MarketingTeamRepository customerRepository;
    
    @Override
    public List<MarketingTeam> getTotal() {
    return customerRepository.findAll();    
    }
}
