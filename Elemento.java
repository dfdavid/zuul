
/**
 * Write a description of class Elemento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elemento
{
    String descripcion;
    int peso;

    /**
     * Constructor for objects of class Elemento
     */
    public Elemento(String descripcion, int peso)
    {
        this.descripcion = descripcion;
        this.peso = peso;
    }

    /**
     * asigna el peso al Alemento
     * 
     * @param  nuevo peso
     */
    public void setPeso(int peso)
    {
        // put your code here
        this.peso = peso;
    }
    
    /**
     * asigna el peso al Alemento
     * 
     * @param  nuevo peso
     */
    public void setDescripcion(String descripcion)
    {
        // put your code here
        this.descripcion = descripcion;
    }
    
    /**
     * obtiene la descripcion de elem
     */
    public String getDescripcion()
    {
        // put your code here
        return descripcion;
    }
    
    /**
     * asigna el peso al Alemento
     * 
     * @param  nuevo peso
     */
    public int getPeso()
    {
        // put your code here
        return peso;
    }

}
