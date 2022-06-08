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
