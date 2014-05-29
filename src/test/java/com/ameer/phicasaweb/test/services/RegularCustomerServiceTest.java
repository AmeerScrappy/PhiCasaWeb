/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.services;

import com.ameer.phicasaweb.domain.customer.RegularCustomer;
import com.ameer.phicasaweb.repository.RegularCustomerRepository;
import com.ameer.phicasaweb.services.RegularCustomerService;
import com.ameer.phicasaweb.test.ConnectionConfigTest;
import java.util.List;
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
public class RegularCustomerServiceTest {
    
    public RegularCustomerServiceTest() {
    }

    public static ApplicationContext ctx;
    private RegularCustomerRepository customerRepository;
    private RegularCustomerService customerService;
   
   
    @Test
     public void AmtAbove() {
         
//         customerRepository = ctx.getBean(RegularCustomerRepository.class);
//         customerService = ctx.getBean(RegularCustomerService.class);
//         
//         RegularCustomer obj1 = new RegularCustomer.Builder("Ameer")
//                 .surname("Mallagie")
//                 .paid(1000.0)
//                 .build();
//         RegularCustomer obj2 = new RegularCustomer.Builder("Scrappy")
//                 .surname("Guy")
//                 .paid(10000.0)
//                 .build();
//         RegularCustomer obj3 = new RegularCustomer.Builder("Water")
//                 .surname("Flask")
//                 .paid(2000.0)
//                 .build();
//         customerRepository.save(obj1);
//         customerRepository.save(obj2);
//         customerRepository.save(obj3);
//         
//         List<RegularCustomer> people = customerService.getAmtSpendAbove(1999.0);
//         
//         Assert.assertEquals(people.size(), 2);
     }
     
     @Test
     public void AmtBelow() {
         
//         customerRepository = ctx.getBean(RegularCustomerRepository.class);
//         customerService = ctx.getBean(RegularCustomerService.class);
//         
//         RegularCustomer obj1 = new RegularCustomer.Builder("Ameer")
//                 .surname("Mallagie")
//                 .paid(1000.0)
//                 .build();
//         RegularCustomer obj2 = new RegularCustomer.Builder("Scrappy")
//                 .surname("Guy")
//                 .paid(10000.0)
//                 .build();
//         RegularCustomer obj3 = new RegularCustomer.Builder("Water")
//                 .surname("Flask")
//                 .paid(2000.0)
//                 .build();
//         customerRepository.save(obj1);
//         customerRepository.save(obj2);
//         customerRepository.save(obj3);
//         
//         List<RegularCustomer> people = customerService.getAmtSpendBelow(1999.0);
//         
//         Assert.assertEquals(people.size(), 2);
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
