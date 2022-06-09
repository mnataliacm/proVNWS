package edu.fpdual.webservicevn;

import edu.fpdual.webservicevn.controller.UsuarioController;
import edu.fpdual.webservicevn.model.connector.Connector;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    Connector connector = new Connector();
    Connection con = connector.getConnection();
    System.out.println(con.getCatalog());

    //System.out.println(new UsuarioController().todosUsuarios().getLength());
   // System.out.println(new UsuarioController().todosUsuarios());
    //System.out.println(new UsuarioController().buscaID(Integer.valueOf(3)));

    System.out.println(new UsuarioController().buscaNombre("Admin"));


  }
}
