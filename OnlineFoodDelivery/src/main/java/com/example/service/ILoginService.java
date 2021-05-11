package com.example.service;

import com.example.entities.Login;

public interface ILoginService {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
}
