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

import com.example.demo.model.Payment;
import com.example.demo.service.PaymentService;

@RestController
public class PaymentController {
     @Autowired
     PaymentService ps;
     
     @PostMapping("adding4")
 	public Payment add(@RequestBody Payment  ss)
 	{
 		return ps.saveinfo(ss);
 	}
    @PostMapping("addingn4")
 	public List<Payment> addn(@RequestBody List<Payment > ss)
 	{
 		return ps.savedetails(ss);
 	}
    
    

    @GetMapping("showingdetails4")
 	public List<Payment> show()
 	{
 		return ps.showinfo();
 	}
    @GetMapping("showingid4/{id}")
    public Optional<Payment> showid(@PathVariable int id)
    {
   	 return ps.showbyid(id);
    }
    
    @PutMapping("update4")
   	public Payment modify(@RequestBody Payment ss)
   	{
   		return ps.changeinfo(ss);
   	}
      @PutMapping("updatebyid4/{id}")
       public String modifybyid(@PathVariable int id,@RequestBody Payment b)
       {
       	return ps.updateinfobyid(id, b);
       }
      
      
      @DeleteMapping("delete4")
  	public String deleteInfo(@RequestBody Payment ss)
  	{
  	      ps.deleteinfo(ss);
  	      return "Deleted successfully";
  	}
      @DeleteMapping("deleteid4/{id}")
  	public void deletemyid(@PathVariable int id)
  	{
  		ps.deleteid(id);
  	}
}
