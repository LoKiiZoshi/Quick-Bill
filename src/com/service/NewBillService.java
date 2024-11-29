package com.service;

import java.util.List;

import com.model.Bill;

public interface NewBillService {
	List<Bill> getAllBill();
	void addBill(Bill bi);
	void deleteBill(String id);
	void deleteBill(int id);
	
}
