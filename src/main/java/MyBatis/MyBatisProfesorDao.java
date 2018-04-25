/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyBatis;

import DAOS.ProfesorDAO;
import Mappers.ProfesorMapper;
import Modelo.Profesor;
import com.google.inject.Inject;

/**
 *
 * @author 2124519
 */
public class MyBatisProfesorDao implements ProfesorDAO{
    @Inject
    private ProfesorMapper profesorMapper;

    @Override
    public Profesor loadProfesor(int id) {
        return profesorMapper.loadProfesor(id);
    }
    
}
