package com.example.EmployeeManagementWeb;

import org.springframework.boot.SpringApplication;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class EmployeeManagementWeb {
//
//	public static void main(String[] args) {
//		SpringApplication.run(EmployeeManagementWeb.class, args);
//	}
//}

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@SpringBootApplication
@EnableJpaRepositories
@ComponentScan

public class EmployeeManagementWeb {

  public static void main(String[] args) {
      SpringApplication.run(EmployeeManagementWeb.class, args);
  }

  @EnableWebSecurity
  public class WebSecurityConfig {

      @Bean
       SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
          return http
                  .authorizeRequests(authorizeRequests -> authorizeRequests
                          .requestMatchers("/admin/**").hasRole("ADMIN")
                          .anyRequest().permitAll())
                  .formLogin(formLogin -> formLogin
                          .loginPage("/admin-login")
                          .permitAll()
                  .defaultSuccessUrl("/admin/dashboard")
                  .failureUrl("/admin-login?error=true"))
                  .logout(logout -> logout
                          .permitAll())
                  .build();
      }

      // ... other beans (userDetailsService, passwordEncoder) remain the same
      @Bean
       UserDetailsService userDetailsService() {
          UserDetails user = User.withUsername("admin")
              .password(passwordEncoder().encode("adminpassword"))
              .roles("ADMIN")
              .build();

          return new InMemoryUserDetailsManager(user);
      }

      @Bean
      public PasswordEncoder passwordEncoder() {
          return PasswordEncoderFactories.createDelegatingPasswordEncoder();
      }
      

  }
}

