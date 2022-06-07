package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Ciudad;

import java.sql.Connection;

public interface CiudadManager extends Manager<Ciudad, Integer> {
  /**
   * Busca por ID el nombre de la ciudad
   * @param con conexión a BBDD
   * @param id ID de la ciudad
   * @return a {@code String}
   */
  String nombreCiudad(Connection con, Integer id);
}
