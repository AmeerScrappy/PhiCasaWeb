/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;


import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.employee.CMT;
import com.ameer.phicasaweb.repository.CMTRepository;
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
public class CMTRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private CMTRepository repo;
    
    public CMTRepositoryTest() {
    }

    @Test
     public void createCMT() {
         repo = ctx.getBean(CMTRepository.class);
         CMT p = new CMT.Builder("Ameer")
                 .surname("Scrappy")
                 .salary(2000.0)
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createCMT")
     public void readCMT(){
         repo = ctx.getBean(CMTRepository.class);
         CMT person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readCMT")
     private void updateCMT(){
         repo = ctx.getBean(CMTRepository.class);
         CMT person = repo.findOne(id);
         CMT updatedVIPCustomer = new CMT.Builder("Ameer")
                 .salary(10000.0)
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateCMT")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(CMTRepository.class);
         CMT person = repo.findOne(id);
         repo.delete(person);
         
         CMT deletedVIPCustomer = repo.findOne(id);
         
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
