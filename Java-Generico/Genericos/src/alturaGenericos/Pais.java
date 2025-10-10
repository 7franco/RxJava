package alturaGenericos;

import java.util.Objects;

/**
 * Representa el pais 
 */
public class Pais implements Comparable<Pais>{

    private String nombre;
    private String continente;
    private double altura;
    
    /**
     * Este es el constructor del pais 
     * @param nombre
     * @param continente
     * @param altura
     */
    public Pais(String nombre, String continente, double altura) {
        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public int compareTo(Pais o){
        return this.nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "Pais [nombre=" + nombre + ", continente=" + continente + ", altura=" + altura + "]";
    }

    
            
    
}

