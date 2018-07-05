package com.barclays.sales;

import com.barclays.TheaterSeating;
import com.barclays.pojo.Customer;
import com.barclays.pojo.SeatingArrangement;
import com.barclays.seating.CustomersOrder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class SalesRequests {

    public SeatingArrangement extractInfoFromFile(String file) {
        InputStream resourceAsStream = null;
        TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();
        SeatingArrangement seatingArrangement = null;

        try {
            LineNumberReader in = new LineNumberReader(new InputStreamReader(TheaterSeating.class.getClassLoader().getResourceAsStream(file)));
            int emptyRowNumber = 0;
            Integer totalRows = new Integer(0);

            List<StringBuilder> lineReaderText = new ArrayList<>();
            String line = null;


            while ((line = in.readLine()) != null) {
                lineReaderText.add(totalRows, new StringBuilder(line));
                if (line.trim().isEmpty()) {
                    emptyRowNumber = in.getLineNumber() - 1;
                }
                totalRows++;
            }

            seatingArrangement = setSeatingArrangement(customerMap, emptyRowNumber, totalRows, lineReaderText);


        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Sorry, error while reading input file");
        } finally {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Sorry, error while closing input reader");

                }
            }
        }
        return seatingArrangement;
    }

    private SeatingArrangement setSeatingArrangement(TreeMap<Integer, Customer> customerMap, int emptyRowNumber, Integer totalRows, List<StringBuilder> lineReaderText) {
        SeatingArrangement seatingArrangement;
        int[][] seatingMatrix = new int[6][6];
        seatingArrangement = new SeatingArrangement();
        seatingArrangement.setEmptyRowNumber(emptyRowNumber);
        seatingArrangement.setLineReaderText(lineReaderText);
        seatingArrangement.setCustomerMap(customerMap);
        seatingArrangement.setSeatingMatrix(seatingMatrix);
        seatingArrangement.setTotalRows(totalRows);
        return seatingArrangement;
    }

}
