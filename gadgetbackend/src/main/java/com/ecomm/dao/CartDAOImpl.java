package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Cart;
import com.ecomm.model.UserDetail;

@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO
{

	@Autowired
	SessionFactory sessionFactory;
	 
	public boolean addCart(Cart cart) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
			
		}
	}

	 
	public boolean deleteCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}	
		
	}

	 
	public boolean updateCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
			
	}


	
	public Cart getCart(int cardID) {
		
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class,cardID);
		session.close();
		return cart;
		
	}


	public List<Cart> listCart(String username)
	
	
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart> listCart=query.list();
		session.close();
		return  listCart;
	}

}


