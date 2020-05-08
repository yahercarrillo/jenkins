/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.exceptions;

/**
 * Excepcion lanzada en caso de fallar una operacion de crud.
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public class ServiceException extends Exception
{
    /** Version de la clase */
    private static final long serialVersionUID = 1L;

    private String description;
    /**
     * Codigo de Error
     */
    private String code;

    /**
     * Crea la excepcion.
     * @param mensaje Mensaje informador sobre la excepcion.
     */
    public ServiceException(String mensaje) {
        super(mensaje);
    }

    public  ServiceException(String mensaje, String code) {
        super(mensaje);
        this.code = code;
    }

    /**
     * Crea la excepcion.
     * @param mensaje Mensaje informando sobre la excepcion.
     * @param causa Causa de la excepcion.
     */
    public ServiceException(String mensaje, Throwable causa)
    {
        super(mensaje,causa);
    }

    public ServiceException(String mensaje, Throwable causa,String code)
    {
        super(mensaje,causa);
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
