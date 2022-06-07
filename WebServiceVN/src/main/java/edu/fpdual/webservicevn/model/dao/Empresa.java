package edu.fpdual.webservicevn.model.dao;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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
