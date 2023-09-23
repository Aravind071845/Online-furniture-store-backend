package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.service.OrdersService;

@RestController
public class OrdersController {
   @Autowired
   OrdersService oe;
   
   @PostMapping("adding3")
	public Orders add(@RequestBody Orders  ss)
	{
		return oe.saveinfo(ss);
	}
   @PostMapping("addingn3")
	public List<Orders > addn(@RequestBody List<Orders > ss)
	{
		return oe.savedetails(ss);
	}
   
   

   @GetMapping("showingdetails3")
	public List<Orders > show()
	{
		return oe.showinfo();
	}
   @GetMapping("showingid3/{id}")
   public Optional<Orders> showid(@PathVariable int id)
   {
  	 return oe.showbyid(id);
   }
   
   @PutMapping("update3")
  	public Orders  modify(@RequestBody Orders ss)
  	{
  		return oe.changeinfo(ss);
  	}
     @PutMapping("updatebyid3/{id}")
      public String modifybyid(@PathVariable int id,@RequestBody Orders b)
      {
      	return oe.updateinfobyid(id, b);
      }
     
     
     @DeleteMapping("delete3")
 	public String deleteInfo(@RequestBody Orders ss)
 	{
 	      oe.deleteinfo(ss);
 	      return "Deleted successfully";
 	}
     @DeleteMapping("deleteid3/{id}")
 	public void deletemyid(@PathVariable int id)
 	{
 		oe.deleteid(id);
 	}
}
