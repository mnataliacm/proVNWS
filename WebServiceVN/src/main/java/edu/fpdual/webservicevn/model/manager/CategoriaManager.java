package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public interface CategoriaManager  extends Manager<Categoria, Integer> {

  /**
   * Busca todas las categorias que tienen alguna actividad filtrando por ciudad seleccionada
   * y las cuenta con el alias total
   * @param con conexión a BBDD
   * @return {@code Set} of {@code Categorias}
   */
  public Set<Categoria> catConAct(Connection con, int id) throws SQLException;
}

