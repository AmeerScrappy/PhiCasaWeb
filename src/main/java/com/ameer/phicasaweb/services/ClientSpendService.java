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
public interface ClientSpendService extends Services <Client, Long>{
    
    public List<Client> getAmtSpendAbove(Double i);
    public List<Client> getAmtSpendBelow(Double i);
    
    public Client getClientByName(String name);
    public int getNumberOfClient();
    
}
