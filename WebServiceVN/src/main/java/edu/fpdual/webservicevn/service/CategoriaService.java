package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Categoria;
import edu.fpdual.webservicevn.model.manager.implement.CategoriaManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

// TODO: 08/06/2022 preguntar a Mariano si no se quita lo del void
public class CategoriaService {
  private final CategoriaManagerImpl categoriaManager;

  public CategoriaService(CategoriaManagerImpl categoriaManager) {
    this.categoriaManager = categoriaManager;
  }

  public Set<Categoria> todasCategorias() throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return categoriaManager.todos(con);
    }
  }
  public Categoria buscaId(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return categoriaManager.buscaID(con, id);
    }
  }
  public boolean borrarCategoria(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return categoriaManager.borrar(con, id);
    }
  }
  public int nuevaCategoria(Categoria categoria) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return categoriaManager.crear(con, categoria);
    }
  }
  public boolean modificarCategoria(Categoria categoria) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return categoriaManager.modificar(con, categoria);
    }
  }

  public Set<Categoria> catConAct(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return categoriaManager.catConAct(con, id);
    }
  }
}
