package edu.fpdual.webservicevn;

import edu.fpdual.webservicevn.model.connector.Connector;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    Connector connector = new Connector();
    Connection con = connector.getConnection();
    System.out.println(con.getCatalog());



  }
}
