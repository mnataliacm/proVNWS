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
  private Integer id;
  private String nom;

  public Ciudad(ResultSet resultSet) throws SQLException {
    this.id = resultSet.getInt("IDciu");
    this.nom = resultSet.getString("NomCiu");
  }
}
