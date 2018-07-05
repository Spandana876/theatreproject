package com.barclays;

import com.barclays.pojo.SeatingArrangement;
import com.barclays.sales.SalesRequests;
import com.barclays.seating.AssignSeating;
import com.barclays.seating.CustomersOrder;
import com.barclays.seating.PrintSeating;

import java.io.IOException;

public class TheaterSeating {

	public static void main(String[] args) throws IOException {

		SalesRequests saleRequests = new SalesRequests();
		SeatingArrangement seatingArrangement = saleRequests.extractInfoFromFile("theater_layout.txt");

		CustomersOrder customersOrder = new CustomersOrder();
		customersOrder.extractSeatingAndCustomerOrder(seatingArrangement);

		new AssignSeating().processSeating(seatingArrangement, customersOrder.getHighestSeatSection(),
				customersOrder.getTotalTheaterSeats());

		new PrintSeating().printSeatingAssignments(seatingArrangement.getCustomerMap());

	}
}
