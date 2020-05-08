/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.util.service;

/**
 * Enumerado para controlar los codigos de validacion de los parametros
 * de los servicios
 *
 * @author eralarcon
 * @Date 20/04/2020
 */
public enum EnumCodigosValidacion
{
    EL_CAMPO_NO_PUEDE_SER_NULL("001", "El campo ? no puede ser null"),
    EL_CAMPO_DEBE_SER_MAYOR_A_CERO("002", "El campo ? tiene que ser mayor a cero"),
    BUSQUEDA_NO_ENCONTRADA("003","El registro a buscar no existe"),
    ERROR_AL_CREAR_REGISTRO("004","Error al crear el registro"),
    LONGITUD_MAXIMA_EXCEDIDA("005","El campo ? excede la longitud permitida de :long "),
    LONGITUD_MINIMA_EXCEDIDA("005","El campo ? excede la longitud minima permitida de :long "),
    ERROR_DE_MODIFICACION("006","No se pudo modificar con exito"),
    ERROR_DE_ELIMINACION("007","No se pudo eliminar con exito")
    ;

    private String codigo;
    private String descripcion;

    /**
     * @param codigo
     * @param descripcion
     */
    EnumCodigosValidacion(String codigo, String descripcion)
    {
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
    }

    /**
     * metodo que devuelve el codigo del error
     *
     * @return String
     */
    public String getCodigo()
    {
        return codigo;
    }

    /**
     * metodo que asigna un codigo
     *
     * @param codigo
     */
    private void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    /**
     * metodo que devuelve la descripcion del error
     *
     * @return String
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * metodo que asigna una descripcion
     *
     * @param descripcion
     */
    private void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * metodo que complementa la descripcion del codigo de error
     * sustituye el comodin '?' por el nombre del atributo que recibe
     * el metodo,
     *
     * @param atributo
     */
    private String setAtributoDescripcion(String atributo)
    {
        this.setDescripcion(this.getDescripcion().replace("?", atributo));
        return this.getDescripcion();
    }

    /**
     * metodo que complementa la descripcion del codigo de error
     * sustituye el comodin '?' por el nombre del atributo que recibe
     * el metodo, metodo que funciona para dos comodines
     *
     * @param atributo
     * @param valor
     *
     * @return String
     */
    private String setAtributoDescripcion(String atributo,Integer valor)
    {
        this.setDescripcion(this.getDescripcion().replace("?", atributo));
        this.setDescripcion(this.getDescripcion().replace(":long", valor.toString()));

        return this.getDescripcion();
    }

    /**
     * metodo que se encarga de asigar un nombre y un valor a la descripcion
     * @param atributo
     * @param valor
     * @return String
     */
    public String getAtributoDescripcion(String atributo,Integer valor)
    {
        return setAtributoDescripcion(atributo,valor);
    }

    /**
     * metodo que se encarga de asigar un nombre y un valor a la descripcion
     *
     * @param atributo
     * @return String
     */
    public String getAtributoDescripcion(String atributo)
    {
        return setAtributoDescripcion(atributo);
    }
}
