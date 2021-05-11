package com.example.service;

import java.time.LocalDate;
import java.util.List;

import com.example.entities.Bill;
import com.example.entities.OrderDetails;



public interface IBillService {

	public Bill addBill(OrderDetails order);
	public String removeBill(Bill bill);
	public Bill viewBillById(int id);
	public List<Bill> viewBillsBetweenDates(LocalDate startDate,LocalDate endDate);
	public List<Bill>  viewBillsByCustomerId(int custId);
	public String calculateTotalCost(Bill bill);
} 

