/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.util.service;



import java.util.Objects;

/**
 * Clase base para determinar como irá la respuesta de un microservicio
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
public class CommonsResponse
{

    /**
     * Estatus de la solicitud
     */
    String estatus;

    /**
     * Codigo de Error
     */
    String codigo;

    /**
     * Descripcion del error
     */
    String descripcion;

    /**
     * Objeto de Respuesta
     */
    Object response;

    /**
     * Operacion comun de llenado de la informacion
     * para responses efectivos
     */
    public CommonsResponse toOk()
    {
        this.setCodigo(EstatusGenericos.INFO.getDescription());
        this.setEstatus(EstatusGenericos.INFO.getCode());
        this.setDescripcion(EstatusGenericos.INFO.getRefbundle());
        return this;
    }

    /**
     * Response comun para respuestas vacias
     * o sin datos
     * @return
     */
    public CommonsResponse toEmpty(){
        this.setCodigo(EstatusGenericos.INFO_EMPTY.getDescription());
        this.setEstatus(EstatusGenericos.INFO_EMPTY.getCode());
        this.setDescripcion(EstatusGenericos.INFO_EMPTY.getRefbundle());
        return this;
    }

    /**
     * Response comun para errores no controlados
     * @return Reesponse de respuestas con los atributos inicializados
     */
    public CommonsResponse toError(){
        this.setCodigo(EstatusGenericos.ERROR.getDescription());
        this.setEstatus(EstatusGenericos.ERROR.getCode());
        this.setDescripcion(EstatusGenericos.ERROR.getRefbundle());
        return this;
    }

    /**
     * Response comun para errores en la capa de negocio
     * @return Reesponse de respuestas con los atributos inicializados
     */
    public CommonsResponse toWarn(){
        this.setCodigo(EstatusGenericos.WARN.getDescription());
        this.setEstatus(EstatusGenericos.WARN.getCode());
        this.setDescripcion(EstatusGenericos.WARN.getRefbundle());
        return this;
    }

    /**
     * Response comun para errores en la capa de negocio
     * @return Reesponse de respuestas con los atributos inicializados
     */
    public CommonsResponse toWarn(String codigo){
        this.toWarn();
        this.setCodigo(codigo);
        return this;
    }

    public CommonsResponse toParam(){
        this.setCodigo(EstatusGenericos.PARAM.getDescription());
        this.setEstatus(EstatusGenericos.PARAM.getCode());
        this.setDescripcion(EstatusGenericos.PARAM.getRefbundle());
        return this;
    }

    /**
     * @return
     */
    public String getEstatus()
    {
        return estatus;
    }

    /**
     * @param estatus
     */
    public void setEstatus(String estatus)
    {
        this.estatus = estatus;
    }

    /**
     * @return
     */
    public String getCodigo()
    {
        return codigo;
    }

    /**
     * @param codigo
     */
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    /**
     * @return
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @param descripcion
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * @return
     */
    public Object getResponse()
    {
        return response;
    }

    /**
     * @param response
     */
    public void setResponse(Object response)
    {
        this.response = response;
    }

    /**
     * Asigna respuesta exitosa esperada
     *
     * @param respuesta
     */
    public void resultadoExitosoEsperado(Object respuesta)
    {
        setEstatus("200");
        setResponse(respuesta);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CommonsResponse that = (CommonsResponse) o;
        return Objects.equals(estatus, that.estatus) && Objects.equals(codigo, that.codigo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode()
    {
        int result = estatus != null ? estatus.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "CommonsResponse{" + "estatus='" + estatus + '\'' + ", codigo='" + codigo + '\'' + ", descripcion='" + descripcion + '\'' + ", response=" + response + '}';
    }

    public String toJson()
    {
        return this.getResponse().toString();
    }
}
