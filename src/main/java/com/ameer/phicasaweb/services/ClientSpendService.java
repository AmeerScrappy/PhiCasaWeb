/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services;

import com.ameer.phicasaweb.domain.customer.Client;
import java.util.List;

/**
 *
 * @author Scrappy
 */
public interface ClientSpendService {
    
    public List<Client> getAmtSpendAbove(Double i);
    public List<Client> getAmtSpendBelow(Double i);
}
