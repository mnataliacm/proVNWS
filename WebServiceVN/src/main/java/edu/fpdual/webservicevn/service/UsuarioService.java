package edu.fpdual.webservicevn.service;

import edu.fpdual.proyectovn.model.connector.Connector;
import edu.fpdual.proyectovn.model.dao.Usuario;
import edu.fpdual.webservicevn.controller.UsuarioController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioService {

  private UsuarioController usuarioController;
  public UsuarioService(UsuarioController usuarioController) {
    this.usuarioController = usuarioController;
  }

public List<Usuario> todosUsuarios() throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return (List<Usuario>) usuarioController.todosUsuarios();
    }
}

}
