package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Usuario;


public interface UsuarioManager extends Manager<Usuario, Integer>{

  /**
   * Busca todos los usuarios
   *
   * @param con conexión a BBDD
   * @return {@code Set} of {@code Usuario}
   *//*
  Set<Usuario> todosUsuarios(Connection con);

  *//**
   * Comprobar si usuario existe
   * @param con conexión a BBDD
   * @param id ID del usuario a buscar
   * @return {@code Set} of {@code Usuario}
   *//*
  public boolean buscarID(Connection con, int id);


  *//**
   * Modifica datos de un usuario
   * @param con conexión a BBDD
   * @param nom nuevo/mismo nombre
   * @param ape nuevo/mismo apellido
   * @param email nuevo/mismo email
   * @param pass nueva/mismo pass
   * @param movil nuevo/mismo movil
   * @return {@code Set} of {@code Usuario}
   *//*
  public boolean nuevoUsuario(Connection con, String nom, String ape, String email, String pass, String movil);

  *//**
   * Modifica datos de un usuario
   * @param con conexión a BBDD
   * @param nom nuevo/mismo nombre
   * @param ape nuevo/mismo apellido
   * @param email nuevo/mismo email
   * @param pass nueva/mismo pass
   * @param movil nuevo/mismo movil
   * @param id ID del usuario a modificar
   * @return {@code boolean} of {@code Usuario}
   *//*
  public boolean modificarUsuario(Connection con, String nom, String ape, String email, String pass, String movil, int id);
  *//**
   * Borra un usuario
   * @param con conexión a BBDD
   * @param id ID del usuario a borrar
   * @return {@code Set} of {@code Usuario}
   *//*
  public boolean borraUsuario(Connection con, int id);
*/
}
