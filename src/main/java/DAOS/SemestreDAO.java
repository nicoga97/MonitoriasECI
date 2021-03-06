package DAOS;

import Modelo.Semestre;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author 666 Industries
 */
public interface SemestreDAO {   
    
    /**
     * Retorne el semestre
     * @param id Id del semestre
     * @return Semestre
     */
    Semestre loadSemestre(int id);
    
    /**
     * retorna el semestre actual
     * @return Semestre actual
     */
    Semestre loadSemestreActual();
    
    /**
     * retorna todos los semestres que han sido creados
     * @return Todos los semestres
     */
    List<Semestre> loadSemestres();
    
    /**
     * Carga el semestre anterior
     * @return Semestre anterior
     */
    Semestre loadSemestreAnterior();
    
    /**
     * Crea un semestre
     * @param ano Año
     * @param periodoAcademico Periodo academico, solo puede ser 1, 2 o I
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de finalizacion
     */
    void crearSemestre(int ano, char periodoAcademico, Date fechaInicio, Date fechaFin);
    
    /**
     * Modifca un semestre
     * @param IDnumero ID del semestre
     * @param ano Año Del semestre
     * @param periodo Periodo Academico del semestre
     * @param fechaInicio Fecha de Inicio del semestre
     * @param fechaFin Fecha de Fin del semestre
     */
    void modificarSemestre(int IDnumero, Integer ano, Character periodo, Date fechaInicio, Date fechaFin);
    
    /**
     * Elimina un semestre
     * @param IDnumero ID del semestre 
     */
    void eliminarSemestre(int IDnumero);
}
