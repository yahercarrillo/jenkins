/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.models;

import co.bancodebogota.definitions.auto.testng.dao.BusinessClass;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Clase Modelo de la tabla IK_MCIUDADES
 * Encargada de los proocesos de interaccion
 * con la tabla a traves de hibernate.
 *
 * @author Yaher Carrillo
 * @Date 20/04/2020
 */
@Entity
@SequenceGenerator(name = "ciudades-gen", sequenceName = "IK_MCIUDADES_seq", initialValue = 1, allocationSize = 1)
@Table(name = "IK_MCIUDADES")
public class Ciudades implements Serializable, BusinessClass
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ciudades-gen")
    @Column(name = "ID_CIUDAD", nullable = false)
    private Long id;

    @Size(max = 20)
    @Column(name = "COD_CIUDAD", nullable = false)
    private String codCiudad;

    @Size(max = 180)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "HABILITADO", nullable = false)
    private Long habilitado;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCodCiudad()
    {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad)
    {
        this.codCiudad = codCiudad;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Long getHabilitado()
    {
        return habilitado;
    }

    public void setHabilitado(Long habilitado)
    {
        this.habilitado = habilitado;
    }

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
        if (!(obj instanceof Ciudades))
        {
            return false;
        }
        Ciudades other = (Ciudades) obj;
        if (id != other.id)
        {
            return false;
        }
        if (codCiudad == null)
        {
            if (other.codCiudad != null)
            {
                return false;
            }
        }
        else if (!codCiudad.equals(other.codCiudad))
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codCiudad != null ? codCiudad.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (habilitado != null ? habilitado.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Ciudad [id=" + id + ", " + "Codigo=" + codCiudad + ", " + ", " + "Descripcion=" + descripcion + ", " + "Habilitado=" + (habilitado == 1 ? "true" : "false") + "]";
    }
}
