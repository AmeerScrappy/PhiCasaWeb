/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services;

import com.ameer.phicasaweb.domain.customer.RegularCustomer;
import java.util.List;

/**
 *
 * @author Scrappy
 */
public interface RegularCustomerService extends Services <RegularCustomer, Long>{
    
    public List<RegularCustomer> getAmtSpendAbove(Double i);
    public List<RegularCustomer> getAmtSpendBelow(Double i);
    
    public RegularCustomer getCustomerByName(String name);
    public int getNumberOfCustomer();
    
}
