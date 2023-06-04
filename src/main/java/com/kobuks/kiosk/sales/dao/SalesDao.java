package com.kobuks.kiosk.sales.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kobuks.kiosk.menu.domain.Menu;
import com.kobuks.kiosk.order.domain.Order;
import com.kobuks.kiosk.sales.domain.Sales;

@Component
public class SalesDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SalesDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 일별매출
	
	public List<Sales> findSalesAll() {
		String sql = "SELECT s.sid, s.payment, s.salesCount, s.regDate, m.menuName "
				+ "FROM Sales s JOIN `Order` o ON s.orderId = o.oid "
				+ "JOIN Menu m ON o.menuId = m.mid";
		
		return jdbcTemplate.query(sql, new RowMapper<Sales>() {

			@Override
			public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {

				Sales sales = new Sales();
				sales.setSalesId(rs.getInt("sid"));
				sales.setPayment(rs.getDouble("payment"));
				sales.setSalesCount(rs.getInt("salesCount"));
				sales.setRegDate(rs.getString("regDate"));
				
				Order order = new Order();
				Menu menu = new Menu();
				menu.setMenuName(rs.getString("menuName"));
				
				order.setMenu(menu);
				sales.setOrder(order);
				
				return sales;
			}
			
		});
	}

	
//	public List<Sales> findSalesByDate() {
//		
//	}
//	
//	public List<Sales> findSalesByMonth() {
//		
//	}
	
}
