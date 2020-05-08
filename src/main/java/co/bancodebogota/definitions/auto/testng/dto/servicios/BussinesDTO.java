/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.dto.servicios;

/**
 * Clase generica que contiene valores comunes entre todos
 * los DTO de la aplicacion
 * @author Yaher Carrillo
 * @Date 20/04/2020
 */

public class BussinesDTO
{
    /**Atributo que permite saber que el objeto que estiende esta habilitado*/
    private Long habilitado;


    /**
     * Metodo que optiene el valor del campo habilitado
     * @return Long que puede ser  0 o 1.
     */
    public Long getHabilitado()
    {
        return habilitado;
    }

    /**
     * Asigna un valor al atributo habilitado
     * @param habilitado valor a asignar , 0 o 1.
     */
    public void setHabilitado(Long habilitado)
    {
        this.habilitado = habilitado;
    }

}
