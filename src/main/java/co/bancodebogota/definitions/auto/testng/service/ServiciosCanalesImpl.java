/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.service;

import co.bancodebogota.definitions.auto.testng.dto.servicios.CanalDTO;
import co.bancodebogota.definitions.auto.testng.exceptions.DaoException;
import co.bancodebogota.definitions.auto.testng.exceptions.ParameterException;
import co.bancodebogota.definitions.auto.testng.exceptions.ServiceException;
import co.bancodebogota.definitions.auto.testng.models.Canales;
import co.bancodebogota.definitions.auto.testng.util.service.EnumCodigosValidacion;
import co.bancodebogota.definitions.auto.testng.util.service.EstatusGenericos;
import co.bancodebogota.definitions.auto.testng.util.service.UtilServices;
import co.bancodebogota.definitions.auto.testng.dao.CanalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de los servicios de Canales
 *
 * @author Yaher Carrillo
 * @date 20/04/2020
 */
@Service("ServiciosCanalesImpl")
@Transactional
public class ServiciosCanalesImpl extends UtilServices implements ServicioCanales
{
    /**
     * Logger de esta clase
     */
    final static Logger logger = Logger.getLogger(ServiciosCanalesImpl.class);

    @Autowired
    private CanalesDao canalDao;

    @Override
    public CanalDTO buscarCanalPorId(Long id) throws ParameterException
    {
        logger.info("Se ingresa al metodo buscarCanalPorId " + id);
        CanalDTO canalDto = null;
        logger.debug("Ingreso a buscar el canal por ID");
        Canales canales = canalDao.buscarPorId(id);
        canalDto = canalesToCanalDto(canales);
        logger.debug("La busqueda por ID finalizo con exito");
        return canalDto;
    }

    @Override
    public void crearCanal(CanalDTO canalDto) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo crearCanal ");

        try
        {

            logger.info("Se prosigue a crear el canal ");
            Canales canales = canalDtoToCanales(canalDto);
            canales = canalDao.buscarObjetoUnico(canales);
            if (canales == null)
            {
                canales = canalDtoToCanales(canalDto);
                convertAtrrUppercase(canales);
                Long id = canalDao.agregar(canales);
                logger.info("el Id del registro creado es:" + id.intValue());
                logger.debug("El canal se creo con exito");
            }
            else
            {
                logger.info("Se valida si el codigo existe");
                validarSiExiste(canalDto.getId());
                throw new DaoException(EstatusGenericos.CANAL_YA_EXISTE.getCode(), EstatusGenericos.CANAL_YA_EXISTE.getDescription());
            }
        }
        catch (DaoException e)
        {
            String mensaje = "Ocurrio un error creando el canal ServiceException";
            logger.debug(mensaje, e);
            throw new ServiceException(mensaje, e);
        }
        logger.info("finalizo el crearCanal");
    }

    @Override
    public void crearCanalMasivo(List<CanalDTO> listCanalesDto) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo crearCanalMasivo ");

        for (CanalDTO canalDto : listCanalesDto)
        {
            crearCanal(canalDto);
        }
        logger.info("Se ingresa al metodo crearCanalMasivo ");
    }

    @Override
    public List<CanalDTO> encontrarCanalesSegunFiltro(CanalDTO canalDto) throws ServiceException, ParameterException
    {
        logger.info("Dentro del metodo encontrarCanalesSegunFiltro");
        List<CanalDTO> listCanalDto = null;
        logger.debug("Ingreso a consultar canal segun filtro");

        Canales canales = canalDtoToCanales(canalDto);
        convertAtrrUppercase(canales);
        List<Canales> listaCanales = canalDao.buscar(canales);
        listCanalDto = listaToListaDto(listaCanales);
        logger.debug("La consulta del canal por fltro se realizo con exito");

        logger.info("finalizo el metodo encontrarCanalesSegunFiltro");
        return listCanalDto;
    }

    @Override
    public void modificarCanalesSegunFiltro(CanalDTO canalDto) throws ServiceException, ParameterException
    {
        logger.info("Se ingresa al metodo modificarEventosSegunFiltro ");
        try
        {
            logger.debug("Ingreso a modificar el canal");

            Canales canales = canalDao.buscarPorId(canalDto.getId());
            if (canales == null)
            {
                logger.error("El canal no se pudo actualizar con exito" + EnumCodigosValidacion.ERROR_DE_MODIFICACION.getCodigo());
                throw new DaoException(EnumCodigosValidacion.ERROR_DE_MODIFICACION.getCodigo(), EnumCodigosValidacion.ERROR_DE_MODIFICACION.getDescripcion());
            }
            canales.setNombre_canal(canalDto.getNombreCanal());
            canales.setHabilitado(canalDto.getHabilitado());
            convertAtrrUppercase(canales);
            canalDao.actualizar(canales);
            logger.debug("Actualizo con exito el canal");
        }
        catch (DaoException e)
        {
            logger.info("error en el metodo  modificarCanalesSegunFiltro ");
            throw new ServiceException(e.getMessage());
        }
        logger.info("finaliza el metodo modificarEventosSegunFiltro ");
    }

    @Override
    public void eliminarCanales(CanalDTO canalDto) throws ServiceException, ParameterException
    {
        logger.info("Inicio el metodo eliminar Canal ");
        try
        {
            logger.debug("Ingreso al metodo de eliminar canal");

            Canales canales = canalDao.buscarPorId(canalDto.getId());
            if (canales == null)
            {
                logger.error("No se pudo eliminar el canal con exito" + EnumCodigosValidacion.ERROR_DE_ELIMINACION.getCodigo());
                throw new ParameterException(EnumCodigosValidacion.ERROR_DE_ELIMINACION.getCodigo(), EnumCodigosValidacion.ERROR_DE_ELIMINACION.getDescripcion());
            }
            canalDao.eliminar(canales);
        }
        catch (Exception e)
        {
            logger.error("Ocurrio un error eliminarCanales ServiceException", e);
            throw new ServiceException(EnumCodigosValidacion.ERROR_DE_ELIMINACION.getCodigo(), EnumCodigosValidacion.ERROR_DE_ELIMINACION.getDescripcion());
        }
        logger.info("finaliza el metodo eliminar Canal ");
    }

    @Override
    public List<CanalDTO> listarTodasCanales() throws ServiceException
    {
        logger.info("Dentro del metodo listarTodasCanales habilitado");
        List<CanalDTO> listCanalDto = null;
        logger.debug("Ingreso a listar todos los canales");
        Canales canales = new Canales();
        List<Canales> listaCanales = canalDao.buscar(canales);
        listCanalDto = listaToListaDto(listaCanales);
        logger.debug("Todos los canales fueron listados con exito");
        logger.info("finalizo el metodo lista todos los Canales habilitados");
        return listCanalDto;
    }

    /**
     * metodo encargado de pasar los valores de un objeto canales (entidad) a
     * un objeto de tipo CanalDTO
     *
     * @param canal
     * @return CanalDTO
     */

    public static CanalDTO canalesToCanalDto(Canales canal)
    {

        CanalDTO canalDto = new CanalDTO();
        canalDto.setCodCanal((null != canal.getCodCanal()) ? canal.getCodCanal() : null);
        canalDto.setId((null != canal.getId()) ? canal.getId() : null);
        canalDto.setNombreCanal((null != canal.getNombre_canal()) ? canal.getNombre_canal() : null);
        canalDto.setHabilitado((null != canal.getHabilitado()) ? canal.getHabilitado() : null);
        return canalDto;
    }

    /**
     * metodo encargado de pasar los valores de un objeto CanalDTO (DTO) a
     * un objeto de tipo Canales (Entidad)
     *
     * @param canalDto
     * @return Canales
     */
    public static Canales canalDtoToCanales(CanalDTO canalDto)
    {
        Canales canal = new Canales();
        canal.setCodCanal((null != canalDto.getCodCanal()) ? canalDto.getCodCanal() : null);
        canal.setId((null != canalDto.getId()) ? canalDto.getId() : null);
        canal.setNombre_canal((null != canalDto.getNombreCanal()) ? canalDto.getNombreCanal() : null);
        canal.setHabilitado((null != canalDto.getHabilitado()) ? canalDto.getHabilitado() : null);
        return canal;
    }

    /**
     * metodo que se encarga de validar si existe un canal por id de canal,
     * si existe devulve TRUE, en caso de existir devuelve ServiceException
     *
     * @param id
     * @return boolean
     * @throws ParameterException
     */
    private boolean validarSiExiste(Long id)
    {
        logger.info("dentro del metodo validarSiExiste, se valida si existe el id ");
        try
        {
            logger.debug("Ingreso a validar si el objeto existe");

            Canales canales = canalDao.buscarPorId(id);
            logger.debug("La validacion del objeto se realizo con exito");
            return true;
        }
        catch (Exception e)
        {
            String mensaje = "Ocurrio un error al buscarCliente el registro ";
            logger.error(mensaje, e);
        }
        return false;

    }

    /**
     * metodo que llena un arrayList de CanalDTO dada una lista de Canales
     *
     * @param listaCanales
     * @return ArrayList<CanalDTO>
     */
    private List<CanalDTO> listaToListaDto(List<Canales> listaCanales) throws ServiceException
    {

        List<CanalDTO> listCanalDto = new ArrayList<>();
        if (null == listaCanales || listaCanales.isEmpty())
        {
            logger.debug("la lista de Canales esta vacia");
            throw new ServiceException(EstatusGenericos.CANAL_NO_EXISTE.getDescription(), EstatusGenericos.CANAL_NO_EXISTE.getCode());
        }
        else
        {
            for (Canales canal : listaCanales)
            {
                CanalDTO canalDto = canalesToCanalDto(canal);
                listCanalDto.add(canalDto);
            }
        }
        return listCanalDto;
    }

}
