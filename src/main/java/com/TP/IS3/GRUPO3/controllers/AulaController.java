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

import com.TP.IS3.GRUPO3.domain.Laboratorio;
import com.TP.IS3.GRUPO3.domain.Tradicional;
import com.TP.IS3.GRUPO3.services.IAulaService;
import com.TP.IS3.GRUPO3.services.IEdificioService;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;

@Controller
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private IAulaService aulaService;

    @Autowired
    private IEdificioService edificioService;

    @GetMapping("/index") // EL INDEX PARA LA VISTA DEL AUDITOR
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_INDEX_AULA);
        mAV.addObject("lstLaboratorios", aulaService.getAllLaboratorio());
        mAV.addObject("lstTradicionales", aulaService.getAllTradicional());
        return mAV;
    }

    @GetMapping("/admin/index")
    public ModelAndView index_admin() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_AULA);
        // List<Aula> lstAulas = aulaService.getAll();
        mAV.addObject("lstLaboratorios", aulaService.getAllLaboratorio());
        mAV.addObject("lstTradicionales", aulaService.getAllTradicional());
        /*
         * for(Aula a : lstAulas) {
         * if (a instanceof Laboratorio){
         * mAV.addObject("lstLaboratorios", a);
         * 
         * }else if(a instanceof Tradicional){
         * mAV.addObject("lstTradicionales", a);
         * }
         * }
         */
        return mAV;
    }

    @GetMapping("/select")
    public ModelAndView select() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_SELECT);
        return mAV;
    }

    // LO IDEAL SERIA HACER ALGUN TIPO DE VALIDACION PERO, SE NOS FUE BAJANDO GENTE
    // Y NO NOS DA EL TIEMPO
    @GetMapping("/nuevo/laboratorio")
    public ModelAndView create_laboratorio() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_NUEVO_L);
        mAV.addObject("laboratorio", new Laboratorio()); // l a b
        // mAV.addObject("lstAulas", aulaService.findAll());
        mAV.addObject("lstEdificios", edificioService.getAll()); // mando los edificios para que se pueda seleccionar
                                                                 // uno a la hora de crear un aula
        return mAV;
    }

    @PostMapping("/laboratorio/crear")
    public RedirectView create_sussces_laboratorio(@ModelAttribute("laboratorio") Laboratorio laboratorio,
            RedirectAttributes redirectAttributes) {
        aulaService.insertOrUpdate(laboratorio);
        redirectAttributes.addFlashAttribute("lab_bien", true); // esto lo dejo por si tengo tiempo para agregar
                                                                // mensajes en las vistas
        return new RedirectView(ViewRouteHelper.AULA_REDIRECT);
    }

    @GetMapping("/nuevo/tradicional")
    public ModelAndView create_tradicional() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_NUEVO_T);
        mAV.addObject("tradicional", new Tradicional()); // l a b
        // mAV.addObject("lstAulas", aulaService.findAll());
        mAV.addObject("lstEdificios", edificioService.getAll()); // mando los edificios para que se pueda seleccionar
                                                                 // uno a la hora de crear un aula
        return mAV;
    }

    @PostMapping("/tradicional/crear")
    public RedirectView create_sussces_tradicional(@ModelAttribute("tradicional") Tradicional tradicional,
            RedirectAttributes redirectAttributes) {
        aulaService.insertOrUpdate(tradicional);
        redirectAttributes.addFlashAttribute("tra_bien", true);
        return new RedirectView(ViewRouteHelper.AULA_REDIRECT);
    }

    @GetMapping("/index/editar")
    public ModelAndView editar() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_EDITAR);
        mAV.addObject("lstLaboratorios", aulaService.getAllLaboratorio());
        mAV.addObject("lstTradicionales", aulaService.getAllTradicional());
        return mAV;
    }

    @GetMapping("/editar/laboratorio/{id}")
    public ModelAndView editar_lab(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_EDITAR_L);
        mAV.addObject("lstLaboratorios", aulaService.getAllLaboratorio());
        mAV.addObject("lstEdificios", edificioService.getAll());
        mAV.addObject("laboratorio", aulaService.findById(id));
        return mAV;
    }

    @GetMapping("/editar/tradicional/{id}")
    public ModelAndView editar_tra(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_EDITAR_T);
        mAV.addObject("lstTradicionales", aulaService.getAllTradicional());
        mAV.addObject("lstEdificios", edificioService.getAll());
        mAV.addObject("tradicional", aulaService.findById(id));
        return mAV;
    }

    @PostMapping("/laboratorio/bien")
    public RedirectView lab_suss(@ModelAttribute("laboratorio") Laboratorio laboratorio,
            RedirectAttributes redirectAttributes) {
        aulaService.insertOrUpdate(laboratorio);
        redirectAttributes.addFlashAttribute("lab_edit_bien", true);
        return new RedirectView(ViewRouteHelper.AULA_REDIRECT);
    }

    @PostMapping("/tradicional/bien")
    public RedirectView tra_suss(@ModelAttribute("tradicional") Tradicional tradicional,
            RedirectAttributes redirectAttributes) {
        aulaService.insertOrUpdate(tradicional);
        redirectAttributes.addFlashAttribute("tra_edit_bien", true);
        return new RedirectView(ViewRouteHelper.AULA_REDIRECT);
    }

    @GetMapping("/eliminar")
    public ModelAndView eliminar_e() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AULA_ELIMINAR);
        mAV.addObject("lstLaboratorios", aulaService.getAllLaboratorio());
        mAV.addObject("lstTradicionales", aulaService.getAllTradicional());
        return mAV;
    }

    @GetMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        aulaService.remove(id);
        redirectAttributes.addFlashAttribute("aula_eliniada", true);
        return new RedirectView(ViewRouteHelper.AULA_REDIRECT);
    }

}