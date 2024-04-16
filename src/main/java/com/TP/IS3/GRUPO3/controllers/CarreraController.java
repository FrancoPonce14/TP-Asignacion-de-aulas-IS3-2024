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

import com.TP.IS3.GRUPO3.domain.Carrera;
import com.TP.IS3.GRUPO3.services.ICarreraService;
import com.TP.IS3.GRUPO3.services.IDepartamentoService;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private ICarreraService carreraService;

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/index")
    public ModelAndView index_auditor() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_INDEX_CARRERA);
        mAV.addObject("lstCarreras", carreraService.getAll());
        return mAV;
    }

    @GetMapping("/admin/index")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_CARRERA);
        mAV.addObject("lstCarreras", carreraService.getAll());
        mAV.addObject("carrera", new Carrera());
        return mAV;
    }

    @GetMapping("/nuevo") // MENU AGREGAR
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CARRERA_NUEVO);
        mAV.addObject("lstCarreras", carreraService.getAll());
        mAV.addObject("carrera", new Carrera());
        return mAV;
    }

    @GetMapping("/nuevo/agregar") // GET CREAR
    public ModelAndView newCreate() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CARRERA_AGREGAR);
        mAV.addObject("lstCarreras", carreraService.getAll());
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        mAV.addObject("carrera", new Carrera());
        return mAV;
    }

    @PostMapping("/crear")
    public RedirectView create_dep(@ModelAttribute("carrera") Carrera carrera, RedirectAttributes redirectAttributes) {
        carreraService.insertOrUpdate(carrera);
        redirectAttributes.addFlashAttribute("carrera_agreagdo", true);
        return new RedirectView(ViewRouteHelper.CARRERA_REDIRECT);
    }

    @GetMapping("/index/editar") // MUESTRA LA INDEX NORMAL CON LOS OBJETOS EDITABLES
    public ModelAndView editar(@ModelAttribute("carrera") Carrera carrera) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CARRERA_EDITAR);
        mAV.addObject("lstCarreras", carreraService.getAll());
        mAV.addObject("carrera", new Carrera());
        return mAV;
    }

    @GetMapping("/editar/{id}") // GET DE EDITAR
    public ModelAndView editar_e(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CARRERA_EDIT);
        mAV.addObject("carrera", carreraService.findById(id));
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        return mAV;
    }

    @PostMapping("/edit") // POST DE EDITAR
    public RedirectView edit_suss(@ModelAttribute("carrera") Carrera carrera, RedirectAttributes redirectAttributes) {
        carreraService.insertOrUpdate(carrera);
        redirectAttributes.addFlashAttribute("carrera_editado", true);
        return new RedirectView(ViewRouteHelper.CARRERA_REDIRECT);
    }

    @GetMapping("/eliminar")
    public ModelAndView eliminar_e(@ModelAttribute("carrera") Carrera carrera) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.CARRERA_ELIMINAR);
        mAV.addObject("lstCarreras", carreraService.getAll());
        mAV.addObject("carrera", new Carrera());
        return mAV;
    }

    @GetMapping("/eliminar/{id}") // ELIMINA CON GET, NO ME FUNCIONA CON POST
    public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        carreraService.remove(id);
        redirectAttributes.addFlashAttribute("carrera_borrado", true);
        return new RedirectView(ViewRouteHelper.CARRERA_REDIRECT);
    }

}
