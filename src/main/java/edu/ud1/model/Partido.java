package edu.ud1.model;

import java.io.Serializable;



/**
 *
 * @author maria
 */
public class Partido implements Serializable {

    public static final String PARTIDO_TAG = "partido";
    public static final String PARTIDOS_TAG = "partidos";
    public static final String PARTIDO_VOTOS_NUM_TAG = "votos_numero";
    public static final String PARTIDO_VOTOS_PORC_TAG = "votos_porciento";
    public static final String PARTIDO_NOMBRE_TAG = "nombre";
    public static final String PARTIDO_ATT_ID = "id";
    
    private long id;
    private String nombre;
    private int votos;
    private float porcentaje;

    public Partido() {
    }
    
    

    public Partido(long id, String nombre, int votos, float porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.votos = votos;
        this.porcentaje = porcentaje;
    }
      public Partido( String nombre, int votos, float porcentaje) {
      
        this.nombre = nombre;
        this.votos = votos;
        this.porcentaje = porcentaje;
    }

    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    
    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Partido{" + "id=" + id + ", nombre=" + nombre + ", votos=" + votos + ", porcentaje=" + porcentaje + '}';
    }
    
    
    
}
