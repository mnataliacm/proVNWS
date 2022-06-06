package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Categoria;
import edu.fpdual.webservicevn.model.dao.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CategoriaManager  extends Manager<Categoria, Integer> {

  /**
   * Busca todas las categorias que tienen alguna actividad filtrando por ciudad seleccionada
   * y las cuenta con el alias total
   * @param con conexión a BBDD
   * @return {@code Set} of {@code Categorias}
   */
  public ResultSet CatConAct(Connection con, int id) throws SQLException;
}

