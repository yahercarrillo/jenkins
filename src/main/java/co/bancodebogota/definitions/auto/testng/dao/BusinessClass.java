/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.dao;

/**
 * Interfaz que deben implementar todas clases con objetos de negocio.
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public interface BusinessClass
{
    /**
     * Regresa el Id del objeto.
     * @return Id del objeto.
     */
    public Long getId();

    public Long getHabilitado();
}
