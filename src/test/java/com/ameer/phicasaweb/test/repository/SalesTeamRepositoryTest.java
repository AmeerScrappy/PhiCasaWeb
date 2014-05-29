/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.employee.SalesTeam;
import com.ameer.phicasaweb.repository.SalesTeamRepository;
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
public class SalesTeamRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private SalesTeamRepository repo;
    
    public SalesTeamRepositoryTest() {
    }

    @Test
     public void createSalesTeam() {
         repo = ctx.getBean(SalesTeamRepository.class);
         SalesTeam p = new SalesTeam.Builder("Ameer")
                 .surname("Scrappy")
                 .salary(2000.0)
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createSalesTeam")
     public void readSalesTeam(){
         repo = ctx.getBean(SalesTeamRepository.class);
         SalesTeam person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readSalesTeam")
     private void updateSalesTeam(){
         repo = ctx.getBean(SalesTeamRepository.class);
         SalesTeam person = repo.findOne(id);
         SalesTeam updatedVIPCustomer = new SalesTeam.Builder("Ameer")
                 .salary(10000.0)
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateSalesTeam")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(SalesTeamRepository.class);
         SalesTeam person = repo.findOne(id);
         repo.delete(person);
         
         SalesTeam deletedVIPCustomer = repo.findOne(id);
         
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
