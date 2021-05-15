package SpringSecurity.SpringSecurityA1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration {
	 @Autowired
		javax.sql.DataSource dataSource;
		protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication()
		    .dataSource(dataSource);
   }
		
		@SuppressWarnings("deprecation")
		@Bean
		public PasswordEncoder getPasswordEncoder(){
			
			return NoOpPasswordEncoder.getInstance();
		}
		
		protected void configure(HttpSecurity http) throws Exception
		{
			http.authorizeRequests()
			   .antMatchers("/admin").hasRole("ADMIN")
			   .antMatchers("/user").hasAnyRole("ADMIN","USER")
			   .antMatchers("/").permitAll()
			   .and().formLogin().and().rememberMe().key("uniqueAndSecret");
			
	     }

}
