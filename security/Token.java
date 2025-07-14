package Spring_Security.intern.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class Token implements Authentication {

	
	private final String token;
	private boolean isAuthenticated;
	
	
	public Token(String token, boolean isAuthenticated) {
		super();
		this.token = token;
		this.isAuthenticated = isAuthenticated;
	}

	
	public String getToken() {
		return token;
	}


	@Override
	public String getName() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return isAuthenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.isAuthenticated=isAuthenticated;
		
	}

}
