package edu.fpdual.webservicevn.model.manager;

import java.sql.Connection;
import java.util.Set;

public interface Manager<T, U> {

  /**
   * Muestra todas las entidades
   *
   * @param con Conexión BD
   * @return a {@link Set} of {@link T}
   */
  Set<T> todos(Connection con);

  /**
   * Borrar una entidad
   *
   * @param con DB connection
   * @param id Entities id to delete.
   * @return a {@link Boolean}
   */
  boolean borrar(Connection con, U id);

  /**
   * Crea una entidad
   *
   * @param con DB connection
   * @param entity The entity to create
   * @return a {@link int}
   */
  int crear(Connection con, T entity);

  /**
   * Modificar una entidad
   *
   * @param con DB connection
   * @param entity The entity to update
   * @return a {@link Boolean}
   */
  boolean modificar(Connection con, T entity);

  /**
   * Finds all the entities in the DB based on a list of ids.
   *
   * @param con DB connection
   * @param id Entities id to search for.
   * @return a {@link T}
   */
  T buscaID(Connection con, U id);

}

