/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

/**
 *
 * @author martincantorurrego
 */
public interface MonitoriaRegistradaDAO {
    void registrarInicioMonitoriaDictada(int idMonitoria,String ip);
    void registrarFinMonitoria(int idMonitor);
}
