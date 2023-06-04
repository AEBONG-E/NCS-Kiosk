package com.kobuks.kiosk.order.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kobuks.kiosk.menu.domain.Menu;
import com.kobuks.kiosk.order.domain.Order;

@Component // 빈등록
public class OrderDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public OrderDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 결제하기 누르고 insert
	
	public void saveOrder(Order order) {
		String sql = "INSERT INTO `Order` (menuId) VALUES (?)";
		
		jdbcTemplate.update(sql, order.getOrderId(), order.getMenuId(),
				order.getRegDate());
	}
	
	
	
	// 전체주문내역조회
	// JOIN은 BeanPropertyRowMapper로 매핑할 수 없고, 직접 RowMapper를 구현해야 함
	public List<Order> findAllOrders() {
		String sql = "SELECT o.oid, o.regDate, m.mid AS menuId, m.menuName, m.price " +
				"FROM `Order` o JOIN Menu m ON o.menuId = m.mid";
		return jdbcTemplate.query(sql, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				// 주문수량은 cart에서 받아와야함
				
				Order order = new Order();
				order.setOrderId(rs.getInt("oid"));
				order.setRegDate(rs.getString("regDate"));
				order.setMenuId(rs.getLong("menuId"));
				
				Menu menu = new Menu();
				menu.setMenuName(rs.getString("menuName"));
				menu.setPrice(rs.getInt("price"));
				
				order.setMenu(menu);
				
				return order;
			}

		});
	}
	
	//람다식
//	public List<Order> findAllOrders() {
//		String sql = "SELECT o.oid, o.regDate, m.mid AS menuId, m.menuName, m.price " +
//				"FROM `Order` o JOIN Menu m ON o.menuId = m.mid";
//		return jdbcTemplate.query(sql, rs -> {
//			List<Order> orderList = new ArrayList<>();
//			while (rs.next()) {
//				Order order = new Order();
//				order.setOrderId(rs.getInt("oid"));
//				order.setRegDate(rs.getString("regDate"));
//				order.setMenuId(rs.getLong("menuId"));
//				
//				Menu menu = new Menu();
//				menu.setMenuId(rs.getInt("menuId"));
//				menu.setMenuName(rs.getString("menuName"));
//				menu.setPrice(rs.getInt("price"));
//				
//				order.setMenu(menu);
//				orderList.add(order);
//			}
//			return orderList;
//		});
//	}
	

	
	// 전체메뉴
	public List<Menu> findAllMenus() {
		String sql = "SELECT * FROM Menu";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Menu.class));
		
	}

}

//    public void addOrder(Menu menu) {
//    	
//    	//
//    	String sql = "INSERT INTO Order(menuId) VALUES (?)";
//    	
//    	jdbcTemplate.update(sql, menu.getMenuId());
//
//    }