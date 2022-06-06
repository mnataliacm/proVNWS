package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Actividad;
import edu.fpdual.webservicevn.model.dao.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ActividadManager extends Manager<Actividad, Integer> {

  /**
   * Busca las actividad según la ciudad elegida
   *
   * @param con   conexión a BBDD
   * @param idciu ID de la actividad a borrar
   * @return {@code List} of {@code Actividad}
   */
  public Set<Actividad> ActividadesPorCiudad(Connection con, Integer idciu);

}

