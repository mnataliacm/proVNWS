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
  private Integer id;
  private String nom;
  private String imagen;

  public Categoria(ResultSet result) throws SQLException {
    this.id = result.getInt("IDcat");
    this.nom = result.getString("NomCat");
    this.imagen = result.getString("Imagen");
  }
}
