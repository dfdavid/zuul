
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
    boolean comestible;

    /**
     * Constructor for objects of class Elemento
     */
    public Elemento(String descripcion, int peso, boolean comestible)
    {
        this.descripcion = descripcion;
        this.peso = peso;
        this.comestible = comestible;
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
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public boolean getComestible()
    {
        // put your code here
        return comestible;
    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void setComestible(boolean nuevoValor)
    {
        // put your code here
        this.comestible = nuevoValor;
    }

}
