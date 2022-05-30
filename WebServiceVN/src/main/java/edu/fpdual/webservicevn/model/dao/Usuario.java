package edu.fpdual.webservicevn.model.dao;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {
  private int id;
  private String nom;
  private String ape;
  private String pass;
  private String email;
  private String movil;
  public Usuario(ResultSet resultSet) {
    try {
      this.id = resultSet.getInt("IDusu");
      this.nom = resultSet.getString("NomUsu");
      this.ape = resultSet.getString("ApeUsu");
      this.pass = resultSet.getString("PassUsu");
      this.email = resultSet.getString("Email");
      this.movil = resultSet.getString("Movil");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
