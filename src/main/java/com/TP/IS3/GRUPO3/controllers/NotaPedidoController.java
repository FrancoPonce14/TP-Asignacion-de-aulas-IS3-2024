package com.TP.IS3.GRUPO3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.TP.IS3.GRUPO3.domain.Curso;
import com.TP.IS3.GRUPO3.domain.Final;
import com.TP.IS3.GRUPO3.domain.NotaPedido;
import com.TP.IS3.GRUPO3.services.IAulaService;
import com.TP.IS3.GRUPO3.services.IMateriaService;
import com.TP.IS3.GRUPO3.services.INotaPedidoService;
import com.TP.IS3.GRUPO3.services.IProfesorService;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;

@Controller
@RequestMapping("/notaPedido")
public class NotaPedidoController {

    @Autowired
    private INotaPedidoService notaPedidoService;

    @Autowired
    private IAulaService aulaService;

    @Autowired
    private IMateriaService materiaService;

    @Autowired
    private IProfesorService profesorService;

    // MOSTRAR NOTAS PEDIDOS - ADMIN
    @GetMapping("/index")
    public ModelAndView verNotasPedido_aud() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_INDEX_NOTAPEDIDO);
        mAV.addObject("lstPedidos", notaPedidoService.getAll());
        return mAV;
    }

    @GetMapping("/admin/index")
    public ModelAndView verNotasPedido() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX_NOTAPEDIDO);
        mAV.addObject("lstPedidos", notaPedidoService.getAll());
        return mAV;
    }

    @GetMapping("/auditor/ver/{id}")
    public String ver_auditr(Model model, @PathVariable("id") int id) {
        NotaPedido dd = notaPedidoService.findById(id);
        String ruta = "";
        if (dd instanceof Curso) {
            model.addAttribute("pedidoCurso", (Curso) dd);
            ruta = ViewRouteHelper.AUDITOR_NOTAPEDIDO_VER_CURSO;

        } else if (dd instanceof Final) {
            model.addAttribute("pedidoFinal", (Final) dd);
            ruta = ViewRouteHelper.AUDITOR_NOTAPEDIDO_VER_FINAL;
        }
        return ruta;
    }

    @GetMapping("/auditor/select")
    public ModelAndView select_a() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_NOTAPEDIDO_SELECT);
        return mAV;
    }

    @GetMapping("/auditor/nuevo/curso")
    public ModelAndView create_curso_a() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_NOTAPEDIDO_NUEVO_C);
        mAV.addObject("curso", new Curso());
        mAV.addObject("lstProfesores", profesorService.getAll());
        mAV.addObject("lstAulas", aulaService.getAll());
        mAV.addObject("lstMaterias", materiaService.getAll());
        return mAV;
    }

    @PostMapping("/auditor/curso/crear")
    public RedirectView create_sussces_curso_a(@ModelAttribute("curso") Curso curso,
            RedirectAttributes redirectAttributes) {
        notaPedidoService.insertOrUpdate(curso);
        redirectAttributes.addFlashAttribute("curso_bien", true);
        return new RedirectView(ViewRouteHelper.PERFIL_AUDITOR);
    }

    @GetMapping("/auditor/nuevo/final")
    public ModelAndView create_final_a() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_NOTAPEDIDO_NUEVO_F);
        mAV.addObject("final", new Final());
        mAV.addObject("lstProfesores", profesorService.getAll());
        mAV.addObject("lstAulas", aulaService.getAll());
        mAV.addObject("lstMaterias", materiaService.getAll());
        return mAV;
    }

    @PostMapping("/auditor/final/crear")
    public RedirectView create_sussces_final_a(@ModelAttribute("final") Final finall,
            RedirectAttributes redirectAttributes) {
        notaPedidoService.insertOrUpdate(finall);
        redirectAttributes.addFlashAttribute("final_bien", true);
        return new RedirectView(ViewRouteHelper.PERFIL_AUDITOR);
    }

    @GetMapping("/select")
    public ModelAndView select() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_SELECT);
        return mAV;
    }

    // LO IDEAL SERIA HACER ALGUN TIPO DE VALIDACION PERO, SE NOS FUE BAJANDO GENTE
    // Y NO NOS DA EL TIEMPO
    @GetMapping("/nuevo/curso")
    public ModelAndView create_curso() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_NUEVO_C);
        mAV.addObject("curso", new Curso());
        mAV.addObject("lstProfesores", profesorService.getAll());
        mAV.addObject("lstAulas", aulaService.getAll());
        mAV.addObject("lstMaterias", materiaService.getAll());
        return mAV;
    }

    @PostMapping("/curso/crear")
    public RedirectView create_sussces_curso(@ModelAttribute("curso") Curso curso,
            RedirectAttributes redirectAttributes) {
        notaPedidoService.insertOrUpdate(curso);
        redirectAttributes.addFlashAttribute("curso_bien", true);
        return new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT);
    }

    @GetMapping("/nuevo/final")
    public ModelAndView create_final() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_NUEVO_F);
        mAV.addObject("final", new Final());
        mAV.addObject("lstProfesores", profesorService.getAll());
        mAV.addObject("lstAulas", aulaService.getAll());
        mAV.addObject("lstMaterias", materiaService.getAll());
        return mAV;
    }

    @PostMapping("/final/crear")
    public RedirectView create_sussces_final(@ModelAttribute("final") Final finall,
            RedirectAttributes redirectAttributes) {
        notaPedidoService.insertOrUpdate(finall);
        redirectAttributes.addFlashAttribute("final_bien", true);
        return new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT);
    }

    @GetMapping("/ver/{id}")
    public String ver(Model model, @PathVariable("id") int id) {
        NotaPedido dd = notaPedidoService.findById(id);
        String ruta = "";
        if (dd instanceof Curso) {
            model.addAttribute("pedidoCurso", (Curso) dd);
            ruta = ViewRouteHelper.NOTAPEDIDO_VER_CURSO;

        } else if (dd instanceof Final) {
            model.addAttribute("pedidoFinal", (Final) dd);
            ruta = ViewRouteHelper.NOTAPEDIDO_VER_FINAL;
        }
        return ruta;
    }

    @GetMapping("/index/editar")
    public ModelAndView editar() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_EDITAR);
        mAV.addObject("lstPedidos", notaPedidoService.getAll());
        return mAV;
    }

    @GetMapping("/editar/curso/{id}")
    public ModelAndView editar_cu(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_EDITAR_C);
        mAV.addObject("lstProfesores", profesorService.getAll());
        mAV.addObject("lstAulas", aulaService.getAll());
        mAV.addObject("lstMaterias", materiaService.getAll());
        mAV.addObject("curso", notaPedidoService.findById(id));
        return mAV;
    }

    @GetMapping("/editar/final/{id}")
    public ModelAndView editar_fi(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_EDITAR_F);
        mAV.addObject("lstProfesores", profesorService.getAll());
        mAV.addObject("lstAulas", aulaService.getAll());
        mAV.addObject("lstMaterias", materiaService.getAll());
        mAV.addObject("curso", notaPedidoService.findById(id));
        return mAV;
    }

    @PostMapping("/curso/bien")
    public RedirectView cu_suss(@ModelAttribute("curso") Curso curso,
            RedirectAttributes redirectAttributes) {
        notaPedidoService.insertOrUpdate(curso);
        redirectAttributes.addFlashAttribute("curso_edit__bien", true);
        return new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT);
    }

    @PostMapping("/final/bien")
    public RedirectView fi_suss(@ModelAttribute("final") Final finall,
            RedirectAttributes redirectAttributes) {
        notaPedidoService.insertOrUpdate(finall);
        redirectAttributes.addFlashAttribute("final_edit_bien", true);
        return new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT);
    }

    @GetMapping("/eliminar")
    public ModelAndView eliminar_n() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.NOTAPEDIDO_ELIMINAR);
        mAV.addObject("lstPedidos", notaPedidoService.getAll());
        return mAV;
    }

    @GetMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        notaPedidoService.remove(id);
        redirectAttributes.addFlashAttribute("pedido_eliminado", true);
        return new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT);
    }

    @GetMapping("/estado/deshabilitar/{id}")
    public RedirectView deshabPerfil_admin(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        RedirectView rv = new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT, true);
        NotaPedido np = notaPedidoService.findById(id);
        np.setEstado(false);
        notaPedidoService.insertOrUpdate(np);
        return rv;
    }

    @GetMapping("/estado/habilitar/{id}")
    public RedirectView habPerfil_admin(@PathVariable("id") int id) {
        RedirectView rv = new RedirectView(ViewRouteHelper.NOTAPEDIDO_REDIRECT, true);
        NotaPedido np = notaPedidoService.findById(id);
        np.setEstado(true);
        notaPedidoService.insertOrUpdate(np);
        return rv;
    }

}
