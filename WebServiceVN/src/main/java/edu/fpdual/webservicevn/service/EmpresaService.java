package edu.fpdual.webservicevn.service;

import edu.fpdual.webservicevn.model.connector.Connector;
import edu.fpdual.webservicevn.model.dao.Empresa;
import edu.fpdual.webservicevn.model.dao.Usuario;
import edu.fpdual.webservicevn.model.manager.implement.EmpresaManagerImpl;
import edu.fpdual.webservicevn.model.manager.implement.UsuarioManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class EmpresaService {
    private final EmpresaManagerImpl empresaManager;
    public EmpresaService(EmpresaManagerImpl empresaManager) {
        this.empresaManager = empresaManager;
    }

    public Set<Empresa> todasEmpresa() throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return empresaManager.todos(con);
        }
    }
    public Empresa buscaID(Integer idEmp) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return empresaManager.buscaID(con, idEmp);
        }
    }
    public boolean borrarEmpresa(Integer idEmp) throws SQLException, ClassNotFoundException {
        try (Connection con =new Connector().getConnection()) {
            return empresaManager.borrar(con, idEmp);
        }
    }
    public int crearEmpresa(Empresa empresa) throws SQLException, ClassNotFoundException {
        try (Connection con = new Connector().getConnection()) {
            return empresaManager.crear(con, empresa);
        }
    }
    public boolean modificarEmpresa(Empresa empresa) throws SQLException, ClassNotFoundException {
        try (Connection con =new Connector().getConnection()) {
            return empresaManager.modificar(con, empresa);
        }
    }



}
