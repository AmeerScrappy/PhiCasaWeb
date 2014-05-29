/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.domain.garment.Blouse;
import com.ameer.phicasaweb.repository.BlouseRepository;
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
public class BlouseRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private BlouseRepository repo;
    
    public BlouseRepositoryTest() {
    }

    @Test
     public void createBlouse() {
         repo = ctx.getBean(BlouseRepository.class);
         Blouse p = new Blouse.Builder("Ameer")
                 .garmentColor("Pink")
                 .garmentSize("Large")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createBlouse")
     public void readBlouse(){
         repo = ctx.getBean(BlouseRepository.class);
         Blouse obj = repo.findOne(id);
         Assert.assertEquals(obj.getColor(), "Pink");
         
     }
     
    @Test(dependsOnMethods = "readBlouse")
     private void updateBlouse(){
         repo = ctx.getBean(BlouseRepository.class);
         Blouse updatedVIPCustomer = new Blouse.Builder("Ameer")
                 .garmentColor("Blue")
                 .garmentSize("Large")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getColor(), "Blue");
         
     }
     
    @Test(dependsOnMethods = "updateBlouse")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(BlouseRepository.class);
         Blouse obj = repo.findOne(id);
         repo.delete(obj);
         
         Blouse deletedVIPCustomer = repo.findOne(id);
         
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
