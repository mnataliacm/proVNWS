package edu.fpdual.webservicevn;

import edu.fpdual.webservicevn.controller.CiudadController;
import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.manager.implement.CiudadManagerImpl;
import edu.fpdual.webservicevn.service.CiudadService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


public class Main {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    Connector connector = new Connector();
    Connection con = connector.getConnection();
    System.out.println(con.getCatalog());


  }
}
