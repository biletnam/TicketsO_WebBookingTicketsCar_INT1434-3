package com.ptithcm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ptithcm.entities.User;
import com.ptithcm.service.UserServiceImp;

@Controller
@RequestMapping("/dashboard/users")
public class UserManagementController {
	
	@Autowired
	UserServiceImp userServiceImp;
	
	@RequestMapping("/show")
	public String showListUsers(ModelMap modelMap){
		
		int quantityUser =userServiceImp.getQuantityUser();
		List<User> le = userServiceImp.findByPage(1, 10); 
		
		le.forEach(val->{
			System.out.println(val.toString());
		});
		
		modelMap.addAttribute("listUsers", le);
		modelMap.addAttribute("quantityUsers", quantityUser);
		modelMap.addAttribute("currentPage", 1);
		modelMap.addAttribute("quantityPage", calQuantityPage(quantityUser, 10));
		modelMap.addAttribute("numPerPage", 10);
		
		System.out.println("quantity-page: " + quantityUser + "| current-page: " + 1 + "| quantity-page: " + calQuantityPage(quantityUser, 10));
		
		return "dashboard/user-management/user-list";
	}
	
	@RequestMapping("/show/getUserByQuantity")
	public String showListUsersByQuantity(@RequestParam int numPerPage, ModelMap modelMap){
		
		int quantityUser =userServiceImp.getQuantityUser();
		List<User> le = userServiceImp.findByPage(1, numPerPage); 
		
		le.forEach(val->{
			System.out.println(val.toString());
		});
		
		modelMap.addAttribute("listUsers", le);
		modelMap.addAttribute("quantityUsers", quantityUser);
		modelMap.addAttribute("currentPage", 1);
		modelMap.addAttribute("quantityPage", calQuantityPage(quantityUser, 10));
		modelMap.addAttribute("numPerPage", numPerPage);
		
		System.out.println("quantity-page: " + quantityUser + "| current-page: " + 1 + "| quantity-page: " + calQuantityPage(quantityUser, 10));
		
		return "dashboard/user-management/user-list";
	}
	
	@RequestMapping("/edit")
	public String editUser(){
		return "dashboard/user-management/user-edit";
	}
	
	@RequestMapping("/add")
	public String addUser(){
		return "dashboard/user-management/user-add";
	}
	
	@RequestMapping("/management")
	public String init_m(ModelMap modelMap) {
		List<User> le = userServiceImp.findByPage(1, 5);
		int quantity = Integer.parseInt(le.get(le.size() - 1).getPassword());
		
		le.remove(le.get(le.size() - 1));
		
		modelMap.addAttribute("listUser", le);
		modelMap.addAttribute("current_page", 1);
		
		int showing = 5 > le.size() ? le.size() : 5;
		modelMap.addAttribute("num_per_page", showing);
		modelMap.addAttribute("quantity", quantity);
		return "dashboard/user/management";
	}
	
	@RequestMapping("/management/getuserbypage")
	public String getUserByPage(@RequestParam int page, @RequestParam int numPerPage, ModelMap modelMap) {
		
		List<User> le = userServiceImp.findByPage(page, numPerPage);
		
		le.forEach(val->{
			System.out.println(val.toString());
		});
		modelMap.addAttribute("listUser", le);
		modelMap.addAttribute("current_page", page);
		
		int showing = numPerPage > le.size() ? le.size() : numPerPage;
		modelMap.addAttribute("num_per_page", showing);
		modelMap.addAttribute("quantity", le.size());
		
		return "dashboard/users/management";
	}
	
	public int calQuantityPage(int totalRecords, int recordPerPage) {
		if(totalRecords % recordPerPage == 0) {
			return (totalRecords / recordPerPage);
		}else {
			return ((totalRecords / recordPerPage) + 1);
		}
	}
}
