package com.bank.demo.service;

import java.util.List;

import com.bank.demo.dto.*;
import com.bank.demo.entities.Account;
public interface AccountService {
	Account createAccount(Account account);
	Account UpdateAccount(UpdateAccount req);
	public void deleteAccount(Long Accno);
	//retrive using ifsc
	public List<Account>retriveAccount(String ifsc);
	//retrive using accountno
	public Account AccountretriveAccountUsingAccountNo(Long accno);

}
