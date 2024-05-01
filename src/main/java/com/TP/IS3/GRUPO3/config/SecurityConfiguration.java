package com.TP.IS3.GRUPO3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.TP.IS3.GRUPO3.services.impl.UsuarioService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/css/**", "/img/**", "/js/**", "/vendor/**").permitAll()
		.antMatchers("/aula/**", "/edificio/**", "/departamento/**", "/carrera/**", "/materia/**").hasAnyAuthority("PERFIL_ESTUDIANTE", "PERFIL_ADMIN")
		.antMatchers("/notaPedido/index", "/notaPedido/crearPedido", "/notaPedido/auditor/**").hasAuthority("PERFIL_ESTUDIANTE")
		.antMatchers("/notaPedido/**").hasAnyAuthority("PERFIL_ADMIN")
		.antMatchers("/admin/**").hasAuthority("PERFIL_ADMIN")
		.antMatchers("/auditor/**").hasAuthority("PERFIL_ESTUDIANTE")
		.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess", true).permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
				
	}
}
