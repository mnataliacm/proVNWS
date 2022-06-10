package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Actividad;

import java.sql.Connection;

import java.util.Set;

public interface ActividadManager extends Manager<Actividad, Integer> {

  /**
   * Busca las actividad según la ciudad elegida
   *
   * @param con   conexión a BBDD
   * @param id ID de la actividad a borrar
   * @return {@code List} of {@code Actividad}
   */
  Set<Actividad> actPorCiu(Connection con, Integer id);

}

