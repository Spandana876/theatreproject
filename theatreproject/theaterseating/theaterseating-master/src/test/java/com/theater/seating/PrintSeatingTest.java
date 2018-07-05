package com.theater.seating;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.barclays.pojo.Customer;
import com.barclays.seating.PrintSeating;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.TreeMap;


public class PrintSeatingTest {

    TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();
    PrintSeating testingObject;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        testingObject = new PrintSeating();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printSeatingAssignments_HappyPath() {

        Customer customer = new Customer("Test23", 3);
        Customer customer1 = new Customer("Test44", 4);
        customer.setRowAssigned(1);
        customer.setSectionAssigned(3);
        customer1.setRowAssigned(2);
        customer1.setSectionAssigned(1);
        customerMap.put(1, customer);
        customerMap.put(2, customer1);
        testingObject.printSeatingAssignments(customerMap);
        Assert.assertEquals("Test23 Row 1 Section 3\n" +
                "Test44 Row 2 Section 1\n", outContent.toString());


    }

    @Test
    public void printSeatingAssignments_WitComments() {

        Customer customer = new Customer("Test23", 3);
        Customer customer1 = new Customer("Test44", 4);
        customer.setRowAssigned(1);
        customer.setSectionAssigned(3);
        customer1.setComments(" This is a test");
        customerMap.put(1, customer);
        customerMap.put(2, customer1);
        testingObject.printSeatingAssignments(customerMap);
        Assert.assertEquals("Test23 Row 1 Section 3\n" +
                "Test44 This is a test\n", outContent.toString());


    }

    @Test
    public void printSeatingAssignments_NoSeatingAvailable() {

        Customer customer = new Customer("Test23", 3);
        Customer customer1 = new Customer("Test44", 4);
        customer.setRowAssigned(1);
        customer.setSectionAssigned(3);
        customerMap.put(1, customer);
        customerMap.put(2, customer1);
        testingObject.printSeatingAssignments(customerMap);
        Assert.assertEquals("Test23 Row 1 Section 3\n" +
                "Test44\n", outContent.toString());


    }
}
