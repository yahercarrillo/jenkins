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
 * Clase Modelo de la tabla IK_MCANALES
 * Encargada de los proocesos de interaccion
 * con la tabla a traves de hibernate.
 *
 * @author Yaher Carrillo
 * @Date 20/04/2020
 */
@Entity
@SequenceGenerator(name = "canales-gen", sequenceName = "IK_MCANALES_seq", initialValue = 1, allocationSize = 1)
@Table(name = "IK_MCANALES")
public class Canales implements Serializable, BusinessClass
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "canales-gen")
    @Column(name = "ID_CANAL", nullable = false)
    private Long id;

    @Size(max = 20)
    @Column(name = "COD_CANAL", nullable = false)
    private String codCanal;

    @Size(max = 60)
    @Column(name = "NOMBRE_CANAL", nullable = false)
    private String nombre_canal;

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

    public String getCodCanal()
    {
        return codCanal;
    }

    public void setCodCanal(String codCanal)
    {
        this.codCanal = codCanal;
    }

    public String getNombre_canal()
    {
        return nombre_canal;
    }

    public void setNombre_canal(String nombre_canal)
    {
        this.nombre_canal = nombre_canal;
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
        if (!(obj instanceof Canales))
        {
            return false;
        }
        Canales other = (Canales) obj;
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

    @Override
    public int hashCode()
    {

        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codCanal != null ? codCanal.hashCode() : 0);
        result = 31 * result + (nombre_canal != null ? nombre_canal.hashCode() : 0);
        result = 31 * result + (habilitado != null ? habilitado.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Canal [id=" + id + ", " + "Codigo=" + codCanal + ", " + ", " + "Nombre=" + nombre_canal + ", " + "Habilitado=" + (habilitado == 1 ? "true" : "false") + "]";
    }
}
