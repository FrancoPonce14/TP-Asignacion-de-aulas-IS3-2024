package com.TP.IS3.GRUPO3.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.TP.IS3.GRUPO3.domain.Perfil;
import com.TP.IS3.GRUPO3.domain.Usuario;
import com.TP.IS3.GRUPO3.services.IPerfilService;
import com.TP.IS3.GRUPO3.services.IUsuarioService;
import com.TP.IS3.GRUPO3.util.PerfilModel;
import com.TP.IS3.GRUPO3.util.PerfilPDFExporter;
import com.TP.IS3.GRUPO3.util.UsuarioModel;
import com.TP.IS3.GRUPO3.util.UsuarioPDFExporter;
import com.TP.IS3.GRUPO3.util.ViewRouteHelper;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/auditor")
public class AuditorController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IPerfilService perfilService;

    @GetMapping("/index")
    public ModelAndView indexAuditor(@RequestParam(name = "nombreUsuario", required = false) String nombreUsuario) {
        ModelAndView mVA = new ModelAndView(ViewRouteHelper.INDEX_AUDITOR);
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        nombreUsuario = auth.getName();
        mVA.addObject("nombreUsuario", nombreUsuario);
        return mVA;
    }

    // Si no entendi mal, la vista de los profesores solo tiene que ser de
    // visualización entonces podriamos usar esta
    // y que el administrado haga los cosas necesarias
    @GetMapping("/usuarios")
    public ModelAndView verUsuarios_Auditor() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_USUARIOS);
        mAV.addObject("lstUsuarios", usuarioService.findAll());
        mAV.addObject("usuario", new UsuarioModel());
        return mAV;
    }

    @GetMapping("/perfiles")
    public ModelAndView verPerfiles_Auditor() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.AUDITOR_PERFILES);
        mAV.addObject("lstPerfiles", perfilService.findAll());
        mAV.addObject("perfil", new PerfilModel());
        return mAV;
    }

    @GetMapping("/usuarios/pdf")
    public void exportToPDFU(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String hardearKey = "Content-Disposition";
        String harderValue = "attachment; filename=usuarios_" + currentDateTime + ".pdf";
        response.setHeader(hardearKey, harderValue);

        List<Usuario> lstUsuarios = usuarioService.findAll();
        UsuarioPDFExporter exportar = new UsuarioPDFExporter(lstUsuarios);
        exportar.export(response);

    }

    @GetMapping("/perfiles/pdf")
    public void exportToPDFP(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String hardearKey = "Content-Disposition";
        String harderValue = "attachment; filename=perfiles_" + currentDateTime + ".pdf";
        response.setHeader(hardearKey, harderValue);

        List<Perfil> lstPerfiles = perfilService.findAll();
        PerfilPDFExporter exportar = new PerfilPDFExporter(lstPerfiles);
        exportar.export(response);

    }

    @PostMapping("/usuarios/{idUsuario}/inscribir/{idMateria}")
    public String inscribirUsuarioAMateria(
            @PathVariable int idUsuario,
            @PathVariable int idMateria,
            RedirectAttributes redirectAttributes
    ) {
        try {
            usuarioService.inscripcion(idUsuario, idMateria);
            redirectAttributes.addFlashAttribute("success", "El usuario ha sido inscrito a la materia con éxito.");
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
        }
    
        return "redirect:/materia/index";
    }

}