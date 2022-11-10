package com.iudigital.controller;

import com.iudigital.dao.FuncionariosDao;
import com.iudigital.dominio.Funcionarios;
import java.sql.SQLException;
import java.util.List;

public class FuncionariosController {
    
    private FuncionariosDao funcionariosDao;
    
    public FuncionariosController() {
        funcionariosDao = new FuncionariosDao();                                          
    }
    
    public void crearFuncionario (Funcionarios funcionario) throws SQLException {
        funcionariosDao.crearFuncionario(funcionario);
    }
    
    public List<Funcionarios> obtenerFuncionarios() throws SQLException {
        return funcionariosDao.obtenerFuncionarios();
    }
    
    public Funcionarios obtenerFuncionario(int iddoc) throws SQLException {
        return funcionariosDao.obtenerFuncionario(iddoc);
    }
    
    public void actualizarFuncionario(int iddoc, Funcionarios funcionario) throws SQLException {
        funcionariosDao.actualizarFuncionario(iddoc, funcionario);
    }
    
    public void eliminarFuncionario(int funcionarios_id) throws SQLException {
        funcionariosDao.eliminarFuncionario(funcionarios_id);
    }
}

