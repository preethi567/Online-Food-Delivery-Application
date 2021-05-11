package com.example.repository;

import com.example.entities.Login;

public interface ILoginRepository {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
}
