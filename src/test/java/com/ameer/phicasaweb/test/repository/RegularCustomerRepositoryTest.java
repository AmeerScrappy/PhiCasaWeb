/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.customer.RegularCustomer;
import com.ameer.phicasaweb.repository.RegularCustomerRepository;
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
public class RegularCustomerRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private RegularCustomerRepository repo;
    
    public RegularCustomerRepositoryTest() {
    }

    @Test
     public void createRegularCustomer() {
         repo = ctx.getBean(RegularCustomerRepository.class);
         RegularCustomer p = new RegularCustomer.Builder("Ameer")
                 .surname("Scrappy")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createRegularCustomer")
     public void readRegularCustomer(){
         repo = ctx.getBean(RegularCustomerRepository.class);
         RegularCustomer person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readRegularCustomer")
     private void updateRegularCustomer(){
         repo = ctx.getBean(RegularCustomerRepository.class);
         RegularCustomer person = repo.findOne(id);
         RegularCustomer updatedRegularCustomer = new RegularCustomer.Builder("Ameer")
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedRegularCustomer);
         
         Assert.assertEquals(updatedRegularCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateRegularCustomer")
     private void deleteRegularCustomer(){
         repo = ctx.getBean(RegularCustomerRepository.class);
         RegularCustomer person = repo.findOne(id);
         repo.delete(person);
         
         RegularCustomer deletedRegularCustomer = repo.findOne(id);
         
         Assert.assertNull(deletedRegularCustomer);
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
