/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.employee.DistributionTeam;
import com.ameer.phicasaweb.repository.DistributionTeamRepository;
import com.ameer.phicasaweb.test.ConnectionConfigTest;
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
public class DistributionTeamRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private DistributionTeamRepository repo;
    
    public DistributionTeamRepositoryTest() {
    }

    @Test
     public void createDistributionTeam() {
         repo = ctx.getBean(DistributionTeamRepository.class);
         DistributionTeam p = new DistributionTeam.Builder("Ameer")
                 .surname("Scrappy")
                 .salary(2000.0)
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createDistributionTeam")
     public void readDistributionTeam(){
         repo = ctx.getBean(DistributionTeamRepository.class);
         DistributionTeam person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readDistributionTeam")
     private void updateDistributionTeam(){
         repo = ctx.getBean(DistributionTeamRepository.class);
         DistributionTeam person = repo.findOne(id);
         DistributionTeam updatedVIPCustomer = new DistributionTeam.Builder("Ameer")
                 .salary(10000.0)
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateDistributionTeam")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(DistributionTeamRepository.class);
         DistributionTeam person = repo.findOne(id);
         repo.delete(person);
         
         DistributionTeam deletedVIPCustomer = repo.findOne(id);
         
         Assert.assertNull(deletedVIPCustomer);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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
