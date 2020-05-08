/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.dto.servicios;

/**
 * DTO para transportar información referente a las Ciudades. Por ninguna razón
 * se puede enviar la entidad directamente desde capas inferiores de la
 * arquitectura de infokiosk, para eso usar estas clases DTO
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public class CiudadesDTO
{
    /**
     * atributo que se utiliza para saber el id de la ciudad
     */
    private Long id;
    /**
     * atributo que se utiliza para saber el codigo de la ciudad
     */
    private String codCiudad;
    /**
     * atributo que se utiliza para saber la descripcion de la ciudad
     */
    private String descripcion;
    /**
     * atributo que se utiliza para saber si esta habilitado el registro de la ciudad
     */
    private Long habilitado;

    /**
     * metodo que devuelve el id de la ciudad
     *
     * @return Long
     */
    public Long getId()
    {
        return id;
    }

    /**
     * metodo que asigna el id de la ciudad
     *
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * metodo que obtiene el codigo de la ciudad
     *
     * @return String
     */
    public String getCodCiudad()
    {
        return codCiudad;
    }

    /**
     * metodo que asigna el codigo de la ciudad
     *
     * @param codCiudad
     */
    public void setCodCiudad(String codCiudad)
    {
        this.codCiudad = codCiudad;
    }

    /**
     * metodo que devuelve la descripcion de la ciudad
     *
     * @return String
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * metodo que asigna la descripcion de la ciudad
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * metodo que devuelve si se encuentra habilitado o no, el tipo de navegacion
     *
     * @return Long
     */
    public Long getHabilitado()
    {
        return habilitado;
    }

    /**
     * metodo que se encarga de asignar si el registro de la ciudad esta habilitado o no.
     *
     * @param habilitado
     */
    public void setHabilitado(Long habilitado)
    {
        this.habilitado = habilitado;
    }

    @Override
    public String toString()
    {
        return "CiudadesDTO{" + "id=" + id + ", codCiudad='" + codCiudad + '\'' + ", descripcion='" + descripcion + '\'' + ", habilitado=" + habilitado + '}';
    }
}
