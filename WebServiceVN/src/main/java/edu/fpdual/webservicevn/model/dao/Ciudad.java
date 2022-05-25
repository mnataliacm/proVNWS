package edu.fpdual.webservicevn.model.dao;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Ciudad {

  private int id;
  private String nom;

  public Ciudad(ResultSet result) throws SQLException {
    setId(result.getInt("IDciu"));
    setNom(result.getString("NomCiu"));
  }
}
