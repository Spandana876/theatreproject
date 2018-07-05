package com.barclays.seating;

import com.barclays.pojo.Customer;

import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;


public class PrintSeating {

    public void printSeatingAssignments(TreeMap<Integer, Customer> customerTreeMap) {
        customerTreeMap.forEach((key, customer) -> {
            StringBuilder printAssignment = new StringBuilder();
            printAssignment.append(customer.getName());
            if (StringUtils.isBlank(customer.getComments()) && customer.getRowAssigned() != null && customer.getSectionAssigned() != null) {
                printAssignment.append(" Row " + customer.getRowAssigned() + " Section " + customer.getSectionAssigned());

            } else if (StringUtils.isNotBlank(customer.getComments())) {
                printAssignment.append(customer.getComments());
            }
            System.out.println(printAssignment);

        });
    }
}
