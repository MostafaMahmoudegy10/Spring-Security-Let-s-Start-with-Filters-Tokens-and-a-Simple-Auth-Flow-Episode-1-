package Spring_Security.intern.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomeAuthenticationProvider implements AuthenticationProvider {

	@Value("${secret}")
	private String token;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Token cred=(Token)authentication;
		boolean equals = cred.getToken().equals(token);
		if (equals) {
			cred.setAuthenticated(true);
			return new Token(null,true);
		}
		throw new BadCredentialsException("this token is bad credintials to send");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return Token.class.equals(authentication);
	}

}
