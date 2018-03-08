package cl.abaadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@SpringBootApplication
@EnableResourceServer
public class Application extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
	@Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

		public WebSecurityConfiguration() {
			super(true);
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/login");
			web.ignoring().antMatchers("/index");
			web.ignoring().antMatchers("/resources/**");
			web.ignoring().antMatchers("/webjars/**");
			web.ignoring().antMatchers("/assets/**");
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			
			http.csrf().disable();
			http.antMatcher("/aba/**")
				.authorizeRequests()
		        .antMatchers("/login").permitAll()
		        .antMatchers("/logout").permitAll()
		        .antMatchers(HttpMethod.DELETE, "/oauth/revoketoken").permitAll()
		        .antMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll()
		        .anyRequest().authenticated();
			
		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
	}
	
	@Configuration
	@EnableAuthorizationServer
	public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	 
		@Autowired
		@Qualifier("userDetailsService")
		private UserDetailsService userDetailsService;

		@Autowired
		private AuthenticationManager authenticationManager;

		@Value("${abaadmin.oauth.tokenTimeout:3600}")
		private int expiration;

		
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Override
	    public void configure(AuthorizationServerSecurityConfigurer oauthServer) 
	      throws Exception {
	        oauthServer
	          .tokenKeyAccess("permitAll()")
	          .checkTokenAccess("isAuthenticated()");
	    }
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
			configurer.authenticationManager(authenticationManager);
			configurer.userDetailsService(userDetailsService);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			clients.inMemory().withClient("aba").secret("entelgy12").accessTokenValiditySeconds(expiration)
					.scopes("read", "write")
					.authorizedGrantTypes("password", "authorization_code", "refresh_token")
					.resourceIds("resource");
		}
	}
}
