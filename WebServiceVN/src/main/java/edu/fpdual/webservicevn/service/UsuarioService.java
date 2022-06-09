package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.implement.UsuarioManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

// TODO: 08/06/2022 preguntar a Mariano si no se quita lo del void
public class UsuarioService {
  private final UsuarioManagerImpl usuarioManager;
  public UsuarioService(UsuarioManagerImpl usuarioManager) {
    this.usuarioManager = usuarioManager;
  }

  public Set<Usuario> todosUsuarios() throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return usuarioManager.todos(con);
    }
  }
  public Usuario buscaId(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return usuarioManager.buscaID(con, id);
    }
  }
  public boolean borrarUsuario(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return usuarioManager.borrar(con, id);
    }
  }
  public int nuevoUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return usuarioManager.crear(con, usuario);
    }
  }
  public boolean modificarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return usuarioManager.modificar(con, usuario);
    }
  }

  public Usuario buscaNombre(String nom) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return usuarioManager.buscaNombre(con, nom);
    }
  }
}
