package com.barclays.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SeatingArrangement {

	TreeMap<Integer, Customer> customerMap = new TreeMap<Integer, Customer>();
	int emptyRowNumber = 0;
	Integer totalRows = new Integer(0);
	int[][] seatingMatrix = new int[6][6];
	List<StringBuilder> lineReaderText = new ArrayList<>();

	public TreeMap<Integer, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(TreeMap<Integer, Customer> customerMap) {
		this.customerMap = customerMap;
	}

	public int getEmptyRowNumber() {
		return emptyRowNumber;
	}

	public void setEmptyRowNumber(int emptyRowNumber) {
		this.emptyRowNumber = emptyRowNumber;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public int[][] getSeatingMatrix() {
		return seatingMatrix;
	}

	public void setSeatingMatrix(int[][] seatingMatrix) {
		this.seatingMatrix = seatingMatrix;
	}

	public List<StringBuilder> getLineReaderText() {
		return lineReaderText;
	}

	public void setLineReaderText(List<StringBuilder> lineReaderText) {
		this.lineReaderText = lineReaderText;
	}
}
