package edu.fpdual.webservicevn.model.manager;

import edu.fpdual.webservicevn.model.dao.Usuario;

import java.sql.Connection;

public interface UsuarioManager extends Manager<Usuario, Integer> {
  /**
   * Busca usuario por nombre
   *
   * @param con Conexión BD
   * @param nom Nombre a buscar
   * @return a {@link Usuario}
   */
  Usuario buscaNombre(Connection con, String nom);

  /**
   * Envia email
   *
   * @param usuario Dirección de correo electrónico
   * @return a {@link Boolean}
   */
  boolean enviaEmailBienvenida(Usuario usuario);

}
