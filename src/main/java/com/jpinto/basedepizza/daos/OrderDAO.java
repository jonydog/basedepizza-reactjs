package com.jpinto.basedepizza.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpinto.basedepizza.model.Order;
import com.jpinto.basedepizza.model.User;

@Repository
public interface OrderDAO extends JpaRepository<Order,Long>{
	
	@Query("select o from Order o where o.id=id")
	public List<Order> getOrderByID( @Param("id") Long id);
	
	@Query("select o from Order o where o.orderOwner=:orderOwner")
	public List<Order> getOrderByUser( @Param("orderOwner") User orderOwner);
	
	@Query("select o from Order o")
	public List<Order> getAllOrders();
	
}
