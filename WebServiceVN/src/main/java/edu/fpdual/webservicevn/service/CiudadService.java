package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.controller.CiudadController;
import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Ciudad;
import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.implement.CiudadManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class CiudadService {
  private final CiudadManagerImpl ciudadManager;

  public CiudadService(CiudadManagerImpl ciudadManager) {
    this.ciudadManager = ciudadManager;
  }

  public Set<Ciudad> todasCiudades() throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return ciudadManager.todos(con);
    }
  }

  public String nombreCiudad(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      Ciudad ciudad = ciudadManager.buscaID(con, id);
      return ciudad.getNom();
    }
  }
  public boolean borrarCiudad(Integer id) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return ciudadManager.borrar(con, id);
    }
  }
  public int nuevaCiudad(Ciudad ciudad) throws SQLException, ClassNotFoundException {
    try (Connection con = new Connector().getConnection()) {
      return ciudadManager.crear(con, ciudad);
    }
  }
  public boolean modificarCiudad(Ciudad ciudad) throws SQLException, ClassNotFoundException {
    try (Connection con =new Connector().getConnection()) {
      return ciudadManager.modificar(con, ciudad);
    }
  }
}
