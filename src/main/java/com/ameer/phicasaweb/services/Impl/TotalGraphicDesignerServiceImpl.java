/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.services.Impl;

import com.ameer.phicasaweb.domain.employee.GraphicDesigner;
import com.ameer.phicasaweb.repository.GraphicDesignerRepository;
import com.ameer.phicasaweb.services.TotalGraphicDesignerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Scrappy
 */
@Service
public class TotalGraphicDesignerServiceImpl implements TotalGraphicDesignerService{
    
    @Autowired
    private GraphicDesignerRepository customerRepository;
    
    @Override
    public List<GraphicDesigner> getTotal() {
    return customerRepository.findAll();    
    }
}
