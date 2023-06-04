package com.kobuks.kiosk.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kobuks.kiosk.sales.dao.SalesDao;
import com.kobuks.kiosk.sales.domain.Sales;
import com.kobuks.kiosk.sales.service.SalesService;

@Controller
@RequestMapping("/admin")
public class SalesController {
	
	private final SalesService salesService;
	
	@Autowired
	public SalesController(SalesService salesService) {
		this.salesService = salesService;
	};
	
	@RequestMapping("sales_date")
	public String findSalesAll(Model model) {
		List<Sales> list = salesService.findSalesAll();
		model.addAttribute("salesDate", list);
		return "admin/sales_date";
		
	}

}
