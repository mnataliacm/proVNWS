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

public class Favoritos {

  private int idUsu;
  private int idCiu;

  public Favoritos(ResultSet result) throws SQLException {
    setIdUsu(result.getInt("IDusu"));
    setIdCiu(result.getInt("IDciu"));
  }
}
