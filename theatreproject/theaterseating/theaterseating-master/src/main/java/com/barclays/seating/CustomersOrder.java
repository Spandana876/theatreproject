package com.barclays.seating;

import java.util.List;
import java.util.TreeMap;

import com.barclays.pojo.Customer;
import com.barclays.pojo.SeatingArrangement;


public class CustomersOrder {

    private int highestSeatSection;
    private int totalSeats;

    public void extractSeatingAndCustomerOrder(SeatingArrangement seatingArrangement) {
        for (int i = 0, j = 1, partyKey = 1; i < seatingArrangement.getTotalRows(); i++, j++) {
            if (i > seatingArrangement.getEmptyRowNumber()) {
                partyKey = extractCustomerOrder(seatingArrangement.getCustomerMap(), seatingArrangement.getLineReaderText(), i, partyKey);

            } else if (i < seatingArrangement.getEmptyRowNumber()) {
                extractSeatingMatrix(seatingArrangement.getLineReaderText(), seatingArrangement.getSeatingMatrix(), i, j);
            }

        }

    }

    private void extractSeatingMatrix(List<StringBuilder> lineReaderText, int[][] seatingMatrix, int i, int j) {
        if (!lineReaderText.isEmpty()) {
            String[] sectionList = lineReaderText.get(i).toString().split(" ");

            for (int section = 0, k = 1; section < sectionList.length; section++, k++) {
                int sectionSeatsCount = Integer.parseInt(sectionList[section]);
                highestSeatSection = Math.max(highestSeatSection, sectionSeatsCount);
                totalSeats = totalSeats + sectionSeatsCount;
                seatingMatrix[j][k] = sectionSeatsCount;
            }
        }
    }

    private int extractCustomerOrder(TreeMap<Integer, Customer> customerMap, List<StringBuilder> lineReaderText, int i, int partyKey) {
        if (!lineReaderText.isEmpty()) {
            String[] custmomerList = lineReaderText.get(i).toString().split(" ");
            Customer seatingSection = new Customer(custmomerList[0], Integer.parseInt(custmomerList[1]));
            customerMap.put(partyKey++, seatingSection);
        }
        return partyKey;
    }

    public int getHighestSeatSection() {
        return highestSeatSection;
    }

    public int getTotalTheaterSeats() {
        return totalSeats;
    }
}
