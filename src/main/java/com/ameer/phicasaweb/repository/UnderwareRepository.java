/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.repository;

import com.ameer.phicasaweb.domain.garment.Underware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Scrappy
 */
@Repository
public interface UnderwareRepository extends JpaRepository<Underware, Long>{
    
}
