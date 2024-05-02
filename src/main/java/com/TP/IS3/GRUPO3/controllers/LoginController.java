package com.TP.IS3.GRUPO3.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.TP.IS3.GRUPO3.util.ViewRouteHelper;


@Controller
@RequestMapping("/")
public class LoginController {
	
	@GetMapping("/")
	public ModelAndView index(@RequestParam(name="perfil",required=false) String perfil) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
		org.springframework.security.core.Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		perfil = (auth.getAuthorities().toString());
		perfil = perfil.replace("[", ""); 
		perfil = perfil.replace("]", ""); // para poder usar el perfil le saco las [ ] que tiene al inicio y final ya que es una coleccion 
		mAV.addObject("perfil", perfil);
		return mAV;
	}
	@GetMapping("/login")
	public ModelAndView login(@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOGIN);
		mAV.addObject("error", error);
		mAV.addObject("logout", logout);
		return mAV;
	}
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOGOUT);
		request.getSession().invalidate(); //Invalido la session para desconectar
		return mAV;
	}
	@GetMapping("/loginsuccess")
	public RedirectView loginCheck() {
		org.springframework.security.core.Authentication autenticar = SecurityContextHolder.getContext().getAuthentication();
		String perfil = (autenticar.getAuthorities().toString()); //traigo los perfiles y abajo los redirecciono a su pagina correspondiente
		String redirect="";
		perfil = perfil.replace("[", ""); 
		perfil = perfil.replace("]", ""); // lo mismo que en el index, le saco los corchetes porque sino funciona como una coleccion 
		if(perfil.equalsIgnoreCase("perfil_estudiante")) {
			redirect = ViewRouteHelper.PERFIL_ESTUDIANTE;
		}else if(perfil.equalsIgnoreCase("perfil_admin")){
			redirect = ViewRouteHelper.PERFIL_ADMIN;
		}
		return new RedirectView(redirect);
	}
	
	
}