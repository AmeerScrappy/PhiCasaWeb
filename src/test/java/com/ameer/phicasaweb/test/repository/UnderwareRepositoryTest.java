/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.garment.Underware;
import com.ameer.phicasaweb.repository.UnderwareRepository;
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
public class UnderwareRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private UnderwareRepository repo;
    
    public UnderwareRepositoryTest() {
    }

    @Test
     public void createUnderware() {
         repo = ctx.getBean(UnderwareRepository.class);
         Underware p = new Underware.Builder("Ameer")
                 .garmentColor("Pink")
                 .garmentSize("Large")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createUnderware")
     public void readUnderware(){
         repo = ctx.getBean(UnderwareRepository.class);
         Underware obj = repo.findOne(id);
         Assert.assertEquals(obj.getColor(), "Pink");
         
     }
     
    @Test(dependsOnMethods = "readUnderware")
     private void updateUnderware(){
         repo = ctx.getBean(UnderwareRepository.class);
         Underware updatedVIPCustomer = new Underware.Builder("Ameer")
                 .garmentColor("Blue")
                 .garmentSize("Large")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getColor(), "Blue");
         
     }
     
    @Test(dependsOnMethods = "updateUnderware")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(UnderwareRepository.class);
         Underware obj = repo.findOne(id);
         repo.delete(obj);
         
         Underware deletedVIPCustomer = repo.findOne(id);
         
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
