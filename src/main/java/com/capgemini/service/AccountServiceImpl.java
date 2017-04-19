package com.capgemini.service;

import java.util.StringJoiner;

import com.capgemini.exceptions.AccountNumberAlreadyExists;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repo.AccountRepo;

public class AccountServiceImpl implements AccountService{

	AccountRepo accountRepo;
	
	 public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo=accountRepo;
	}
	
	@Override
	Account createAccount(int accountNumber,int amount)throws InsufficientInitialBalanceException, AccountNumberAlreadyExists
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException();
		}
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		if(accountRepo.save(account))
		{
			return account;
		}else
		{
			throw new AccountNumberAlreadyExists();
			
		}
		
	}

	@Override
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringJoiner fundTransfer(int fromAccount, int toAccount, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return null;
	}

}
