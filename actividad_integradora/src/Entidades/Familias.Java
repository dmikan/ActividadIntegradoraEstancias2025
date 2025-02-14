package Entidades;


public class Familias {
    private int id;
    private String nombre;
    private int edad_minima;
    private int edad_maxima;
    private int num_hijos;
    private String email;
    private int id_casa_familia;

    

    public Familias(int id, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email, int id_casa_familia) {
        this.id = id;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
    }



    public Familias(String nombre, int edad_minima, int edad_maxima, int num_hijos, String email, int id_casa_familia) {
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
    }



    public Familias() {
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getEdad_minima() {
        return edad_minima;
    }



    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }



    public int getEdad_maxima() {
        return edad_maxima;
    }



    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }



    public int getNum_hijos() {
        return num_hijos;
    }



    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public int getId_casa_familia() {
        return id_casa_familia;
    }



    public void setId_casa_familia(int id_casa_familia) {
        this.id_casa_familia = id_casa_familia;
    }

    

}