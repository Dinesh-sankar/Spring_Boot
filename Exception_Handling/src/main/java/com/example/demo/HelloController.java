package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/api/accounts/{accountId}")
	public ResponseEntity<Account> getAccounts(@PathVariable("accountId") String accountId) {
		Account account = new Account();
		account.setAccountId(accountId);
		account.setName("Dinesh");
		
		if(accountId.equals("1")) {
			throw new IllegalArgumentException();
		}
		
		if(accountId.equals("2")) {
			throw new IllegalStateException();
		}
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@ExceptionHandler(value = {IllegalStateException.class})
	protected ResponseEntity<Object> handleException(IllegalStateException e) {
		return new ResponseEntity<Object>("Illegal State Exception in Controller", HttpStatus.BAD_REQUEST);
	}
	
}
