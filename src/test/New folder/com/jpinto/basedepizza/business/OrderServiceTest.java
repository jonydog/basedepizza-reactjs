package com.jpinto.basedepizza.business;


import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpinto.basedepizza.business.interfaces.OrderService;
import com.jpinto.basedepizza.configs.PizzaPersistenceTest;
import com.jpinto.basedepizza.configs.TestsConfiguration;
import com.jpinto.basedepizza.daos.OrderDAO;
import com.jpinto.basedepizza.model.Order;
import com.jpinto.basedepizza.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestsConfiguration.class)
public class OrderServiceTest extends PizzaPersistenceTest{

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDAO orderDao;

	@Test
	@Transactional
	public void testNewOrder(){
		User user = new User("Pedro", "pedro@email", "912345678", "passpedro");
		
		Order order = this.orderService.newOrder(user);
		
		Assert.assertTrue(this.orderDao.findOne(order.getId()).getOrderOwner().getId() == user.getId() );
			
	}
	
	
	//@Test
	//public void testAddPizzaToOrder(){
		
	//}


	//@Test
	//public void testApplyPromotion(){
		
	//	Errors errors = new BeanPropertyBindingResult(order, "order");
		
		//this.orderService.newOrder(User )
		
	//	this.orderService.applyPromotions(3L, 4L, errors);
	
//		Assert.assertTrue( this.orderDao.findOne( 3L ).getDiscountAmount() == 4.20 );
	
	
	//}

	//@Test
	//public Order testGetCurrentOrder(){
		
	//}
	


}
