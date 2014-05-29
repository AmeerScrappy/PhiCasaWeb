/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services;

import com.ameer.phicasaweb.domain.garment.Blouse;
import java.util.List;

/**
 *
 * @author Scrappy
 */
public interface BlouseService extends Services <Blouse, Long>{
    
    public List<Blouse> getAmtPriceAbove(Double i);
    public List<Blouse> getAmtPriceBelow(Double i);
    
    public Blouse getBlouseByName(String name);
    public int getNumberOfBlouse();
    
}
