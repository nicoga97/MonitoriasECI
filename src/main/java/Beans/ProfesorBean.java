package Beans;
 

import Modelo.Asesoria;
import Modelo.Grupo;
import Modelo.Monitor;
import Modelo.Monitoria;
import Modelo.MonitoriaRegistrada;
import Modelo.Profesor;
import Modelo.Semestre;
import Servicios.Fabrica;
import Servicios.ServicioAsesoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import org.primefaces.omega.view.overlay.UserLoginView;

 

@ManagedBean(name = "Profesor")
@SessionScoped
public class ProfesorBean implements Serializable  {
    
    private ServicioAsesoria sa = Fabrica.getInstance().getServiciosAsesoria();
    
    private Profesor profesor;
    private Map<String,Grupo> grupos = new HashMap<>();
    private Map<String,String>gruposs = new HashMap<>();
    private Map<String,Monitoria> monitorias = new HashMap<>();
    private Map<String,String> monitoriass = new HashMap<>();
    private Map<String,MonitoriaRegistrada> monreg = new HashMap<>();
    private Map<String,String> monregs = new HashMap<>();
    private Grupo grupo;
    private String gruponame="";
    private Monitor monitor;
    private Monitoria mon;
    private MonitoriaRegistrada monr;
    private String nombrem="";
    private String nombremr="";  
    private String monrs="";
    private List<Asesoria> asesorias = new ArrayList<>();
    private int canmr=0;
    private int max=0;
    private int min=Integer.MAX_VALUE;
    private int prom=0;
    private int total=0;
    private float porcentaje=0;
    public Profesor getProfesor() {
        return profesor;
    }
 
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    public Map<String,String> getMonitorias(){
        //System.out.println(monitorias);
        return monitoriass;
    }
    public List<Asesoria> getAsesorias(){
        //System.out.println("ASESORIAS");
        return asesorias;
    }
    public void setMonitoria(String mo){
        //System.out.println("Setted0");
        this.mon=monitorias.get(mo);
        nombremr= this.mon.getDia();
        List<MonitoriaRegistrada> monre= sa.loadMonitoriasRegistradasPorMonitoria(mon.getIdMonitoria());
        //System.out.println("Setted");
        
        monr=null; 
        monrs="";
        for(int i=0;i<monre.size();i++){
            monreg.put(monre.get(i).getFechas(),monre.get(i));
            monregs.put(monre.get(i).getFechas(),monre.get(i).getFechas());
        }
    }
    public String getMonitoria(){
        return nombremr;
    }
    public Map<String,String> getMonitoriasr(){
        //System.out.println("MONITORIAS");
        return monregs;
    }
    public void setMonitoriar(String mo){
        this.monr=monreg.get(mo);
        monrs=monr.getFechas();
    }
    public String getMonitoriar(){
        return monrs;
    }
    public Map<String, String> getGrupos() {
        //System.out.println("LLAMADOG");
        return gruposs;
    }
    public void setGrupo(String name){
        //System.out.println("LLAMADOGS");
        this.gruponame=name;
        grupo=grupos.get(name);
        monitor=sa.loadMonitorPorGrupo(grupo.getIdGrupo());
        mon=null;
        monr=null;
        nombremr="";  
        monrs="";
        monitorias.clear();
        monitoriass.clear();
        monreg.clear();
        monregs.clear();
        nombrem=monitor.getNombre()+" "+monitor.getApellido();
        //System.out.println(monitor.getNombre()+" "+monitor.getApellido());
        
        //System.out.println("MONITORIAS SIZE="+grupo.getMonitorias().size());
        List<Monitoria> monitori=sa.loadMonitoriasPorGrupo(grupo.getIdGrupo());
        
        //System.out.println(monitori);
        for(int i=0;i<monitori.size();i++){
            monitorias.put(monitori.get(i).getDia(),monitori.get(i));
            monitoriass.put(monitori.get(i).getDia(),monitori.get(i).getDia());
        }
        //System.out.println("GRUPOOOO="+grupo);
    }
    public String getGrupo(){
        return gruponame;
    }

 
    public String getGrupoName(){
        return gruponame;
    }
    public void setGrupoName(String name){
            grupo=grupos.get(name);
        this.gruponame=name;
    }
 
    public String getNombrem(){
        
        return  nombrem;
    }
    
    public void refresh(){
        
        List<Grupo> gr =sa.loadGruposAsociadosProfesor(profesor.getId(),sa.loadSemestreActual().getNumero() );
       /* grupos.clear();
        gruposs.clear();
        monitorias.clear();
        monitoriass.clear();
        monreg.clear();
        monregs.clear();*/
        for(int i=0;i<gr.size();i++){
            grupos.put(gr.get(i).getCurso().getNombre()+""+gr.get(i).getNumero(),gr.get(i));
            gruposs.put(gr.get(i).getCurso().getNombre()+""+gr.get(i).getNumero(),gr.get(i).getCurso().getNombre()+""+gr.get(i).getNumero());
        }
        
        //System.out.println("LLENADO");
    }
    
    
    public void buscar(){
        //System.out.println("BUSCAR");
        //System.out.println("GRUPOOOOFINAL="+grupo);
        monitor=sa.loadMonitorPorGrupo(grupo.getIdGrupo());
        
        nombrem=monitor.getNombre()+" "+monitor.getApellido();
        //System.out.println(monitor.getNombre()+" "+monitor.getApellido());
        asesorias=sa.loadAsesoriasPorMonitoriaRegistrada(monr.getIdMonitoria());
        //System.out.println("MONITORIAS SIZE="+grupo.getMonitorias().size());
        //monitorias=sa.loadMonitoriasPorMonitor(monitor.getId());
                    //System.out.println("DIA"+mu.getDia()+" FIN"+mu.getHoraFin()+"INI"+mu.getHoraInicio()+"LUGAR"+mu.getLugar());
        }
        //System.out.println("LLENADO");
    
    
    
    public void moni(Monitoria mon){
        //System.out.println("ELEGIDA");
        this.mon=mon;
        //monreg= sa.loadMonitoriasRegistradasPorMonitoria(mon.getIdMonitoria());
        
    }
    
    
    public void aseso(MonitoriaRegistrada monreg){
        
        asesorias=sa.loadAsesoriasPorMonitoriaRegistrada(monreg.getIdMonitoria());

    }
    public void info(){
        monitor=sa.loadMonitorPorGrupo(grupo.getIdGrupo());
        
        nombrem=monitor.getNombre()+" "+monitor.getApellido();
        //System.out.println(monitor.getNombre()+" "+monitor.getApellido());
        List<MonitoriaRegistrada> mr=sa.loadMonitoriasRegistradasPorMonitoria(mon.getIdMonitoria());
        canmr=mr.size();
        
        max=0;
        min=Integer.MAX_VALUE;
        prom=0;
        int mtotal=0;
        for(int i=0;i<mr.size();i++){
            int value=sa.loadAsesoriasPorMonitoriaRegistrada(mr.get(i).getIdMonitoria()).size();
            mtotal+=value;
            prom+=value;
            if(value<min){
                min=value;
            }
            else if(value>max){
                max=value;
            }
        }
        prom=prom/mr.size();
        total=sa.loadAsesoriasPorGrupo(grupo.getIdGrupo()).size();
        System.out.println("ASESORIAS ="+sa.loadAsesoriasPorGrupo(grupo.getIdGrupo()));
        System.out.println("mtotal="+mtotal+" total="+total);
        porcentaje =(float) ((float)mtotal/(float)total)*100;
    }

    public int getCanmr() {
        return canmr;
    }

    public int getMax() {
        
        return max;
    }

    public int getMin() {
        int value=min;
        if(min==Integer.MAX_VALUE){
            value=0;
        }
        return value;
    }

    public int getProm() {
        return prom;
    }

    public void setCanmr(int canmr) {
        this.canmr = canmr;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setProm(int prom) {
        this.prom = prom;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}