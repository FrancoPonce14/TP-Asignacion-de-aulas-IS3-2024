package com.TP.IS3.GRUPO3.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.TP.IS3.GRUPO3.domain.Perfil;
import com.TP.IS3.GRUPO3.domain.Estudiante;
import com.TP.IS3.GRUPO3.services.IPerfilService;
import com.TP.IS3.GRUPO3.services.IEstudianteService;
import com.TP.IS3.GRUPO3.util.PerfilModel;
import com.TP.IS3.GRUPO3.util.EstudianteModel;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IEstudianteService usuarioService;
    @Autowired
    private IPerfilService perfilService;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/index")
    public ModelAndView indexAdmin(@RequestParam(name = "nombreUsuario", required = false) String nombreUsuario) {
        ModelAndView mVA = new ModelAndView(ViewRouteHelper.INDEX_ADMIN);
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        nombreUsuario = auth.getName();
        mVA.addObject("nombreUsuario", nombreUsuario);
        return mVA;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(@RequestParam(name = "nombreUsuario", required = false) String nombreUsuario) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.DASHBOARD);
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        nombreUsuario = auth.getName();
        mAV.addObject("nombreUsuario", nombreUsuario);
        return mAV;
    }

    @GetMapping("/usuarios")
    public ModelAndView verUsuarios_Admin() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = auth.getName();
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VER_USUARIOS);
        mAV.addObject("lstUsuarios", usuarioService.findAll());
        mAV.addObject("usuario", new EstudianteModel());
        mAV.addObject("usuarioActual", usuarioService.findByNombreUsuario(nombreUsuario));
        return mAV;
    }

    @GetMapping("/usuario/{id}")
    public ModelAndView get_id(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDITAR_USUARIO);
        mAV.addObject("usuario", usuarioService.findById(id));
        mAV.addObject("lstPerfiles", perfilService.getPerfilesHabilitados());
        return mAV;
    }

    // MUESTRO EL FROM PARA CREAR USUARIO
    @GetMapping("/usuario/nuevo")
    public ModelAndView addUsuario_admin() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AGREGAR_USUARIO);
        mAV.addObject("usuario", new EstudianteModel());
        mAV.addObject("lstPerfiles", perfilService.getPerfilesHabilitados());
        return mAV;
    }

    // ABM USUARIOS
    @PostMapping("/usuario/crear")
    public RedirectView createUsuario_admin(@ModelAttribute("usuario") EstudianteModel usuarioModel,
            RedirectAttributes redirectAttributes) {

        Perfil perfil = modelMapper.map(perfilService.findById(usuarioModel.getIdPerfil()), Perfil.class);
        usuarioModel.setPerfil(perfil);
        boolean salioError = false;

        List<Estudiante> lstUsuarios = usuarioService.findAll();
        Estudiante usuario = modelMapper.map(usuarioModel, Estudiante.class);
        for (Estudiante u : lstUsuarios) {
            if (u.getDocumento() == usuario.getDocumento() && u.getIdUsuario() != usuario.getIdUsuario()) {
                salioError = true;
            }
        }
        if (salioError) {
            redirectAttributes.addFlashAttribute("errorCrear", true);
        } else {
            usuarioService.insertOrUpdate(usuarioModel);
            redirectAttributes.addFlashAttribute("susscefulCrear", true);
        }
        return new RedirectView(ViewRouteHelper.ADMIN_USUARIOS);
    }

    @PostMapping("/usuario/editar")
    public RedirectView editarUsuario_admin(@ModelAttribute("usuario") EstudianteModel usuarioModel,
            RedirectAttributes redirectAttributes) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        EstudianteModel user = usuarioService.findByNombreUsuario(auth.getName());
        List<Estudiante> lstUsuarios = usuarioService.findAll();
        Estudiante usuario = modelMapper.map(usuarioModel, Estudiante.class);

        if (!user.equals(usuarioModel)) {
            Perfil perfil = modelMapper.map(perfilService.findById(usuarioModel.getIdPerfil()), Perfil.class);
            usuarioModel.setPerfil(perfil);

            for (Estudiante u : lstUsuarios) {
                if (u.getDocumento() == usuario.getDocumento() && u.getIdUsuario() != usuario.getIdUsuario()) {
                    redirectAttributes.addFlashAttribute("errorEditar", true);
                } else {
                    usuarioService.insertOrUpdate(usuarioModel);
                    redirectAttributes.addFlashAttribute("susscefulEditar", true);
                }
            }

        }

        return new RedirectView(ViewRouteHelper.ADMIN_USUARIOS);
    }

    @GetMapping("/usuario/eliminar/{id}")
    public RedirectView eliminarUsuario_admin(@PathVariable("id") int idUsuario,
            RedirectAttributes redirectAttributes) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        EstudianteModel usuario = usuarioService.findByNombreUsuario(auth.getName());
        if (!(usuario.getIdUsuario() == idUsuario)) {
            usuarioService.remove(idUsuario);
            redirectAttributes.addFlashAttribute("removed", true);
        }
        return new RedirectView(ViewRouteHelper.ADMIN_USUARIOS);
    }

    // ---------------------------------- PERFILES ABM
    @GetMapping("/perfiles")
    public ModelAndView perfilIndex() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.VER_PERFILES);
        mAV.addObject("lstPerfiles", perfilService.findAll());
        mAV.addObject("perfil", new PerfilModel());
        return mAV;
    }

    @GetMapping("/perfil/nuevo")
    public String addPerfil_admin(Model model) {
        model.addAttribute("perfil", new PerfilModel());
        return ViewRouteHelper.AGREGAR_PERFIL;
    }

    @PostMapping("/perfil/crear")
    public RedirectView createPerfil_admin(@ModelAttribute("perfil") PerfilModel perfil,
            RedirectAttributes redirectAttributes) {
        perfilService.insertOrUpdate(perfil);
        redirectAttributes.addFlashAttribute("susscefulCrearP");
        return new RedirectView(ViewRouteHelper.ADMIN_PERFILES);
    }

    @GetMapping("/perfil/editar/{id}")
    public ModelAndView editarPerfil_admin(@PathVariable("id") int id) {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.EDITAR_PERFIL);
        mAV.addObject("perfil", perfilService.findById(id));
        return mAV;
    }

    @PostMapping("/perfil/editar/{id}")
    public RedirectView updatePerfil_admin(@ModelAttribute("perfil") PerfilModel perfil,
            RedirectAttributes redirectAttributes) {
        perfilService.insertOrUpdate(perfil);
        redirectAttributes.addFlashAttribute("susscefulEditarP");
        return new RedirectView(ViewRouteHelper.ADMIN_PERFILES);
    }

    @GetMapping("/perfil/deshabilitar/{id}")
    public RedirectView deshabPerfil_admin(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        RedirectView rv = new RedirectView(ViewRouteHelper.ADMIN_PERFILES, true);
        PerfilModel perfil = perfilService.findById(id);
        if (usuarioService.findByIdPerfil(id).size() > 0) {
            rv.addStaticAttribute("error", "no se puede deshabilitar un perfil que contiene a un usuario como minimo!");
            redirectAttributes.addFlashAttribute("ErrorBorrado", true);
        } else {
            perfil.setHabilitado(false);
            perfilService.insertOrUpdate(perfil);
        }
        return rv;
    }

    @GetMapping("/perfil/habilitar/{id}")
    public RedirectView habPerfil_admin(@PathVariable("id") int id) {
        RedirectView rv = new RedirectView(ViewRouteHelper.ADMIN_PERFILES, true);
        PerfilModel perfil = perfilService.findById(id);
        perfil.setHabilitado(true);
        perfilService.insertOrUpdate(perfil);
        return rv;
    }

}
