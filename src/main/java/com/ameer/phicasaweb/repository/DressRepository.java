/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.repository;

import com.ameer.phicasaweb.domain.employee.FashionDesigner;
import com.ameer.phicasaweb.domain.garment.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Scrappy
 */
@Repository
public interface DressRepository extends JpaRepository<Dress, Long>{
    
}
