package com.barclays.seating;

import java.util.TreeMap;

import com.barclays.pojo.Customer;
import com.barclays.pojo.SeatingArrangement;


public class AssignSeating {

    public final static String CANNOT_HANDLE_PARTY_MSG = " Sorry we can't handle your party.";
    public final static String SPLIT_PARTY_MSG = " Call to split party.";
    private int highestSeatSection;
    private int totalSeats;

    public void processSeating(SeatingArrangement seatingArrangement, int highestSeatSection, int totalSeats) {

        this.highestSeatSection = highestSeatSection;
        this.totalSeats = totalSeats;
        assignSeatingToCustomers(seatingArrangement.getCustomerMap(), seatingArrangement.getSeatingMatrix());
        handleSplitOrders(seatingArrangement.getCustomerMap());
        handleLargeOrders(seatingArrangement.getCustomerMap());
    }


    private void handleSplitOrders(TreeMap<Integer, Customer> customerMap) {
        customerMap.forEach((key, customer) -> {
            if (customer.getSeatingNeeded() > highestSeatSection) {
                customer.setComments(SPLIT_PARTY_MSG);
            }

        });
    }

    private void handleLargeOrders(TreeMap<Integer, Customer> customerMap) {
        customerMap.forEach((key, customer) -> {
            if (customer.getSeatingNeeded() > totalSeats) {
                customer.setComments(CANNOT_HANDLE_PARTY_MSG);
            }

        });
    }

    private void assignSeatingToCustomers(TreeMap<Integer, Customer> customerMap, int[][] seatingMatrix) {
        customerMap.forEach((key, customer) -> {
            customerLoop:
            for (int row = 1; row < 6; row++) {
                for (int section = 1; section < 6; section++) {
                    if ((seatingMatrix[row][section] == customer.getSeatingNeeded() && row < 4) && customer.getRowAssigned() == null) {
                        customer.setRowAssigned(row);
                        customer.setSectionAssigned(section);
                        break customerLoop;
                    }
                    if (seatingMatrix[row][section] == customer.getSeatingNeeded() && row >= 4 && customer.getRowAssigned() == null) {
                        for (int rowRepeater = 1; rowRepeater < 4; rowRepeater++) {
                            for (int sectionRepeater = 1; sectionRepeater < 6; sectionRepeater++) {
                                if ((seatingMatrix[rowRepeater][sectionRepeater] > customer.getSeatingNeeded()) && customer.getRowAssigned() == null) {
                                    customer.setRowAssigned(rowRepeater);
                                    customer.setSectionAssigned(sectionRepeater);
                                    seatingMatrix[rowRepeater][sectionRepeater] = seatingMatrix[rowRepeater][sectionRepeater] - customer.getSeatingNeeded();
                                    break customerLoop;
                                }
                            }
                            customer.setRowAssigned(row);
                            customer.setSectionAssigned(section);
                            break customerLoop;
                        }
                    }
                }
            }
        });
    }


}
