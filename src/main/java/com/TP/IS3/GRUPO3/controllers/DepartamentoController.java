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

import com.TP.IS3.GRUPO3.domain.Departamento;
import com.TP.IS3.GRUPO3.services.IDepartamentoService;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping("/index")
    public ModelAndView index_auditor() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_INDEX_DEPARTAMENTO);
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        return mAV;
    }

    @GetMapping("/admin/index")
    public ModelAndView index() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_DEPARTAMENTO);
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        mAV.addObject("departamento", new Departamento());
        return mAV;
    }

    @GetMapping("/nuevo") // MENU AGREGAR
    public ModelAndView create() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_NUEVO);
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        mAV.addObject("departamento", new Departamento());
        return mAV;
    }

    @GetMapping("/nuevo/agregar") // GET CREAR
    public ModelAndView newCreate() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_AGREGAR);
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        mAV.addObject("departamento", new Departamento());
        return mAV;
    }

    @PostMapping("/crear")
    public RedirectView create_dep(@ModelAttribute("departamento") Departamento departamento,
            RedirectAttributes redirectAttributes) {
        departamentoService.insertOrUpdate(departamento);
        redirectAttributes.addFlashAttribute("departamento_agreagdo", true);
        return new RedirectView(ViewRouteHelper.DEPARTAMENTO_REDIRECT);
    }

    @GetMapping("/index/editar") // MUESTRA LA INDEX NORMAL CON LOS OBJETOS EDITABLES
    public ModelAndView editar(@ModelAttribute("departamento") Departamento departamento) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_EDITAR);
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        mAV.addObject("departamento", new Departamento());
        return mAV;
    }

    @GetMapping("/editar/{id}") // GET DE EDITAR
    public ModelAndView editar_e(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_EDIT);
        mAV.addObject("departamento", departamentoService.findById(id));
        mAV.addObject("departamentoService", departamentoService.getAll());
        return mAV;
    }

    @PostMapping("/edit") // POST DE EDITAR
    public RedirectView edit_suss(@ModelAttribute("departamento") Departamento departamento,
            RedirectAttributes redirectAttributes) {
        departamentoService.insertOrUpdate(departamento);
        redirectAttributes.addFlashAttribute("departamento_editado", true);

        return new RedirectView(ViewRouteHelper.DEPARTAMENTO_REDIRECT);
    }

    @GetMapping("/eliminar")
    public ModelAndView eliminar_e() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.DEPARTAMENTO_ELIMINAR);
        mAV.addObject("lstDepartamentos", departamentoService.getAll());
        mAV.addObject("departamento", new Departamento());
        return mAV;
    }

    @GetMapping("/eliminar/{id}") // ELIMINA CON GET, NO ME FUNCIONA CON POST
    public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        departamentoService.remove(id);
        redirectAttributes.addFlashAttribute("departamento_borrado", true);
        return new RedirectView(ViewRouteHelper.DEPARTAMENTO_REDIRECT);
    }

}