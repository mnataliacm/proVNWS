package edu.fpdual.webservicevn.model.dao;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@Builder

public class Usuario {
  private Integer id;
  private String nom;
  private String ape;
  private String pass;
  private String email;
  private String movil;
  private Integer idciu;

  public Usuario(ResultSet resultSet) throws SQLException {
    this.id = resultSet.getInt("IDusu");
    this.nom = resultSet.getString("NomUsu");
    this.ape = resultSet.getString("ApeUsu");
    this.pass = resultSet.getString("PassUsu");
    this.email = resultSet.getString("Email");
    this.movil = resultSet.getString("Movil");
    this.idciu = resultSet.getInt("IDciu");
  }
}
