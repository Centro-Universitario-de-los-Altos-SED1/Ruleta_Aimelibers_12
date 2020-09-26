/*
Datos de nuestro proyecto
 */
package ejercicio1;


/**
 *
 * @author Athziri
 */
public class Datos {
    String nombre;
    int numeroDeLista;
    boolean control; //Si ya participó se pone true para que no salga al generar random

    /**
     * Constructor con parámetros
     * @param nombre tipo String
     * @param numeroDeLista tipo entero
     * @param control tipo boleano
     */
    public Datos(String nombre, int numeroDeLista, boolean control) {
        this.nombre = nombre;
        this.numeroDeLista = numeroDeLista;
        this.control= control;
    }
    
    /**
     * Constructor vacío
     */
    public Datos() {
    }

    /**
     * Setter de Nombre
     * @param nombre tipo String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Setter del Número de lista
     * @param numeroDeLista tipo entero
     */
    public void setNumeroDeLista(int numeroDeLista) {
        this.numeroDeLista = numeroDeLista;
    }
    
    /**
     * Setter de Control
     * @param control tipo boleano
     */
    public void setControl(boolean control) {
        this.control = control;
    }

    /**
     * Getter de Nombre
     * @return tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de Número de Lista
     * @return tipo entero
     */
    public int getNumeroDeLista() {
        return numeroDeLista;
    }
    
    /**
     * Getter de Control
     * @return tipo boleano
     */
    public boolean isControl() {
        return control;
    }

}
