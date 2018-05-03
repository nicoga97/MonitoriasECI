/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyBatis;

import DAOS.AdministradorDAO;
import Mappers.AdministradorMapper;
import Modelo.Administrador;
import com.google.inject.Inject;

/**
 *
 * @author 2123162
 */
public class MyBatisAdministradorDao implements AdministradorDAO{

    @Inject
    AdministradorMapper administradorMapper;
    
    
    @Override
    public Administrador loadAdmin(int id, String psw) {
        return administradorMapper.loadAdmin(id, psw);
    }
    
}