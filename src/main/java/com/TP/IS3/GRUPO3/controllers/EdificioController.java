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

import com.TP.IS3.GRUPO3.domain.Edificio;
import com.TP.IS3.GRUPO3.services.IEdificioService;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;

@Controller
@RequestMapping("/edificio")
public class EdificioController {

    @Autowired
    private IEdificioService edificioService;   

    @GetMapping("/index")
    public ModelAndView index_audi() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_INDEX_EDIFICIO);
        mAV.addObject("lstEdificios", edificioService.getAll());
        return mAV;
    }

    @GetMapping("/admin/index") // MUESTRO LA VISTA PERO SOLO LA PUEDE VER EL ADMIN YA QUE ESTO ES PARTE DEL
                                // DASHBOARD - EL AUDITOR TIENE OTRA VISTA DIFERENTE
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_EDIFICIO);
        mAV.addObject("lstEdificios", edificioService.getAll());
        mAV.addObject("edificio", new Edificio());
        return mAV;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_EDITAR);
        mAV.addObject("edificio", edificioService.findById(id));
        return mAV;
    }

    @GetMapping("/nuevo") // MENU AGREGAR
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_NUEVO);
        mAV.addObject("lstEdificios", edificioService.getAll());
        mAV.addObject("edificio", new Edificio());
        return mAV;
    }

    @GetMapping("/nuevo/agregar") // GET CREAR
    public ModelAndView newCreate() { // REVISAR LO DE LOS EDIFICIOS
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_AGREGAR);
        mAV.addObject("edificio", new Edificio());
        return mAV;
    }

    @PostMapping("/crear")
    public RedirectView create_e(@ModelAttribute("edificio") Edificio edificio, RedirectAttributes redirectAttributes) {
        edificioService.insertOrUpdate(edificio);
        redirectAttributes.addFlashAttribute("edificio_agreagdo", true);
        return new RedirectView(ViewRouteHelper.EDIFICIO_REDIRECT);
    }

    @GetMapping("/index/editar") // MUESTRA LA INDEX NORMAL CON LOS OBJETOS EDITABLES
    public ModelAndView editar(@ModelAttribute("edificio") Edificio edificio) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_EDITAR);
        mAV.addObject("lstEdificios", edificioService.getAll());
        mAV.addObject("edificio", new Edificio());
        return mAV;
    }

    @GetMapping("/editar/{id}") // GET DE EDITAR
    public ModelAndView editar_e(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_EDIT);
        mAV.addObject("edificio", edificioService.findById(id));
        return mAV;
    }

    @PostMapping("/edit") // POST DE EDITAR
    public RedirectView edit_suss(@ModelAttribute("edificio") Edificio edificio,
            RedirectAttributes redirectAttributes) {
        edificioService.insertOrUpdate(edificio);
        redirectAttributes.addFlashAttribute("edificio_editado", true);
        return new RedirectView(ViewRouteHelper.EDIFICIO_REDIRECT);
    }

    @GetMapping("/eliminar")
    public ModelAndView eliminar_e(@ModelAttribute("edificio") Edificio edificioModel) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_ELIMINAR);
        mAV.addObject("lstEdificios", edificioService.getAll());
        mAV.addObject("edificio", new Edificio());
        return mAV;
    }

    @GetMapping("/eliminar/{id}") // ELIMINA CON GET, NO ME FUNCIONA CON POST
    public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        edificioService.remove(id);
        redirectAttributes.addFlashAttribute("edificio_borrado", true);
        return new RedirectView(ViewRouteHelper.EDIFICIO_REDIRECT);
    }

    @GetMapping("/con/aulas/{id}")
    public ModelAndView verEdifciosConAulas(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDIFICIO_CON_AULAS);
        mAV.addObject("ediAulas", edificioService.traerEdificioConAulas(id));
        // mAV.addObject("lstTradicionales", aulaService.getAllTradicionalID(id));
        // mAV.addObject("lstLaboratorios", aulaService.getAllLaboratorioID(id));
        return mAV;
    }

}