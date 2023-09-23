package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Registration;
import com.example.demo.service.RegistrationService;

@RestController
@CrossOrigin
public class RegistrationController {
    @Autowired
    RegistrationService o;
    
    @PostMapping("adding")
	public Registration add(@RequestBody Registration ss)
	{
		return o.saveinfo(ss);
	}
    @PostMapping("addingn")
	public List<Registration> addn(@RequestBody List<Registration> ss)
	{
		return o.savedetails(ss);
	}
    
    
    @GetMapping("showingdetails")
	public List<Registration> show()
	{
		return o.showinfo();
	}
    @GetMapping("showingid/{id}")
    public Optional<Registration> showid(@PathVariable int id)
    {
   	 return o.showbyid(id);
    }
    
    
    @PutMapping("update")
	public Registration modify(@RequestBody Registration ss)
	{
		return o.changeinfo(ss);
	}
    @PutMapping("updatebyid/{id}")
    public String modifybyid(@PathVariable int id,@RequestBody Registration b)
    {
    	return o.updateinfobyid(id, b);
    }
    
    
    @DeleteMapping("delete")
	public String deleteInfo(@RequestBody Registration ss)
	{
	      o.deleteinfo(ss);
	      return "Deleted successfully";
	}
    @DeleteMapping("deleteid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		o.deleteid(id);
	}
}
