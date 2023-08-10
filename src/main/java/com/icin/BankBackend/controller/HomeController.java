package com.icin.BankBackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/UserLogin")
	public String userLogin() {
		return "UserLogin";
	}

	@GetMapping("/UserDashboard")
	public String userDashboard() {
		return "UserDashboard";
	}
			
	@GetMapping("/UserRegistration")
	public String userRegistration() {
		return "registerUser";
	}
	
	@RequestMapping("/DepositMoney")
    public String depositMoney() {
        return "DepositMoney";
    }
	
	@RequestMapping("/WithdrawMoney")
    public String withdrawMoney() {
        return "WithdrawMoney";
    }

	@RequestMapping("/TransferFunds")
    public String transferMoney() {
        return "TransferFunds";
    }
	
	@GetMapping("/AdminRegistration")
	public String adminRegistration() {
		return "registerAdmin";
	}
	
	@GetMapping("/AdminLogin")
	public String adminLogin() {
		return "AdminLogin";
	}
	
	@GetMapping("/AdminDashboard")
	public String adminDashboard() {
		return "AdminDashboard";
	}
	
	@GetMapping("/AdminUpdatePassword")
	public String adminChangePassword() {
		return "UpdateAdminPassword";
	}
	
	@GetMapping("/UserUpdatePassword")
	public String userChangePassword() {
		return "UpdateUserPassword";
	}

}
