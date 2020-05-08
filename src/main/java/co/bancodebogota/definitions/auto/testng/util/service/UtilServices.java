/*
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * BANCO DE BOGOTA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE
 * DERECHOS DE AUTOR.
 */
package co.bancodebogota.definitions.auto.testng.util.service;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase tiene metodos comunes para la capa intermedia
 * @autor Edgar Gonzalez
 * @date 13/02/2019
 *
 * @author Yaher Carrillo
 * @since 20/04/2020
 */
public abstract class UtilServices
{
    /**
     * Logger de esta clase
     */
    final static Logger logger = Logger.getLogger(UtilServices.class);

    /**
     * Metod que me permite cambar la extructura de un dato
     * de minunscala a mayuscula
     * @param obj
     */
    public static void convertAtrrUppercase(Object obj)
    {
        for (Field f : obj.getClass().getDeclaredFields())
        {
            if (f.getType().equals(String.class))
            {
                f.setAccessible(true);
                try
                {
                    if (!f.getName().equals("clave"))
                    {
                        String valor = (String) (f.get(obj) != null ? f.get(obj) : "");
                        if (valor != null && !valor.trim().equals(""))
                            f.set(obj, (valor).toUpperCase());
                    }
                }
                catch (IllegalAccessException e)
                {
                    logger.error("Ha ocurrido un error tratando de volver mayusculas todos ls String de la clase: " + obj.getClass());
                }
            }
        }
    }

    /**
     * metodo que se encarga de convertir una fecha al siguiente formato
     *  2017-11-08T14:20:30Z - yyyy-MM-dd'T'HH:mm:ss'Z'
     *
     * @param fecha
     * @return String fecha formateada
     */
    public  static String convertFechaToFormat(Date fecha)
    {
        logger.debug("iniciando metodo convertFechaToFormat");
        SimpleDateFormat formatoDeSalida = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        logger.debug("finaliza metodo convertFechaToFormat");
        return formatoDeSalida.format(fecha);
    }

}
