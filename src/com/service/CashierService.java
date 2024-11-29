package com.service;

import java.util.List;

import com.model.Cashier;

public interface CashierService {
	void addCashierDetails(Cashier cs);
	void updateCashier(Cashier cs);
	void deleteCashier(int id);
	List<Cashier> getAllCashier();
}
