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

public class Empresa {
  private int id;
  private String nom;

  public Empresa(ResultSet resultSet) {
    try {
      this.id = resultSet.getInt("IDemp");
      this.nom = resultSet.getString("NomEmp");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
