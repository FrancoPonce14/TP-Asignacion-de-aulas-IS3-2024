package com.TP.IS3.GRUPO3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.TP.IS3.GRUPO3.domain.Espacio;
import com.TP.IS3.GRUPO3.services.IAulaService;
import com.TP.IS3.GRUPO3.services.IEspacioService;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;




@Controller
@RequestMapping("/espacio")
public class EspacioController {
	
	@Autowired
	private IEspacioService espacioService;
	
	@Autowired
	private IAulaService aulaService;
	
	@GetMapping("/admin/index")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_ESPACIO);
		mAV.addObject("lstEspacios", espacioService.getAll());
		mAV.addObject("espacio", new Espacio());
		return mAV;
	}
	@GetMapping("/nuevo")  //MENU AGREGAR
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ESPACIO_NUEVO);
		mAV.addObject("lstEspacios", espacioService.getAll());
		mAV.addObject("edificio", new Espacio());
		return mAV;
	}
	@GetMapping("/nuevo/agregar") //GET CREAR
	public ModelAndView newCreate() { //REVISAR LO DE LOS EDIFICIOS
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ESPACIO_AGREGAR);
		mAV.addObject("lstAulas", aulaService.getAll());
		mAV.addObject("espacio", new Espacio());
		return mAV;
	}
	@PostMapping("/crear")
	public RedirectView create_es(@ModelAttribute("espacio") Espacio espacio, RedirectAttributes redirectAttributes) {
		try {
			espacioService.agregar(espacio.getFecha(), espacio.getTurno(), espacio.getAula(), espacio.isLibre());
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("espacio_ocupado", true);
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("edificio_agreagdo", true);
		return new RedirectView(ViewRouteHelper.ESPACIO_REDIRECT);
	}
	@GetMapping("/index/editar") // MUESTRA LA INDEX NORMAL CON LOS OBJETOS EDITABLES
	public ModelAndView editar(@ModelAttribute("espacio") Espacio espacio) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ESPACIO_EDITAR);
		mAV.addObject("lstEspacios", espacioService.getAll());
		mAV.addObject("espacio", new Espacio());
		return mAV;
	}
	@GetMapping("/editar/{id}") // GET DE EDITAR
	public ModelAndView editar_e(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ESPACIO_EDIT);
		mAV.addObject("espacio", espacioService.findById(id));
		mAV.addObject("lstAulas", aulaService.getAll());
		return mAV;
	} 
	@PostMapping("/edit") //POST DE EDITAR
	public RedirectView edit_suss(@ModelAttribute("espacio") Espacio espacio, RedirectAttributes redirectAttributes) {
		/*try {
			espacioService.agregar(espacio.getFecha(), espacio.getTurno(), espacio.getAula(), espacio.isLibre());
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("espacio_editado", true);
			e.printStackTrace();
		}*/
		espacioService.insertOrUpdate(espacio);
		redirectAttributes.addFlashAttribute("espacio_editado", true);
		return new RedirectView(ViewRouteHelper.ESPACIO_REDIRECT);
	}
	@GetMapping("/eliminar")
	public ModelAndView eliminar_e(@ModelAttribute("espacio") Espacio espacio){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ESPACIO_ELIMINAR);
		mAV.addObject("lstEspacios", espacioService.getAll());
		mAV.addObject("espacio", new Espacio());
		return mAV;
	}
	@GetMapping("/eliminar/{id}") //ELIMINA CON GET, NO ME FUNCIONA CON POST
	public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		espacioService.remove(id);
		redirectAttributes.addFlashAttribute("edificio_borrado", true);
		return new RedirectView(ViewRouteHelper.ESPACIO_REDIRECT);
	}
	
}
