/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.repository;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.employee.FashionDesigner;
import com.ameer.phicasaweb.repository.FashionDesignerRepository;
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
public class FashionDesignerRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;
    private FashionDesignerRepository repo;
    
    public FashionDesignerRepositoryTest() {
    }

    @Test
     public void createFashionDesigner() {
         repo = ctx.getBean(FashionDesignerRepository.class);
         FashionDesigner p = new FashionDesigner.Builder("Ameer")
                 .surname("Scrappy")
                 .salary(2000.0)
                 .build();
         repo.save(p);
         id = p.getId();
         Assert.assertNotNull(p);     
     }
     
     @Test(dependsOnMethods = "createFashionDesigner")
     public void readFashionDesigner(){
         repo = ctx.getBean(FashionDesignerRepository.class);
         FashionDesigner person = repo.findOne(id);
         Assert.assertEquals(person.getSurname(), "Scrappy");
         
     }
     
    @Test(dependsOnMethods = "readFashionDesigner")
     private void updateFashionDesigner(){
         repo = ctx.getBean(FashionDesignerRepository.class);
         FashionDesigner person = repo.findOne(id);
         FashionDesigner updatedVIPCustomer = new FashionDesigner.Builder("Ameer")
                 .salary(10000.0)
                 .surname("Mallagie")
                 .build();
        
         repo.save(updatedVIPCustomer);
         
         Assert.assertEquals(updatedVIPCustomer.getSurname(), "Mallagie");
         
     }
     
    @Test(dependsOnMethods = "updateFashionDesigner")
     private void deleteVIPCustomer(){
         repo = ctx.getBean(FashionDesignerRepository.class);
         FashionDesigner person = repo.findOne(id);
         repo.delete(person);
         
         FashionDesigner deletedVIPCustomer = repo.findOne(id);
         
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
