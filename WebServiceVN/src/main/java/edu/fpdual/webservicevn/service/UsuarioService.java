package edu.fpdual.webservicevn.service;

import edu.fpdual.proyectovn.model.connector.Connector;
import edu.fpdual.proyectovn.model.dao.Usuario;
import edu.fpdual.proyectovn.model.manager.implement.UsuarioManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class UsuarioService {

  private final UsuarioManagerImpl usuarioManager;

  public UsuarioService(UsuarioManagerImpl usuarioManager) {
    this.usuarioManager = usuarioManager;
  }

public Set<Usuario> todosUsuarios() throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return usuarioManager.todosUsuarios(con);
    }
}

}
