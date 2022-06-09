package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Ciudad;

import java.sql.Connection;
import java.util.Set;

public interface CiudadManager extends Manager<Ciudad, Integer> {

  /**
   * Busca todas las categorias que tienen alguna actividad filtrando por ciudad seleccionada
   * y las cuenta con el alias total
   * @param con conexión a BBDD
   * @param id ID de la ciudad a buscar
   * @return {@code Set} of {@code Ciudades}
   */
  Set<Ciudad> ciuConAct(Connection con, Integer id);
}
