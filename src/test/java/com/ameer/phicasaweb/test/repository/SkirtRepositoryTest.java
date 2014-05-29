/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.garment.Skirt;
import com.ameer.phicasaweb.repository.SkirtRepository;
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
public class SkirtRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private SkirtRepository repo;
    
    public SkirtRepositoryTest() {
    }

    @Test
     public void createSkirt() {
         repo = ctx.getBean(SkirtRepository.class);
         Skirt p = new Skirt.Builder("Ameer")
                 .garmentColor("Pink")
                 .garmentSize("Large")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createSkirt")
     public void readSkirt(){
         repo = ctx.getBean(SkirtRepository.class);
         Skirt obj = repo.findOne(id);
         Assert.assertEquals(obj.getColor(), "Pink");
         
     }
     
    @Test(dependsOnMethods = "readSkirt")
     private void updateSkirt(){
         repo = ctx.getBean(SkirtRepository.class);
         Skirt updatedVIPCustomer = new Skirt.Builder("Ameer")
                 .garmentColor("Blue")
                 .garmentSize("Large")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getColor(), "Blue");
         
     }
     
    @Test(dependsOnMethods = "updateSkirt")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(SkirtRepository.class);
         Skirt obj = repo.findOne(id);
         repo.delete(obj);
         
         Skirt deletedVIPCustomer = repo.findOne(id);
         
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
