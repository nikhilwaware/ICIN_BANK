package com.icin.BankBackend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.icin.BankBackend.model.GrantAccess;
import com.icin.BankBackend.model.User;
import com.icin.BankBackend.model.RequestChequeBook;
import com.icin.BankBackend.model.UserTransactions;
import com.icin.BankBackend.service.GrantAccessService;
import com.icin.BankBackend.service.RequestChequeBookService;
import com.icin.BankBackend.service.UserService;
import com.icin.BankBackend.service.UserTransactionsService;

@Controller
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private UserTransactionsService userTransactionsService;
	@Autowired
	private GrantAccessService grantAccessService;
	@Autowired
	private RequestChequeBookService rcbService;

	@PostMapping("/add-user")
	public String userRegister(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("dob") String dob, @RequestParam("phone-number") String phoneNumber,
			@RequestParam("account-number") String accountNumber, @RequestParam("password") String password,
			ModelMap map) {

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setDob(dob);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setAccountNumber(accountNumber);

		service.saveUser(user);
		map.addAttribute("message", "User Registered");

		return "home";
	}

	@PostMapping("/UserPage")
	public String userPage(@RequestParam("account-number") String accountNumber,
			@RequestParam("password") String password, ModelMap map) {
		User user = service.getUser(accountNumber, password);
		if (user != null) {
			map.addAttribute("user", user);
			map.addAttribute("userName", user.getName());
			return "UserDashboard";
		} else
			map.addAttribute("message", "Invalid Details");
		return "UserLogin";
	}

	@GetMapping("/UserProfile/{accountNumber}")
	public String userProfile(@PathVariable String accountNumber, Model m) {
		m.addAttribute("profile", service.getUserByAccountNumber(accountNumber));
		return "Profile";
	}

	@GetMapping("/UserBalance/{accountNumber}")
	public String userBalance(@PathVariable String accountNumber, ModelMap map) {
		User user = service.getUserByAccountNumber(accountNumber);
		map.addAttribute("balance", user.getBalance());
		return "UserBalance";
	}


	@PostMapping("/Deposit")
	public String DepositFunds(@RequestParam("account-number")String accountNumber, @RequestParam("amount") Long amount, ModelMap map) {
		User user = service.getUserByAccountNumber(accountNumber);
		if (service.getUserByAccountNumber(accountNumber) != null) {

			Long updatedAmount = user.getBalance() + amount;
			user.setBalance(updatedAmount);
			service.updateUserBalance(user);
			map.addAttribute("message", "Amount Deposited Successfully");
			userTransactionsService.saveUserTransactions(
					new UserTransactions(user.getAccountNumber(), "deposit", amount, user.getBalance()));
			grantAccessService.saveGrantAccess(
					new GrantAccess(user.getAccountNumber(), "deposit", amount, user.getBalance() - amount));
		} else {
			map.addAttribute("message", "Unable to Deposit");
		}
		return "DepositMoney";
	}

	
	@PostMapping("/Withdraw")
	public String WithdrawFunds(@RequestParam("account-number")String accountNumber, @RequestParam("amount") Long amount, ModelMap map) {
		User user = service.getUserByAccountNumber(accountNumber);
		if (service.getUserByAccountNumber(accountNumber) != null) {

			Long updatedAmount = user.getBalance() - amount;
			user.setBalance(updatedAmount);
			service.updateUserBalance(user);
			map.addAttribute("message", "Amount Deposited Successfully");
			userTransactionsService.saveUserTransactions(
					new UserTransactions(user.getAccountNumber(), "deposit", amount, user.getBalance()));
			grantAccessService.saveGrantAccess(
					new GrantAccess(user.getAccountNumber(), "deposit", amount, user.getBalance() - amount));
		} else {
			map.addAttribute("message", "Unable to Deposit");
		}
		return "WithdrawMoney";
	}

	@PostMapping("/transferFunds")
	public String TransferFunds(@RequestParam("account-number1")String accountNumber1, 
			@RequestParam("account-number2")String accountNumber2,
			@RequestParam("amount") Long amount, ModelMap map) {
		User user1 = service.getUserByAccountNumber(accountNumber1);
		User user2 = service.getUserByAccountNumber(accountNumber2);
		if(service.getUserByAccountNumber(accountNumber2)!= null) {
			Long updatedAmount1 = user1.getBalance() - amount;
			Long updatedAmount2 = user2.getBalance() + amount;
			
			user1.setBalance(updatedAmount1);
			service.updateUserBalance(user1);
			
			user2.setBalance(updatedAmount2);
			service.updateUserBalance(user2);
			map.addAttribute("message", "Amount Transfered Successfully");
			
			userTransactionsService.saveUserTransactions(new UserTransactions(user1.getAccountNumber(),"transfer",amount,user1.getBalance()));
			userTransactionsService.saveUserTransactions(new UserTransactions(user2.getAccountNumber(),"credit",amount,user2.getBalance()));
			
			grantAccessService.saveGrantAccess(new GrantAccess(user1.getAccountNumber(),"transfer",amount,user1.getBalance()- amount));
			grantAccessService.saveGrantAccess(new GrantAccess(user2.getAccountNumber(),"credit",amount,user2.getBalance()+ amount));
		}
		return "TransferFunds";
	}
	
	@GetMapping("/RequestChequeBook")
	public String RequestChequeBook() {
//		m.addAttribute("profile", service.getUserByAccountNumber(accountNumber));
		return "RequestChequeBook";
	}
	
	@PostMapping("/RequestChequeBook")
	public String RequestChequeBook(@RequestParam("accountNumber")String accountNumber,
			@RequestParam("leafSize")String leafSize,ModelMap map) {
		User user = service.getUserByAccountNumber(accountNumber);
		if(user !=null) {			
			RequestChequeBook rcb = new RequestChequeBook();
			rcb.setAccountNumber(accountNumber);
			rcb.setLeafSize(leafSize);
			rcb.setStatus("Requested");
			
			map.addAttribute("message","Cheque Book Request Submitted and will be delivered in 15 days");
			rcbService.saveChequeBook(rcb);
		}
		return "RequestChequeBook";
	}
	
	@PostMapping("/userPassword")
	public String UpdatePassword(@RequestParam("accountNumber")String accountNumber,
			@RequestParam("password")String password,HttpServletRequest request) {
		User user = service.getUserByAccountNumber(accountNumber);
		
		if(user != null) {
			user.setPassword(password);
			
			service.updateUserBalance(user);
			
			return "UserLogin";
		}else {
			request.setAttribute("errmsg", "Failed to update password");
			return "UserUpdatePassword";
		}
	}
	
	@GetMapping("/UserTransactions/{accountNumber}")
	public String userTransactions(@PathVariable String accountNumber, ModelMap map) {
		map.addAttribute("userTransactions", userTransactionsService.getUserTransactions(accountNumber));
		
		return "UserTransactions";
	}
}
