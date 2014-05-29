/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.garment.Knits;
import com.ameer.phicasaweb.repository.KnitsRepository;
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
public class KnitsRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private KnitsRepository repo;
    
    public KnitsRepositoryTest() {
    }

    @Test
     public void createKnits() {
         repo = ctx.getBean(KnitsRepository.class);
         Knits p = new Knits.Builder("Ameer")
                 .garmentColor("Pink")
                 .garmentSize("Large")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createKnits")
     public void readKnits(){
         repo = ctx.getBean(KnitsRepository.class);
         Knits obj = repo.findOne(id);
         Assert.assertEquals(obj.getColor(), "Pink");
         
     }
     
    @Test(dependsOnMethods = "readKnits")
     private void updateKnits(){
         repo = ctx.getBean(KnitsRepository.class);
         Knits updatedVIPCustomer = new Knits.Builder("Ameer")
                 .garmentColor("Blue")
                 .garmentSize("Large")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getColor(), "Blue");
         
     }
     
    @Test(dependsOnMethods = "updateKnits")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(KnitsRepository.class);
         Knits obj = repo.findOne(id);
         repo.delete(obj);
         
         Knits deletedVIPCustomer = repo.findOne(id);
         
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
