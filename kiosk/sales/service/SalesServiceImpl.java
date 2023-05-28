package com.kobuks.kiosk.sales.service;

import java.util.List;

import com.kobuks.kiosk.sales.dao.SalesDao;
import com.kobuks.kiosk.sales.domain.Sales;

public class SalesServiceImpl implements SalesService {
	
	private SalesDao salesDao;

	@Override
	public List<Sales> findSalesAll() {
		return salesDao.findSalesAll();
	}

}
