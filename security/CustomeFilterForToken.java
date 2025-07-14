package Spring_Security.intern.security;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomeFilterForToken extends OncePerRequestFilter{

	private final AuthenticationManager manager;
	
	public CustomeFilterForToken(AuthenticationManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		
		String credintials = request.getHeader("token");
		
		if(credintials==null) {
			filterChain.doFilter(request, response);
		}
		
		Token token=new Token(credintials, false);
		
		Authentication authenticate = manager.authenticate(token);
		
		if(authenticate.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			filterChain.doFilter(request, response);
		}
		
		
	}

}
