/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.FashionDesigner;
import com.ameer.phicasaweb.repository.FashionDesignerRepository;
import com.ameer.phicasaweb.services.TotalFashionDesignerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Scrappy
 */
public class TotalFashionDesignerServiceImpl implements TotalFashionDesignerService{
    
    @Autowired
    private FashionDesignerRepository customerRepository;
    
    @Override
    public List<FashionDesigner> getTotal() {
    return customerRepository.findAll();    
    }
}
