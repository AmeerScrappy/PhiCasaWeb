/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services;

import com.ameer.phicasaweb.domain.employee.SalesTeam;
import java.util.List;

/**
 *
 * @author Scrappy
 */
public interface SalesTeamService extends Services <SalesTeam, Long>{
    
    public List<SalesTeam> getAmtSalaryAbove(Double i);
    public List<SalesTeam> getAmtSalaryBelow(Double i);
    
    public SalesTeam getSalesPersonByName(String name);
    public int getNumberOfSalesPeople();
    
}
