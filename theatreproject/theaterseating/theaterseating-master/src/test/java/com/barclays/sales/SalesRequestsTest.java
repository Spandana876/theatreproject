package com.barclays.sales;

import org.junit.Assert;
import org.junit.Test;

import com.barclays.pojo.SeatingArrangement;
import com.barclays.sales.SalesRequests;


public class SalesRequestsTest {

    SalesRequests processPreSaleRequests;

    @Test
    public void processInputFile_HappyPath() {
        processPreSaleRequests = new SalesRequests();

        SeatingArrangement seatingAndCustomerRequest = processPreSaleRequests.extractInfoFromFile("test_resource.txt");
        Assert.assertNotNull(seatingAndCustomerRequest);
        Assert.assertNotNull(seatingAndCustomerRequest.getCustomerMap());

        seatingAndCustomerRequest.getCustomerMap().forEach((key, customer)->{
            if(customer.getName().equals("Test33")) {
                Assert.assertTrue(customer.getRowAssigned() == 1);
                Assert.assertTrue(customer.getSectionAssigned() == 1);
            }
            if(customer.getName().equals("Test56")) {
                Assert.assertTrue(customer.getRowAssigned() == 2);
                Assert.assertTrue(customer.getSectionAssigned() == 2);
            }
        });


    }


    @Test
    public void processInputFile_FileNoIssue() {
        processPreSaleRequests = new SalesRequests();
        try {

            processPreSaleRequests.extractInfoFromFile("test_resource.txt");
        } catch (Exception e) {
            Assert.fail("Exception " + e);
        }

    }

    @Test
    public void processInputFile_FileNotFound() {
        processPreSaleRequests = new SalesRequests();
        try {

            processPreSaleRequests.extractInfoFromFile("nonametest_resource.txt");
            Assert.fail("Exception should have been thrown");

        } catch (Exception e) {

        }

    }
}
