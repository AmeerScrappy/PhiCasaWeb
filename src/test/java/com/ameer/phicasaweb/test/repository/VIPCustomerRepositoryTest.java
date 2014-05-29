/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.domain.customer.VIPCustomer;
import com.ameer.phicasaweb.repository.VIPCustomerRepository;
import com.ameer.phicasaweb.test.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Scrappy
 */
public class VIPCustomerRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private VIPCustomerRepository repo;
    
    public VIPCustomerRepositoryTest() {
    }

    @Test
     public void createVIPCustomer() {
         repo = ctx.getBean(VIPCustomerRepository.class);
         VIPCustomer p = new VIPCustomer.Builder("Ameer")
                 .surname("Scrappy")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createVIPCustomer")
     public void readVIPCustomer(){
         repo = ctx.getBean(VIPCustomerRepository.class);
         VIPCustomer person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readVIPCustomer")
     private void updateVIPCustomer(){
         repo = ctx.getBean(VIPCustomerRepository.class);
         VIPCustomer person = repo.findOne(id);
         VIPCustomer updatedVIPCustomer = new VIPCustomer.Builder("Ameer")
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateVIPCustomer")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(VIPCustomerRepository.class);
         VIPCustomer person = repo.findOne(id);
         repo.delete(person);
         
         VIPCustomer deletedVIPCustomer = repo.findOne(id);
         
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
