package com.capgemini.test;


import org.junit.Before;
import org.junit.Test;

import com.capgemini.exceptions.AccountNumberAlreadyExists;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.model.Account;
import com.capgemini.repo.AccountRepo;
import com.capgemini.repo.AccountRepoImpl;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class AccountTest {

	
	AccountRepo accountRepo = new AccountRepoImpl();
	AccountService accountService;
	
	@Before
	public void setUp() throws Exception {
		
		accountService = new AccountServiceImpl(accountRepo);
	}

	/*
	 * create account
	 * 1. when the amount is less than 500 then system should throw exception
	 * 2.when the valid info is passed account should be created successfully
	 */

	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientInitialBalanceException, AccountNumberAlreadyExists
	{
		
		accountService.createAccount(101, 400);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientInitialBalanceException, AccountNumberAlreadyExists
	{
		Account account = new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		assertEquals(account, accountService.createAccount(101, 5000));
	}
	
	@Test
	public void whenaccountIsAlreadyExist() throws AccountNumberAlreadyExists, InsufficientInitialBalanceException
	{
		accountService.createAccount(101, 5000);
	}
}
