package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepo;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo pr;
    
    public Payment saveinfo(Payment b)
    {
    	return pr.save(b);
    }
    public List<Payment> savedetails(List<Payment> s)
    {
   	 return (List<Payment>)pr.saveAll(s);
    }
    
    
    public List<Payment> showinfo()
    {
    	return pr.findAll();
    }
    public Optional<Payment> showbyid(int id)
    {
    	return pr.findById(id);
    }
    
    
    public Payment changeinfo(Payment ss)
    {
    	return pr.saveAndFlush(ss);
    }
    public String updateinfobyid(int id, Payment s)
    {
    	pr.saveAndFlush(s);
    	if(pr.existsById(id))
    	{
    		return "updated";
    	}
 		return "enter valid id";
    }
    
    
    public void deleteinfo(Payment ss)
    {
    	 pr.delete(ss);
    }
    public void deleteid(int id)
    {
    	pr.deleteById(id);
    }
}
