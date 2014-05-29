/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ameer.phicasaweb.test.services;

import com.ameer.phicasaweb.app.conf.ConnectionConfig;
import com.ameer.phicasaweb.domain.employee.MarketingTeam;
import com.ameer.phicasaweb.services.TotalMarketingTeamService;
import com.ameer.phicasaweb.test.ConnectionConfigTest;
import java.util.List;
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
public class TotalMarketingTeamServiceTest {
    
    public TotalMarketingTeamServiceTest() {
    }

    public static ApplicationContext ctx;
    private TotalMarketingTeamService service;
   
   
    @Test
     public void total() {
//         service = ctx.getBean(TotalMarketingTeamService.class);
//         List<MarketingTeam> entities = service.getTotal();
//         
//         Assert.assertEquals(0, entities.size(), " Expect none");
     
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
