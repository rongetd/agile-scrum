package com.capgemini.repo;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.model.Account;

public class AccountRepoImpl implements AccountRepo {

	List<Account> accountList = new ArrayList<Account>();
	@Override
	public boolean save(Account account) {
		if (account == null)
			return false;
		if(accountList.contains(account)){
			return false;
		}
		accountList.add(account);
		return true;
	}

	@Override
	public Account searchAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
