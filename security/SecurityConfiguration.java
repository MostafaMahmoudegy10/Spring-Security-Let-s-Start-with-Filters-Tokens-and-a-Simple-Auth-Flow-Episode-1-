package Spring_Security.intern.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
	
	private final CustomeFilterForToken filter;
	
	public SecurityConfiguration(CustomeFilterForToken filter) {
		super();
		this.filter = filter;
	}


	@Bean
	public SecurityFilterChain chain(HttpSecurity http)throws Exception {
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
		
		return http.build();
	}
}

