package Spring_Security.intern.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomeAuthenticationManager implements AuthenticationManager {

	private final AuthenticationProvider provider;
	
	public CustomeAuthenticationManager(AuthenticationProvider provider) {
		super();
		this.provider = provider;
	}

	@Override
	public Authentication authenticate(Authentication authentication){
		if(provider.supports(authentication.getClass())) {
			return provider.authenticate(authentication);
		}
		
		throw new BadCredentialsException("this is bad credintials");
	}

}
