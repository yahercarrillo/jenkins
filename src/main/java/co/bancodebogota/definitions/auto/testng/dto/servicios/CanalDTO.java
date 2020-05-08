/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.dto.servicios;

import java.io.Serializable;

/**
 * DTO para transportar la información de canal. Por ninguna razón se puede
 * enviar la entidad directamente desde capas inferiores de la arquitectura de
 * infokiosk, para eso usar estas clases DTO
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public class CanalDTO extends BussinesDTO implements Serializable
{
    /**
     * Serial de esta clase
     */
    private static final long serialVersionUID = 1L;

    /**Atributo que permite saber que el id de canal*/
    private Long id;

    /**Atributo que permite saber que el codigo de canal*/
    private String codCanal;

    /**Atributo que permite saber que el nombre de canal*/
    private String nombreCanal;

    /**
     * Metodo que optiene el valor del campo id
     * @return Long
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Asigna un valor al atributo id
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Metodo que optiene el valor del campo Codigo
     * @return String
     */
    public String getCodCanal()
    {
        return codCanal;
    }

    /**
     * Asigna un valor al atributo codigo
     * @param codCanal
     */
    public void setCodCanal(String codCanal)
    {
        this.codCanal = codCanal;
    }

    /**
     * Metodo que optiene el valor del campo nombre
     * @return String
     */
    public String getNombreCanal()
    {
        return nombreCanal;
    }

    /**
     * Asigna un valor al atributo Nombre
     * @param nombreCanal
     */
    public void setNombreCanal(String nombreCanal)
    {
        this.nombreCanal = nombreCanal;
    }

    /**
     * Sobre escribe el metodo equals
     * @param obj
     * @return boolean true o false
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof CanalDTO))
        {
            return false;
        }
        CanalDTO other = (CanalDTO) obj;
        if (id != other.id)
        {
            return false;
        }
        if (codCanal == null)
        {
            if (other.codCanal != null)
            {
                return false;
            }
        }
        else if (!codCanal.equals(other.codCanal))
        {
            return false;
        }
        return true;
    }

    /**
     * metodo hashcode para igualar comportamiento de eqals
     * @return int
     */
    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codCanal != null ? codCanal.hashCode() : 0);
        result = 31 * result + (nombreCanal != null ? nombreCanal.hashCode() : 0);
        result = 31 * result + (this.getHabilitado() != null ? this.getHabilitado().hashCode() : 0);
        return result;
    }

    /**
     * Metodo tostring para sobre escribir los valores
     * @return String
     */
    @Override
    public String toString()
    {
        return "Canal [id=" + id + ", " + "Codigo=" + codCanal + ", " + ", " + "Nombre=" + nombreCanal + ", " + "Habilitado=" + (this.getHabilitado() == 1 ? "true" : "false") + "]";
    }
}
