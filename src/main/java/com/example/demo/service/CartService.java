package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepo;

@Service
public class CartService {
   @Autowired
   CartRepo cr;
   
   public Cart saveinfo(Cart b)
   {
   	return cr.save(b);
   }
   public List<Cart> savedetails(List<Cart> s)
   {
  	 return (List<Cart>)cr.saveAll(s);
   }
   
   
   public List<Cart> showinfo()
   {
   	return cr.findAll();
   }
   public Optional<Cart> showbyid(int id)
   {
   	return cr.findById(id);
   }
   
   
   public Cart changeinfo(Cart ss)
   {
   	return cr.saveAndFlush(ss);
   }
   public String updateinfobyid(int id, Cart s)
   {
   	cr.saveAndFlush(s);
   	if(cr.existsById(id))
   	{
   		return "updated";
   	}
		return "enter valid id";
   }
   
   
   public void deleteinfo(Cart ss)
   {
   	 cr.delete(ss);
   }
   public void deleteid(int id)
   {
   	cr.deleteById(id);
   }
   
   //sorting and paging
   public List<Cart> getbypage(int pgno,int pgsize,String s)
   {
	   Page <Cart> c = cr.findAll(PageRequest.of(pgno, pgsize, (Sort.by(Sort.Direction.ASC))));
	   return c.getContent();
   }
   public Cart updateCartItem(int id, int quantity) {
       // Fetch the cart item by id from the database, update the quantity, and save it.
       Cart cartItem = cr.findById(id).orElse(null);
       if (cartItem != null) {
           cartItem.setQuantity(quantity);
           return cr.save(cartItem);
       }
       return null; // Handle error if item not found.
   }

   public void deleteCartItem(int id) {
       // Delete the cart item by id.
       cr.deleteById(id);
   }
}
