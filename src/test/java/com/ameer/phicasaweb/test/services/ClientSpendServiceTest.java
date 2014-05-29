/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.services;

import com.ameer.phicasaweb.domain.customer.Client;
import com.ameer.phicasaweb.repository.ClientRepository;
import com.ameer.phicasaweb.services.ClientSpendService;
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
public class ClientSpendServiceTest {
    
    private static ApplicationContext ctx;
    private ClientSpendService clientSpendService;
    private ClientRepository clientRepository;
    
    public ClientSpendServiceTest() {
    }

    @Test
    public void getSpendingofClient() {
//        clientRepository = ctx.getBean(ClientRepository.class);
//        clientSpendService = ctx.getBean(ClientSpendService.class);
//        
//        Client p1 = new Client.Builder("Ameer")
//                .email("ameer.mallagie@hotmail.com")
//                .spend(2000.00)
//                .build();
//        Client p2 = new Client.Builder("Scrappy")
//                .email("ameer3scrappy@gmail.com")
//                .spend(1000.0)
//                .build();
//        Client p3 = new Client.Builder("Phone")
//                .email("ameer3scrappy@rocketmail.com")
//                .spend(50000.0)
//                .build();
//
//        clientRepository.save(p1);
//        clientRepository.save(p2);
//        clientRepository.save(p3);
//
//        List<Client> people = clientSpendService.getAmtSpendAbove(2000.0);
//
//        Assert.assertEquals(people.size(), 2);

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
