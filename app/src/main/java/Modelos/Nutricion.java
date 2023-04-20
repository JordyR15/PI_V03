package Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Nutricion {
    private String id;
    private String nombre;
    private String imagen;
    private int calorias;
    private int grasas;
    private int proteinas;
    private int carbohidratos;

    private String fecha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(int carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

  /*  private String id;
    private String nombre;
    private String imagen;
    private int calorias;
    private int grasas;
    private int proteinas;
    private int carbohidratos;

   */

    public Nutricion(JSONObject a) throws JSONException {
        nombre =  a.getString("Name").toString();
        imagen =  "";
    }

    public static ArrayList<Nutricion> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Nutricion> nutricion = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            nutricion.add(new Nutricion(datos.getJSONObject(i)));
        }
        return nutricion;
    }

}
