package com.TP.IS3.GRUPO3.util;

public class ViewRouteHelper {
    public final static String DASHBOARD = "/home/dashboard";
	// INICIO/CIERRE SESIÓN + INDEXS ADMIN - AUDITOR
	public final static String LOGIN = "/session/login";
	public final static String LOGOUT = "/session/logout";
	public final static String INDEX = "/home/index";
	public final static String PERFIL_AUDITOR = "/auditor/index";
	public final static String INDEX_AUDITOR = "/perfiles/perfil_auditor/indexAuditor";
	public final static String PERFIL_ADMIN = "/admin/index";
	public final static String INDEX_ADMIN = "/perfiles/perfil_admin/indexAdmin";
	
	// AUDITOR VER USUARIOS Y PERFILES
	public final static String AUDITOR_USUARIOS = "/perfiles/perfil_auditor/usuario/usuarios";
	public final static String AUDITOR_PERFILES = "/perfiles/perfil_auditor/perfil/roles";
	
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
	//ESPACIO ADMIN
	public final static String ESPACIO_REDIRECT = "/espacio/admin/index";
	public final static String INDEX_ESPACIO = "/perfiles/perfil_admin/espacio/index";
	public final static String ESPACIO_NUEVO = "/perfiles/perfil_admin/espacio/crearEspacio";
	public final static String ESPACIO_AGREGAR = "/perfiles/perfil_admin/espacio/agregarEspacio";
	public final static String ESPACIO_EDITAR = "/perfiles/perfil_admin/espacio/editarEspacio";
	public final static String ESPACIO_EDIT = "/perfiles/perfil_admin/espacio/edit";
	public final static String ESPACIO_ELIMINAR = "/perfiles/perfil_admin/espacio/eliminarEspacio";
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
	//NOTA PEDIDO
	public final static String NOTAPEDIDO_REDIRECT = "/notaPedido/admin/index";
	public final static String INDEX_NOTAPEDIDO = "/perfiles/perfil_admin/notaPedido/index";
	public final static String NOTAPEDIDO_SELECT = "/perfiles/perfil_admin/notaPedido/select";
	public final static String NOTAPEDIDO_NUEVO_C = "/perfiles/perfil_admin/notaPedido/crearCurso";
	public final static String NOTAPEDIDO_NUEVO_F = "/perfiles/perfil_admin/notaPedido/crearFinal";
	public final static String NOTAPEDIDO_EDITAR = "/perfiles/perfil_admin/notaPedido/editarNotaPedido";
	public final static String NOTAPEDIDO_EDITAR_C = "/perfiles/perfil_admin/notaPedido/editarCurso";
	public final static String NOTAPEDIDO_EDITAR_F = "/perfiles/perfil_admin/notaPedido/editarFinal";
	public final static String NOTAPEDIDO_ELIMINAR = "/perfiles/perfil_admin/notaPedido/eliminarNotaPedido";
	public final static String NOTAPEDIDO_VER_CURSO = "/perfiles/perfil_admin/notaPedido/verCurso";
	public final static String NOTAPEDIDO_VER_FINAL = "/perfiles/perfil_admin/notaPedido/verFinal";
	// VISTAS DEL AUDITOR Y PODER REALIZAR PEDIDO
	public final static String AUDITOR_INDEX_NOTAPEDIDO = "/perfiles/perfil_auditor/notaPedido/index";
	public final static String AUDITOR_CREAR_NOTAPEDIDO = "/perfiles/perfil_auditor/notaPedido/crearPedido";
	public final static String AUDITOR_NOTAPEDIDO_VER_CURSO = "/perfiles/perfil_auditor/notaPedido/verCurso";
	public final static String AUDITOR_NOTAPEDIDO_VER_FINAL = "/perfiles/perfil_auditor/notaPedido/verFinal";
	public final static String AUDITOR_NOTAPEDIDO_SELECT = "/perfiles/perfil_auditor/notaPedido/select";
	public final static String AUDITOR_NOTAPEDIDO_NUEVO_C = "/perfiles/perfil_auditor/notaPedido/crearCurso";
	public final static String AUDITOR_NOTAPEDIDO_NUEVO_F = "/perfiles/perfil_auditor/notaPedido/crearFinal";
	public final static String AUDITOR_INDEX_MATERIA = "/perfiles/perfil_auditor/materia/index";
	public final static String AUDITOR_INDEX_ESPACIO = "/perfiles/perfil_auditor/espacio/index";
	public final static String AUDITOR_INDEX_EDIFICIO = "/perfiles/perfil_auditor/edificio/index";
	public final static String AUDITOR_INDEX_DEPARTAMENTO = "/perfiles/perfil_auditor/departamento/index";
	public final static String AUDITOR_INDEX_CARRERA = "/perfiles/perfil_auditor/carrera/index";
	public final static String AUDITOR_INDEX_AULA = "/perfiles/perfil_auditor/aula/index";
}
