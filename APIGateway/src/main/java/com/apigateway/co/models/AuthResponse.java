package com.apigateway.co.models;

import java.util.Collection;

public class AuthResponse {
	
	
private String userId;

private String accessToken;

private String refresToken;

private long expireAt;

private Collection<String> authorities;

public AuthResponse(String userId, String accessToken, String refresToken, long expireAt,
		Collection<String> authorities) {
	super();
	this.userId = userId;
	this.accessToken = accessToken;
	this.refresToken = refresToken;
	this.expireAt = expireAt;
	this.authorities = authorities;
}

public AuthResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getAccessToken() {
	return accessToken;
}

public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
}

public String getRefresToken() {
	return refresToken;
}

public void setRefresToken(String refresToken) {
	this.refresToken = refresToken;
}

public long getExpireAt() {
	return expireAt;
}

public void setExpireAt(long expireAt) {
	this.expireAt = expireAt;
}

public Collection<String> getauthorities() {
	return authorities;
}

public void setauthorities(Collection<String> authorities) {
	this.authorities = authorities;
}

}
