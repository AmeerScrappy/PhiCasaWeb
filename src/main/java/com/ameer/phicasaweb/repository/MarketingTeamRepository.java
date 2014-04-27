/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.repository;

/**
 *
 * @author Scrappy
 */
import com.ameer.phicasaweb.domain.employee.MarketingTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MarketingTeamRepository extends JpaRepository<MarketingTeam, Long>{
    
}
