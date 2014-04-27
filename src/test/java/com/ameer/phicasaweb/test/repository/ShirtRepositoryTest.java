/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.garment.Shirt;
import com.ameer.phicasaweb.repository.ShirtRepository;
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
public class ShirtRepositoryTest {
    
   public static ApplicationContext ctx;
    private Long id;
    private ShirtRepository repo;
    
    public ShirtRepositoryTest() {
    }

    @Test
     public void createShirt() {
         repo = ctx.getBean(ShirtRepository.class);
         Shirt p = new Shirt.Builder("Ameer")
                 .garmentColor("Pink")
                 .garmentSize("Large")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createShirt")
     public void readShirt(){
         repo = ctx.getBean(ShirtRepository.class);
         Shirt obj = repo.findOne(id);
         Assert.assertEquals(obj.getColor(), "Pink");
         
     }
     
    @Test(dependsOnMethods = "readShirt")
     private void updateShirt(){
         repo = ctx.getBean(ShirtRepository.class);
         Shirt updatedVIPCustomer = new Shirt.Builder("Ameer")
                 .garmentColor("Blue")
                 .garmentSize("Large")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getColor(), "Blue");
         
     }
     
    @Test(dependsOnMethods = "updateShirt")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(ShirtRepository.class);
         Shirt obj = repo.findOne(id);
         repo.delete(obj);
         
         Shirt deletedVIPCustomer = repo.findOne(id);
         
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
