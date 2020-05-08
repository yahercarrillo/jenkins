/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.util.service;

import co.bancodebogota.definitions.auto.testng.exceptions.ParameterException;
import org.apache.log4j.Logger;

/**
 * Clase que se utiliza para obtener todas las validaciones con respecto
 * a los atributos de la clase perfil
 *
 * @author eralarcon
 * @date 20/04/2020
 */
public abstract class ValidacionCrudBase
{
    /**
     * Logger de esta clase
     */
    final static Logger logger = Logger.getLogger(ValidacionCrudBase.class);

    /**
     * atributo que permite saber la longitud maxima del codigo de perfil
     */
    private Integer codigoLongitudMaxima = 20;

    /**
     * atributo que permite saber la longitud minina del codigo de perfil
     */
    private Integer codigoLongitudMinima = 1;

    /**
     * atributo que se utiliza para saber si el campo codigo perfil
     * TRUE permite null, FALSE no permite null
     */
    private Boolean codigoPermiteNull = false;

    /**
     * atributo que permite saber la longitud maxima del codigo de perfil
     */
    private Integer nombreLongitudMaxima = 60;

    /**
     * atributo que permite saber la longitud minina del codigo de perfil
     */
    private Integer nombreLongitudMinima = 1;

    /**
     * atributo que se utiliza para saber si el campo codigo perfil
     * permite ser null o no, TRUE permite null, FALSE no permite null
     */
    private Boolean nombrePermiteNull = false;

    /**
     * atributo que permite saber si el campo habilitado puede ser null
     * TRUE permite null, FALSE no permite null
     */
    private Boolean habilitadoPermiteNull = false;

    /**
     * metodo que se utiliza para asignar los valores correspondientes al codigo
     *
     * @param codigoLongitudMaxima longitud maxima del codigo
     * @param codigoLongitudMinima longitud minima del codigo
     * @param codigoPermiteNull    boolean que indica si permite null o no
     */
    public void setValoresCodigo(Integer codigoLongitudMaxima, Integer codigoLongitudMinima, Boolean codigoPermiteNull)
    {
        this.codigoLongitudMaxima = codigoLongitudMaxima;
        this.codigoLongitudMinima = codigoLongitudMinima;
        this.codigoPermiteNull = codigoPermiteNull;
    }

    /**
     * @param nombreLongitudMaxima longitud maxima del nombre
     * @param nombreLongitudMinima longitud minima del nombre
     * @param nombrePermiteNull    boolean que indica si permite null o no
     */
    public void setValoresNombre(Integer nombreLongitudMaxima, Integer nombreLongitudMinima, Boolean nombrePermiteNull)
    {
        this.nombreLongitudMaxima = nombreLongitudMaxima;
        this.nombreLongitudMinima = nombreLongitudMinima;
        this.nombrePermiteNull = nombrePermiteNull;
    }

    /**
     * metodo que devuelve la longitud maxima del codigo
     *
     * @return Integer
     */
    public Integer getCodigoLongitudMaxima()
    {
        return codigoLongitudMaxima;
    }

    /**
     * metodo que asigna la longitud maxima del codigo
     *
     * @param codigoLongitudMaxima
     */
    public void setCodigoLongitudMaxima(Integer codigoLongitudMaxima)
    {
        this.codigoLongitudMaxima = codigoLongitudMaxima;
    }

    /**
     * metodo que devuelve la longitud minima del codigo
     *
     * @return Integer
     */
    public Integer getCodigoLongitudMinima()
    {
        return codigoLongitudMinima;
    }

    /**
     * metodo que asigna la longitud minina del codigo
     *
     * @param codigoLongitudMinima
     */
    public void setCodigoLongitudMinima(Integer codigoLongitudMinima)
    {
        this.codigoLongitudMinima = codigoLongitudMinima;
    }

    /**
     * metodo que retorna un boolean indicando
     * si permite que el valor sea null o no
     * TRUE   = permite valores null
     * FALSE  = no permite valores null
     *
     * @return Boolean
     */
    public Boolean getCodigoPermiteNull()
    {
        return codigoPermiteNull;
    }

    /**
     * metodo que permite asignar un booleano
     * para indicar si acepta o no NULL el codigo
     * TRUE   = permite valores null
     * FALSE  = no permite valores null
     *
     * @param codigoPermiteNull
     */
    public void setCodigoPermiteNull(Boolean codigoPermiteNull)
    {
        this.codigoPermiteNull = codigoPermiteNull;
    }

    /**
     * metodo que retorna la longitud maxima del nombre
     *
     * @return Integer
     */
    public Integer getNombreLongitudMaxima()
    {
        return nombreLongitudMaxima;
    }

    /**
     * metodo que se encarga de asignar la longitud maxima del nombre
     *
     * @param nombreLongitudMaxima
     */
    public void setNombreLongitudMaxima(Integer nombreLongitudMaxima)
    {
        this.nombreLongitudMaxima = nombreLongitudMaxima;
    }

    /**
     * metodo que devuelve la longitud minima del nombre
     *
     * @return Integer
     */
    public Integer getNombreLongitudMinima()
    {
        return nombreLongitudMinima;
    }

    /**
     * metodo que asigna la longitud minima del nombre
     *
     * @param nombreLongitudMinima
     */
    public void setNombreLongitudMinima(Integer nombreLongitudMinima)
    {
        this.nombreLongitudMinima = nombreLongitudMinima;
    }

    /**
     * metodo que retorna un boolean indicando
     * si permite que el valor sea null o no
     * TRUE   = permite valores null
     * FALSE  = no permite valores null
     *
     * @return Boolean
     */
    public Boolean getNombrePermiteNull()
    {
        return nombrePermiteNull;
    }

    /**
     * metodo que asigna si permite null el nombre
     *
     * @param nombrePermiteNull
     */
    public void setNombrePermiteNull(Boolean nombrePermiteNull)
    {
        this.nombrePermiteNull = nombrePermiteNull;
    }

    /**
     * metodo que se encarga de devolver un boolean
     * indicando si el campo habilitado permite null o no
     * TRUE   = permite valores null
     * FALSE  = no permite valores null
     *
     * @return Boolean
     */
    public Boolean getHabilitadoPermiteNull()
    {
        return habilitadoPermiteNull;
    }

    /**
     * metodo que permite asignar un boolean para indicar si el campo permite
     * null o no
     *
     * @param habilitadoPermiteNull
     */
    public void setHabilitadoPermiteNull(Boolean habilitadoPermiteNull)
    {
        this.habilitadoPermiteNull = habilitadoPermiteNull;
    }

    /**
     * metodo que se encarga de validar campo de texto de acuerdo a los valores pasados por parametro
     *
     * @param campoValidar
     * @param nombreCampo
     * @param longitudMinima
     * @param longitudMaxima
     * @param permiteNull
     * @throws ParameterException
     */
    public void validarCampoTexto(Object campoValidar, String nombreCampo, int longitudMinima, int longitudMaxima, boolean permiteNull,String codigoErrorLongitudMinima, String codigoErrorLongitudMaxima, String codigoErrorPermiteNull) throws ParameterException
    {
        if (null != campoValidar)
        {
            int longitudCampo = ((String) campoValidar).length();

            if (longitudCampo < longitudMinima)
            {
                throw new ParameterException(EnumCodigosValidacion.LONGITUD_MINIMA_EXCEDIDA.getAtributoDescripcion(nombreCampo, longitudMinima), codigoErrorLongitudMinima);
            }

            if (longitudCampo > longitudMaxima)
            {
                throw new ParameterException(EnumCodigosValidacion.LONGITUD_MAXIMA_EXCEDIDA.getAtributoDescripcion(nombreCampo, longitudMaxima), codigoErrorLongitudMaxima);
            }

        }
        else
        {
            if (!permiteNull)
            {
                throw new ParameterException(EnumCodigosValidacion.EL_CAMPO_NO_PUEDE_SER_NULL.getAtributoDescripcion(nombreCampo), codigoErrorPermiteNull);
            }
        }

    }

    /**
     * metodo que se encarga de validar un campo de habilitado de acuerdo a los valores
     * pasados por parametro
     *
     * @param habilitado
     * @param nombreCampo
     * @param permiteNull
     * @throws ParameterException
     */
    public void validacionHabilitado(Object habilitado, String nombreCampo, boolean permiteNull) throws ParameterException
    {
        if (null == habilitado)
        {
            if (!permiteNull)
            {
                throw new ParameterException(EnumCodigosValidacion.EL_CAMPO_NO_PUEDE_SER_NULL.getAtributoDescripcion(nombreCampo), EnumCodigosValidacion.EL_CAMPO_NO_PUEDE_SER_NULL.getCodigo());
            }
        }
    }

    /**
     * metodo que valida si el campo viene vacio, es decir,
     * con '' y espacios en blanco
     * de venir con lo mencionado se retorna null para ser
     * asignado al campo, en caso contrario se retorna la cadena
     *
     * @param campo
     * @return
     */
    public static String vieneVacio(String campo)
    {
        if (campo != null)
        {
            if (campo.trim().equalsIgnoreCase("''"))
            {

                return null;

            }
            else
            {

                if (campo.trim().isEmpty())
                {
                    return null;
                }
                else
                {
                    return campo;
                }
            }
        }

        return null;
    }

    /**
     * metodo que tienen que sobreescribir todas las clases para
     * implementar sus validaciones
     *
     * @throws ParameterException
     */
    public abstract void validaciones() throws ParameterException;

    private static final boolean EXITOSA = Boolean.TRUE;

    /**
     * metodo que valida si el objeto es distinto de null
     * recibe por parametro el objeto  y el nombre
     * del atributo que se va a validar
     *
     * @param objeto
     * @param nombreCampo
     * @throws ParameterException
     */
    public static boolean validarObjeto(Object objeto, String nombreCampo) throws ParameterException
    {
        logger.info("dentro del metodo validarObjeto");
        if (null == objeto)
        {
            logger.debug("El objeto a analizar es null " + objeto);
            throw new ParameterException(EnumCodigosValidacion.EL_CAMPO_NO_PUEDE_SER_NULL.getAtributoDescripcion(nombreCampo), EnumCodigosValidacion.EL_CAMPO_NO_PUEDE_SER_NULL.getCodigo());
        }
        else
        {
            logger.info("El objeto no es null, finaliza la validacion exitosa");
            return EXITOSA;
        }

    }

    /**
     * Metodo que se encarga de validar si un objeto de tipo entidad
     * es null, de ser asi se devuelve un DaoException, en caso contrario
     * se devuelve TRUE
     *
     * @param objetoRespuesta
     * @return boolean
     * @throws
     */
    public static boolean validarObjetoRespuesta(Object objetoRespuesta, String codigo, String descripcion) throws ParameterException
    {

        logger.info("dentro del metodo validarObjeto");

        if (null == objetoRespuesta)
        {
            logger.debug("El objeto a analizar es null " + objetoRespuesta);
            throw new ParameterException(descripcion, codigo);
        }
        else
        {
            logger.info("El objeto no es null, finaliza la validacion exitosa");
            return EXITOSA;
        }
    }

}
