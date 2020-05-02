package com.movieapp.rest.jwt.resource;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private final String token;
	private final boolean isUserAdmin;

	public JwtTokenResponse(String token, boolean isUserAdmin) {
		this.token = token;
		this.isUserAdmin = isUserAdmin;
	}

	public String getToken() {
		return this.token;
	}

	public boolean getIsUserAdmin() {
		return isUserAdmin;
	}
}