/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.garment.Dress;
import com.ameer.phicasaweb.domain.garment.Dress;
import com.ameer.phicasaweb.repository.DressRepository;
import com.ameer.phicasaweb.repository.DressRepository;
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
public class DressRepositoryTestTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private DressRepository repo;
    
    public DressRepositoryTestTest() {
    }

    @Test
     public void createDress() {
         repo = ctx.getBean(DressRepository.class);
         Dress p = new Dress.Builder("Ameer")
                 .garmentColor("Pink")
                 .garmentSize("Large")
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createDress")
     public void readDress(){
         repo = ctx.getBean(DressRepository.class);
         Dress obj = repo.findOne(id);
         Assert.assertEquals(obj.getColor(), "Pink");
         
     }
     
    @Test(dependsOnMethods = "readDress")
     private void updateDress(){
         repo = ctx.getBean(DressRepository.class);
         Dress updatedVIPCustomer = new Dress.Builder("Ameer")
                 .garmentColor("Blue")
                 .garmentSize("Large")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getColor(), "Blue");
         
     }
     
    @Test(dependsOnMethods = "updateDress")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(DressRepository.class);
         Dress obj = repo.findOne(id);
         repo.delete(obj);
         
         Dress deletedVIPCustomer = repo.findOne(id);
         
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
