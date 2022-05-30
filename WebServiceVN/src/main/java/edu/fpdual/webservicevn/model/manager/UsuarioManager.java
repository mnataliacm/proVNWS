package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Usuario;

import java.sql.Connection;
import java.util.Set;


public interface UsuarioManager extends Manager<Usuario, Integer>{

  /**
   * Busca todos los usuarios
   *
   * @param con conexión a BBDD
   * @return {@code Set} of {@code Usuario}
   */
  Set<Usuario> todos(Connection con);

  /**
   * Comprobar si usuario existe
   * @param con conexión a BBDD
   * @param id ID del usuario a buscar
   * @return {@code Set} of {@code Usuario}
   */
  Usuario buscaID(Connection con, Integer id);


  /**
   * Modifica datos de un usuario
   * @param con conexión a BBDD
   * @param usuario parámetros recibidos
   * @return {@code Set} of {@code Usuario}
   */
  int crear(Connection con, Usuario usuario);

  /**
   * Modifica datos de un usuario
   * @param con conexión a BBDD
   * @param usuario parámetros recibidos
   * @return {@code boolean} of {@code Usuario}
   */

  boolean modificar(Connection con, Usuario usuario);
  /**
   * Borra un usuario
   * @param con conexión a BBDD
   * @param id ID del usuario a borrar
   * @return {@code Set} of {@code Usuario}
   */
  boolean borrar(Connection con, Integer id);
}
