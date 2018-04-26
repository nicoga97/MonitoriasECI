/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martincantorurrego
 */
public class Profesor extends Persona implements Serializable{
    private int idProfesor;
    private String decanatura;
    private ArrayList<Grupo> grupos;

    public Profesor() {
    }

    public Profesor(int idProfesor, String decanatura, String nombre, String apellido, String correo, String contraseña) {
        super(idProfesor, nombre, apellido, correo, contraseña);
        this.idProfesor = idProfesor;
        this.decanatura = decanatura;
        this.grupos = null;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getDecanatura() {
        return decanatura;
    }

    public void setDecanatura(String decanatura) {
        this.decanatura = decanatura;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", decanatura=" + decanatura + ", grupos=" + grupos + '}';
    }

    
}
