/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.util.service;

/**
 * Enum que describe los errores manejados por la aplicacion
 * cada item puede ser usado por el core de negocio
 * o por las entidades que expongas puertas de acceso a la informacion
 * pueden basarse en este para su manejo y exposicion de fallas.
 *
 * @author Yaher Carrillo
 * @date 20/11/2020
 */
public enum EstatusGenericos
{
    INFO("INFO","200", "PROCESO Efectivo de la operacion"),
    INFO_EMPTY("INFO","404", "Consulta sin valores"),
    PARAM("WARN","415", "No se cumple con los parametros"),
    WARN("WARN", "202","PROCESO Efectivo de la operacion con advertencias"),
    ERROR("ERROR","500", "PROCESO Fallido de la operacion"),
    USUARIO_NO_EXISTE("001", "El usuario no existe", "gestion.usuarios.error.001"),
    USUARIO_YA_EXISTE("002", "El usuario ya existe", "gestion.usuarios.error.002"),
    USUARIO_CREADO_EXITOSAMENTE("003", "El usuario ha sido creado con exito", "gestion.usuarios.efecto.001"),
    NO_SE_CREAN_USUARIOS("004", "La creación de usuarios falló para todas las instancias", "gestion.usuarios.error.003"),
    USUARIO_CLAVE_INVALIDA("005", "Usuario o clave invalida", "gestion.usuarios.error.005"),
    PERFIL_YA_EXISTE("102", "El perfil ya existe", "gestion.perfiles.error.102"),
    PERFIL_NO_EXISTE_CREACION("103", "El perfil no existe", "gestion.perfiles.error.103"),
    PERFIL_NO_EXISTE("101", "La creación de usuarios falló para todas las instancias", "gestion.perfiles.error.101"),
    PERFIL_NOMBRE_NULL("104", "El nombre del perfil no puede ser null", "error.parametro.nombre.notnull"),
    PERFIL_CODIGO_NULL("105", "El codigo del perfil no puede ser null", "error.parametro.codigo.notnull"),
    PERFIL_CODIGO_LONGITUD_MAXIMA("ParameterException,106", "El campo codigo perfil excede la longitud maxima de 20", "error.parametro.codigo.longitud.maxima"),
    PERFIL_CODIGO_LONGITUD_MINIMA("107", "El campo codigo perfil no cumple con la longitud minima", "error.parametro.codigo.longitud.minima"),
    PERFIL_NOMBRE_LONGITUD_MINIMA("108", "El campo nombre perfil no cumple con la longitud minima", "error.parametro.nombre.longitud.minima"),
    PERFIL_NOMBRE_LONGITUD_MAXIMA("109", "El campo nombre perfil excede la longitud maxima de 60", "error.parametro.nombre.longitud.maxima"),
    PARAMETRO_YA_EXISTE("200","El parametro ya existe",""),
    PARAMETRO_CREADO_EXITOSAMENTE("201","El parametro se creo exitosamente",""),
    PARAMETRO_NO_EXISTE("202","El parametro no existe",""),
    PARAMETRO_ACTUALIZADO_EXITOSAMENTE("203","El parametro se actualizo correctamente",""),
    EVENTO_YA_EXISTE("300","El evento ya existe",""),
    EVENTO_CREADO_EXITOSAMENTE("301","El evento se creo exitosamente",""),
    EVENTO_NO_EXISTE("302","El evento no existe",""),
    EVENTO_ACTUALIZADO_EXITOSAMENTE("303","El evento se actualizo correctamente",""),
    ESTILO_YA_EXISTE("400","El estilo ya existe",""),
    ESTILO_CREADO_EXITOSAMENTE("401","El estilo se creo exitosamente",""),
    ESTILO_NO_EXISTE("402","El estilo no existe",""),
    ESTILO_ACTUALIZADO_EXITOSAMENTE("403","El estilo se actualizo correctamente",""),
    CANAL_YA_EXISTE("400","El canal ya existe",""),
    CANAL_CREADO_EXITOSAMENTE("401","El canal se creo exitosamente",""),
    CANAL_NO_EXISTE("402","El canal no existe",""),
    CANAL_ACTUALIZADO_EXITOSAMENTE("403","El canal se actualizo correctamente",""),
    CANAL_NOMBRE_NULL("404", "El nombre del canal no puede ser null", "error.canal.parametro.nombre.notnull"),
    CANAL_CODIGO_NULL("405", "El codigo del canal no puede ser null", "error.canal.parametro.codigo.notnull"),
    CANAL_CODIGO_LONGITUD_MAXIMA("406", "El campo codigo canal excede la longitud maxima de 20", "error.canal.parametro.codigo.longitud.maxima"),
    CANAL_CODIGO_LONGITUD_MINIMA("407", "El campo codigo canal no cumple con la longitud minima", "error.canal.parametro.codigo.longitud.minima"),
    CANAL_NOMBRE_LONGITUD_MINIMA("408", "El campo nombre canal no cumple con la longitud minima", "error.canal.parametro.nombre.longitud.minima"),
    CANAL_NOMBRE_LONGITUD_MAXIMA("409", "El campo nombre canal excede la longitud maxima de 60", "error.canal.parametro.nombre.longitud.maxima"),
    ESTADO_YA_EXISTE("500","El estado ya existe",""),
    ESTADO_CREADO_EXITOSAMENTE("501","El estado se creo exitosamente",""),
    ESTADO_NO_EXISTE("502","El estado no existe",""),
    ESTADO_ACTUALIZADO_EXITOSAMENTE("503","El estado se actualizo correctamente",""),
    CIUDAD_YA_EXISTE("600","La ciudad ya existe",""),
    CIUDAD_CREADO_EXITOSAMENTE("601","La ciudad se creo exitosamente",""),
    CIUDAD_NO_EXISTE("602","La ciudad no existe",""),
    CIUDAD_ACTUALIZADO_EXITOSAMENTE("603","La ciudad se actualizo correctamente",""),
    KIOSK_YA_EXISTE("700","El kiosk ya existe",""),
    KIOSK_CREADO_EXITOSAMENTE("701","El kiosk se creo exitosamente",""),
    KIOSK_NO_EXISTE("702","El kiosk no existe",""),
    KIOSK_ACTUALIZADO_EXITOSAMENTE("703","El kiosk se actualizo correctamente",""),
    KIOSK_CODIGO_LONGITUD_MAXIMA("704", "El campo codigo KIOSK excede la longitud maxima de 20", "error.kiosk.codigo.longitud.maxima"),
    KIOSK_CODIGO_LONGITUD_MINIMA("705", "El campo codigo KIOSK no cumple con la longitud minima", "error.kiosk.codigo.longitud.minima"),
    KIOSK_CODIGO_NULL("706", "El codigo del KIOSK no puede ser null", "error.kiosk.codigo.notnull"),
    ZONA_YA_EXISTE("800","El zona ya existe",""),
    ZONA_CREADO_EXITOSAMENTE("801","El zona se creo exitosamente",""),
    ZONA_NO_EXISTE("802","El zona no existe",""),
    ZONA_ACTUALIZADO_EXITOSAMENTE("803","El zona se actualizo correctamente",""),
    TIPO_NAVEGACION_YA_EXISTE("900","El tipo de navegacion ya existe",""),
    TIPO_NAVEGACION_CREADO_EXITOSAMENTE("901","El tipo de navegacion se creo exitosamente",""),
    TIPO_NAVEGACION_NO_EXISTE("902","El tipo de navegacion no existe",""),
    TIPO_NAVEGACION_ACTUALIZADO_EXITOSAMENTE("903","El tipo de navegacion se actualizo correctamente",""),
    TIPO_SERVICIO_YA_EXISTE("150","El tipo de servicio ya existe",""),
    TIPO_SERVICIO_CREADO_EXITOSAMENTE("151","El tipo de servicio se creo exitosamente",""),
    TIPO_SERVICIO_NO_EXISTE("152","El tipo de servicio no existe",""),
    TIPO_SERVICIO_ACTUALIZADO_EXITOSAMENTE("153","El tipo de servicio se actualizo correctamente",""),
    CONFIGURACION_NAVEGACION_YA_EXISTE("250","La Configuracacion de Navegacion ya existe",""),
    CONFIGURACION_NAVEGACION_CREADO_EXITOSAMENTE("251","La Configuracacion de Navegacion se creo exitosamente",""),
    CONFIGURACION_NAVEGACION_NO_EXISTE("252","La Configuracacion de Navegacion no existe",""),
    CONFIGURACION_NAVEGACION_ACTUALIZADO_EXITOSAMENTE("253","La Configuracacion de Navegacion se actualizo correctamente",""),
    GRUPO_YA_EXISTE("350","El grupo ya existe",""),
    GRUPO_CREADO_EXITOSAMENTE("351","El grupo se creo exitosamente",""),
    GRUPO_NO_EXISTE("352","El grupo no existe",""),
    GRUPO_ACTUALIZADO_EXITOSAMENTE("353","El Servicio union grupo se actualizo correctamente",""),
    SERVICIO_U_GRUPOS_YA_EXISTE("450","El Servicio union grupo ya existe",""),
    SERVICIO_U_GRUPOS_CREADO_EXITOSAMENTE("451","El Servicio union grupo se creo exitosamente",""),
    SERVICIO_U_GRUPOS_NO_EXISTE("452","El Servicio union grupo no existe",""),
    SERVICIO_U_GRUPOS_ACTUALIZADO_EXITOSAMENTE("453","El Servicio union grupo se actualizo correctamente",""),
    SERVICIO_YA_EXISTE("550","El servicio ya existe",""),
    SERVICIO_CREADO_EXITOSAMENTE("551","El servicio se creo exitosamente",""),
    SERVICIO_NO_EXISTE("552","El servicio no existe",""),
    SERVICIO_ACTUALIZADO_EXITOSAMENTE("553","El servicio se actualizo correctamente",""),
    KIOS_U_PARAMETROS_YA_EXISTE("650","El kiosk u parametro ya existe",""),
    KIOS_U_PARAMETROS_CREADO_EXITOSAMENTE("651","El kiosk u parametro se creo exitosamente",""),
    KIOS_U_PARAMETROS_NO_EXISTE("652","El kiosk u parametro no existe",""),
    KIOS_U_PARAMETROS_ACTUALIZADO_EXITOSAMENTE("653","El kiosk u parametro se actualizo correctamente",""),
    COMPONENTES_NAVEGACION_YA_EXISTE("750","La Componentes de Navegacion ya existe",""),
    COMPONENTES_NAVEGACION_CREADO_EXITOSAMENTE("751","La Componentes de Navegacion se creo exitosamente",""),
    COMPONENTES_NAVEGACION_NO_EXISTE("752","La Componentes de Navegacion no existe",""),
    COMPONENTES_NAVEGACION_ACTUALIZADO_EXITOSAMENTE("753","La Componentes de Navegacion se actualizo correctamente",""),
    KIOS_U_CONF_NAVEGACION_YA_EXISTE("850","El kiosk union configuracion navegacion ya existe",""),
    KIOS_U_CONF_NAVEGACION_CREADO_EXITOSAMENTE("851","El kiosk union configuracion navegacion se creo exitosamente",""),
    KIOS_U_CONF_NAVEGACION_NO_EXISTE("852","El kiosk union configuracion navegacion no existe",""),
    KIOS_U_CONF_NAVEGACION_ACTUALIZADO_EXITOSAMENTE("853","El kiosk union configuracion navegacion se actualizo correctamente",""),
    TIPOS_COMPONENTES_YA_EXISTE("950","El Tipo de Componente ya existe",""),
    TIPOS_COMPONENTES_CREADO_EXITOSAMENTE("951","El Tipo de Componente se creo exitosamente",""),
    TIPOS_COMPONENTES_NO_EXISTE("952","El Tipo de Componente no existe",""),
    TIPOS_COMPONENTES_ACTUALIZADO_EXITOSAMENTE("953","El Tipo de Componente se actualizo correctamente","")
    ;




    /**
     * Codigo de la navegacion
     **/
    private String code;
    /**
     * Descripcion del error
     */
    private String description;
    /**
     * Referencia de objetos de mensajes globales
     */
    private String refbundle;

    /**
     * Constructor del Enum que inicializa valores
     *
     * @param code        identificador del elemento
     * @param description ruta del recurso
     * @param refbundle   referencia del archivo de recursos
     */
    EstatusGenericos(String code, String description, String refbundle)
    {
        this.code = code;
        this.description = description;
        this.refbundle = refbundle;
    }

    /**
     * Obtiene el codigo de busqueda del elemento
     *
     * @return codigo de error
     */
    public String getCode()
    {
        return code;
    }

    /**
     * Obtiene la desdcripcion del error
     *
     * @return
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Obtiene la llave de referencia del archivo de recursos de texto
     *
     * @return
     */
    public String getRefbundle()
    {
        return refbundle;
    }

}
