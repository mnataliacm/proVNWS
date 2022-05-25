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

public class Categoria {

  private int id;
  private String nom;
  private String imagen;

  public Categoria(ResultSet result) throws SQLException {
    setId(result.getInt("IDcat"));
    setNom(result.getString("NomCat"));
    setImagen(result.getString("Imagen"));
  }

}
