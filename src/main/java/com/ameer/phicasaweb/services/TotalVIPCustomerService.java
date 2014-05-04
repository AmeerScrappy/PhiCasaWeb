/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services;

import com.ameer.phicasaweb.domain.customer.VIPCustomer;
import java.util.List;

/**
 *
 * @author Scrappy
 */
public interface TotalVIPCustomerService {
    
    public List<VIPCustomer> getTotal();
    
}
