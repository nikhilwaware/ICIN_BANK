package com.icin.BankBackend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icin.BankBackend.model.Admin;
import com.icin.BankBackend.model.RequestChequeBook;
import com.icin.BankBackend.service.AdminService;
import com.icin.BankBackend.service.GrantAccessService;
import com.icin.BankBackend.service.RequestChequeBookService;
import com.icin.BankBackend.service.UserService;
import com.icin.BankBackend.service.UserTransactionsService;

@Controller
public class AdminController {

	@Autowired
	private GrantAccessService grantAccessService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService service; 
	
	@Autowired
	private UserTransactionsService service2;
	@Autowired
	private RequestChequeBookService rBookService;
	
	
	@PostMapping("/adminLogin")
	public String adminLogin() {
        return "AdminHome";
    }
	
	@PostMapping("/save-admin")
	public String saveAdmin(@RequestParam("name")String name,@RequestParam("phoneNo")String phoneNo,
			@RequestParam("email")String email, @RequestParam("password")String password,ModelMap map) {
		Admin admin = new Admin();
		admin.setName(name);
		admin.setPhoneNo(phoneNo);
		admin.setEmail(email);
		admin.setPassword(password);
		
		adminService.saveAdmin(admin);
		
		return "redirect:/";
	}
	
	@PostMapping("/Login")
	public String AdminLogin(Model m, HttpServletRequest request,
			@RequestParam("email")String email, @RequestParam("password")String password) {
		Admin admin = adminService.adminLogin(email, password);
		if(admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userEmailId", email);
			session.setAttribute("name", admin.getName());
			
			return "redirect:/AdminDashboard";
		} else {
			m.addAttribute("errmsg","Invalid Credentials");
			
			return "AdminLogin";
		}
	}
	
	@GetMapping("/UserList")
	public String userList(Model map) {
		map.addAttribute("users",service.getAllUser());
		return "UserList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id, ModelMap map) {
		service.deleteUser(id);
		return "UserList";
	}
	
	
	@GetMapping("/GrantAccess")
	public String grantAccess(ModelMap map) {
		map.addAttribute("grantAccess", grantAccessService.getGrantAccess());
        return "GrantAccess";
	}
	
	@RequestMapping(value="request",method=RequestMethod.GET)
    public String acceptRequest(@RequestParam("id")Integer id, ModelMap map) {
		grantAccessService.deleteGrantAccess(id);
		map.addAttribute("grantAccess", grantAccessService.getGrantAccess());
        return "GrantAccess";
    }
	
	@GetMapping("/chequeList")
	public String chequeBookList(Model map) {
		map.addAttribute("rcb",rBookService.getAllChequeBook());
		return "ChequeRequests";
	}
	
	@GetMapping("/cheque/{id}")
	public ModelAndView getChequeRequest(@PathVariable Integer id,Model m) {
		
		ModelAndView mv = new ModelAndView("UpdateChequeRequest");
		
		RequestChequeBook rcb = rBookService.getById(id);
		m.addAttribute("cheque",rcb);
		
		return mv;
	}
	
		
	@GetMapping("/deleteCheque/{id}")
	public String deleteChequeRequest(@PathVariable Integer id) {
		rBookService.deleteChequeBookRequest(id);
		return "AdminDashboard";
	}
	
	@PostMapping("/adminUpdatePassword")
	public String UpdatePassowrd(@RequestParam("email")String email,
			@RequestParam("password")String password,HttpServletRequest request) {
		Admin admin = adminService.getAdmin(email);
		
		if(admin != null) {
			admin.setPassword(password);
			
			adminService.updatePassword(admin);
			
			return "AdminLogin";
		} else {
			request.setAttribute("errmsg", "Failed to update password");
			return "AdminUpdatePassword";
		}
	}
	
	@GetMapping("/allTransactions")
	public String AllTransactions(ModelMap map) {
		map.addAttribute("transactions",service2.getUserTransactions());
		return "AllTransactionsList";
	}
	
	@GetMapping("/deleteTransaction/{id}")
	public String deleteTransactions(@PathVariable Integer id) {
		service2.deleteUserTransactions(id);
		return "AllTransactionsList";
	}
	
}
