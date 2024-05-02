package com.TP.IS3.GRUPO3.util;

public class ViewRouteHelper {
    public final static String DASHBOARD = "/home/dashboard";
	// INICIO/CIERRE SESIÓN + INDEXS ADMIN - AUDITOR
	public final static String LOGIN = "/session/login";
	public final static String LOGOUT = "/session/logout";
	public final static String INDEX = "/home/index";
	public final static String PERFIL_ESTUDIANTE = "/auditor/index";
	public final static String INDEX_ESTUDIANTE = "/perfiles/perfil_auditor/indexAuditor";
	public final static String PERFIL_ADMIN = "/admin/index";
	public final static String INDEX_ADMIN = "/perfiles/perfil_admin/indexAdmin";
	
	// VER USUARIOS Y PERFILES
	public final static String ESTUDIANTE_USUARIOS = "/perfiles/perfil_auditor/usuario/usuarios";
	public final static String ESTUDIANTE_PERFILES = "/perfiles/perfil_auditor/perfil/roles";
	
	// ADMIN VER USUARIOS Y PERFILES
	public final static String VER_USUARIOS = "/perfiles/perfil_admin/usuario/usuarios";
	public final static String VER_PERFILES = "/perfiles/perfil_admin/perfil/roles";	
	
	//ABM USUARIOS -A DMIN
	public final static String AGREGAR_USUARIO = "/perfiles/perfil_admin/usuario/nuevoUsuario";
	public final static String EDITAR_USUARIO = "/perfiles/perfil_admin/usuario/editarUsuario";
	public final static String ADMIN_USUARIOS = "/admin/usuarios";
	//ABM PERFILES -A DMIN
	public final static String AGREGAR_PERFIL = "/perfiles/perfil_admin/perfil/nuevoRol";
	public final static String EDITAR_PERFIL= "/perfiles/perfil_admin/perfil/editarRol";
	public final static String ADMIN_PERFILES = "/admin/perfiles";
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//EDIFICIO ADMIN
	public final static String EDIFICIO_REDIRECT = "/edificio/admin/index";
	public final static String INDEX_EDIFICIO = "/perfiles/perfil_admin/edificio/index";
	public final static String EDIFICIO_NUEVO = "/perfiles/perfil_admin/edificio/crearEdificio";
	public final static String EDIFICIO_AGREGAR = "/perfiles/perfil_admin/edificio/agregarEdificio";
	public final static String EDIFICIO_EDITAR = "/perfiles/perfil_admin/edificio/editarEdificio";
	public final static String EDIFICIO_EDIT = "/perfiles/perfil_admin/edificio/edit";
	public final static String EDIFICIO_ELIMINAR = "/perfiles/perfil_admin/edificio/eliminarEdificio";
	public final static String EDIFICIO_CON_AULAS = "/perfiles/perfil_admin/edificio/verEdificiosConAulas"; //PARA VER EDIFICIOS CON AULA, EL EDIFICIO TIENEN QUE TENER COMO MINIMO 1 AULA, SINO TIRA ERROR (SE PUEDE ARREGLAR, PERO NO LLEGAMOS CON EL TIEMPO)
	//AULA ADMIN
	public final static String AULA_REDIRECT = "/aula/admin/index";
	public final static String INDEX_AULA = "/perfiles/perfil_admin/aula/indexadmin";
	public final static String AULA_SELECT = "/perfiles/perfil_admin/aula/select";
	public final static String AULA_NUEVO_L = "/perfiles/perfil_admin/aula/crearLaboratorio";
	public final static String AULA_NUEVO_T = "/perfiles/perfil_admin/aula/crearTradicional";
	public final static String AULA_EDITAR = "/perfiles/perfil_admin/aula/editarAula";
	public final static String AULA_EDITAR_L = "/perfiles/perfil_admin/aula/editarLaboratorio";
	public final static String AULA_EDITAR_T = "/perfiles/perfil_admin/aula/editarTradicional";
	public final static String AULA_ELIMINAR = "/perfiles/perfil_admin/aula/eliminarAula";
	//DEPARTAMENTO ADMIN
	public final static String DEPARTAMENTO_REDIRECT = "/departamento/admin/index";
	public final static String INDEX_DEPARTAMENTO = "/perfiles/perfil_admin/departamento/index";
	public final static String DEPARTAMENTO_NUEVO = "/perfiles/perfil_admin/departamento/crearDepartamento";
	public final static String DEPARTAMENTO_AGREGAR = "/perfiles/perfil_admin/departamento/agregarDepartamento";
	public final static String DEPARTAMENTO_EDITAR = "/perfiles/perfil_admin/departamento/editarDepartamento";
	public final static String DEPARTAMENTO_EDIT = "/perfiles/perfil_admin/departamento/edit";
	public final static String DEPARTAMENTO_ELIMINAR = "/perfiles/perfil_admin/departamento/eliminarDepartamento";
	//CARRERA ADMIN
	public final static String CARRERA_REDIRECT = "/carrera/admin/index";
	public final static String INDEX_CARRERA = "/perfiles/perfil_admin/carrera/index";
	public final static String CARRERA_NUEVO = "/perfiles/perfil_admin/carrera/crearCarrera";
	public final static String CARRERA_AGREGAR = "/perfiles/perfil_admin/carrera/agregarCarrera";
	public final static String CARRERA_EDITAR = "/perfiles/perfil_admin/carrera/editarCarrera";
	public final static String CARRERA_EDIT = "/perfiles/perfil_admin/carrera/edit";
	public final static String CARRERA_ELIMINAR = "/perfiles/perfil_admin/carrera/eliminarCarrera";
	//MATERIA ADMIN
	public final static String MATERIA_REDIRECT = "/materia/admin/index";
	public final static String INDEX_MATERIA = "/perfiles/perfil_admin/materia/index";
	public final static String MATERIA_NUEVO = "/perfiles/perfil_admin/materia/crearMateria";
	public final static String MATERIA_AGREGAR = "/perfiles/perfil_admin/materia/agregarMateria";
	public final static String MATERIA_EDITAR = "/perfiles/perfil_admin/materia/editarMateria";
	public final static String MATERIA_EDIT = "/perfiles/perfil_admin/materia/edit";
	public final static String MATERIA_ELIMINAR = "/perfiles/perfil_admin/materia/eliminarMateria";
	// VISTAS DEL AUDITOR Y PODER REALIZAR PEDIDO
	public final static String AUDITOR_INDEX_MATERIA = "/perfiles/perfil_auditor/materia/index";
	public final static String AUDITOR_INDEX_EDIFICIO = "/perfiles/perfil_auditor/edificio/index";
	public final static String AUDITOR_INDEX_DEPARTAMENTO = "/perfiles/perfil_auditor/departamento/index";
	public final static String AUDITOR_INDEX_CARRERA = "/perfiles/perfil_auditor/carrera/index";
	public final static String AUDITOR_INDEX_AULA = "/perfiles/perfil_auditor/aula/index";
}
