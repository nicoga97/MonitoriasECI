package Modelo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 *Objeto de la monitoria registrada
 * @author 666 Industries
 */
public class MonitoriaRegistrada implements Serializable {
    private int idMonitoria;
    private String IP;
    private Time horaInicio;
    private Time horaFin;
    private Date fecha;
    private Monitoria monitoria;

    public MonitoriaRegistrada() {
    }

    public MonitoriaRegistrada(int idMonitoria, String IP, Time horaInicio, Time horaFin, Date fecha, Monitoria monitoria) {
        this.idMonitoria = idMonitoria;
        this.IP = IP;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fecha = fecha;
        this.monitoria = monitoria;
    }

    

    public int getIdMonitoria() {
        return idMonitoria;
    }

    public void setIdMonitoria(int idMonitoria) {
        this.idMonitoria = idMonitoria;
    }


    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getIp() {
        return IP;
    }

    public void setIp(String ip) {
        this.IP = ip;
    }
      public Date getFecha() {
        return fecha;
    }
          
    public String getFechas() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fechaComoCadena = sdf.format(fecha);
        return fechaComoCadena;
    }
      

    public void setFecha(Date Fecha) {
        this.fecha = Fecha;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Monitoria getMonitoria() {
        return monitoria;
    }

    public void setMonitoria(Monitoria monitoria) {
        this.monitoria = monitoria;
    }

    @Override
    public String toString() {
        return "MonitoriaRegistrada{" + "idMonitoria=" + idMonitoria + ", IP=" + IP + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", fecha=" + fecha + ", monitoria=" + monitoria + '}';
    }
    

    

    

    
}
