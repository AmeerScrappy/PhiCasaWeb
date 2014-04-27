/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.employee.MarketingTeam;
import com.ameer.phicasaweb.repository.MarketingTeamRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Scrappy
 */
public class MarketingTeamRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private MarketingTeamRepository repo;
    
    public MarketingTeamRepositoryTest() {
    }

    @Test
     public void createMarketingTeam() {
         repo = ctx.getBean(MarketingTeamRepository.class);
         MarketingTeam p = new MarketingTeam.Builder("Ameer")
                 .surname("Scrappy")
                 .salary(2000.0)
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createMarketingTeam")
     public void readMarketingTeam(){
         repo = ctx.getBean(MarketingTeamRepository.class);
         MarketingTeam person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readMarketingTeam")
     private void updateMarketingTeam(){
         repo = ctx.getBean(MarketingTeamRepository.class);
         MarketingTeam person = repo.findOne(id);
         MarketingTeam updatedVIPCustomer = new MarketingTeam.Builder("Ameer")
                 .salary(10000.0)
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateMarketingTeam")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(MarketingTeamRepository.class);
         MarketingTeam person = repo.findOne(id);
         repo.delete(person);
         
         MarketingTeam deletedVIPCustomer = repo.findOne(id);
         
         Assert.assertNull(deletedVIPCustomer);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
