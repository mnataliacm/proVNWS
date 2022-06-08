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

public class Ciudad {
  private Integer id;
  private String nom;

  public Ciudad(ResultSet resultSet) throws SQLException {
    this.id = resultSet.getInt("IDciu");
    this.nom = resultSet.getString("NomCiu");
  }
}
