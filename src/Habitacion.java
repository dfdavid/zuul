import java.util.HashMap;
import java.util.ArrayList;

/**
 * Clase Habitacion - Una habitacion en un juego de aventuras
 *
 * Esta clase es parte de la apliciaci�n "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Un objeto "Habitacion" representa una ubicaci�n en el juego. Las
 * habitaciones tienen salidas que conducen a otras habitaciones, indicadas
 * como norte, sur, este y oeste. Para cada direcci�n, una habitaci�n 
 * mantiene una referencia a la habitaci�n vecina, o null si no existe una
 * en es direcci�n.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Habitacion 
{
    private String descripcion;
    private HashMap<String, Habitacion> salidas;
    private ArrayList<Elemento> elementos;

    /**
     * Crea una habitaci�n descrita por "descripcion". 
     * Inicialmente, la habitaci�on no tiene salidas, "descripcion"
     * es algo asi como "una cocina" o "un patio".
     * 
     * @param descripcion La descripcion de la habitacion.
     */
    public Habitacion(String descripcion) 
    {
        this.descripcion = descripcion;
        salidas = new HashMap<String, Habitacion>();
        elementos = new ArrayList<Elemento>();
    }

    /**
     * Define las salidas de esta habitaci�n. Cada direcci�n conduce a
     * otra habitaci�n o bien es null (es decir, no hay salida).
     * @param la direccion.
     * @param la habitacion en esa direccion.
     */
    public void establecerSalida(String direccion, Habitacion habitacionALaQueSalgo) 
    {
        salidas.put(direccion, habitacionALaQueSalgo);
    }

    /**
    * @return La descripcion de la habitacion.
    */
    public String getDescripcion()
        {
            return descripcion;
    }
    
    /**
     * Devuelve la descripcion de la habitacion concatenado con una cadena con sus salidas.
     *
     * @return La descripcion como un String
     */
    public String getDescripcionLarga()
    {
        // put your code here
        return "Ud. esta en "+descripcion +".\n"+ "\n"+getStringObjetos()+"\n Salidas: " +imprimirSalidas();
    }

    
    /**
     * devuelve la habitacion a la que condude la salida que se pasa como parametro.
     *
     * @param  string direccion
     * @return la habitacion detras de la salida seleccionada si dicha salida existe, caso contrario devuelve null.
     */
    public Habitacion getSalida(String direccion)
    {
        return salidas.get(direccion);
    }
    
    /**
     * devuelve un string con las saldias de la habitacion
     * @return un string con las salidas de la habitacion 
     */
    public String imprimirSalidas()
    {   
        String aDevolver = "";
            for(String x: salidas.keySet()){
                aDevolver = aDevolver.concat(x+" ");
            } 
        
        return aDevolver;
        //viejo metodo de impresion de salidas
        /*
        if(salidas.containsKey("norte")){
            System.out.print("norte ");
        }
        if(salidas.containsKey("este") ){
            System.out.print("este ");
        }
        if(salidas.containsKey("sur")){
            System.out.print("sur ");
        }w
        if(salidas.containsKey("oeste") ){
            System.out.print("oeste ");
        }
        */
       
    }
    
    /**
     * Devuelve un elemento de la habitacion
     *
     * 
     * @return el elemento en el Array en la posicion index
     */
    public Elemento getElemento(int index)
    {
        return elementos.get(index);
               
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public ArrayList<Elemento> getListaElemntos()
    {
        ArrayList<Elemento> lista = elementos;
        return lista;
    }
    
    
    /**
     *  Crea un nuevo elemento y lo agrega al Array de elementos de la habitacion
     *  
     *  @param String descripcion, la descripcion de que elemento es
     *  @param int peso, el peso que tiene el elemento
     */
    public void agregarElemento(String descripcion, int peso, boolean comestible){
        Elemento e = new Elemento(descripcion, peso,comestible);
        elementos.add(e);
    }
    
    /**
     * Devuelve un ArrayList que contiene las descripciones de cada elemento de la habitacion           
     *
     * @return ArrayList<String> con las descripciones de los elementos
     */
    public ArrayList<String> getDescripcionElementos()
    {
        ArrayList<String> descripciones = new ArrayList<String>();
            for(Elemento e: elementos){
                descripciones.add(e.getDescripcion());
            }
        return descripciones;
    }
    
    /**
     * Devuelve un gran String con la descripcion de todos los objetos
     * @return  String descripcion de todos los objetos
     */
    public String getStringObjetos()
    {
        String aDevolver="";
        ArrayList<String> elementosQueHay = getDescripcionElementos();
        if(elementosQueHay.size()==0)
        {
            aDevolver = "En esta habitacion no hay nada";
        }
        else{
            aDevolver = aDevolver.concat("En esta habitacion hay: \n");
            for(String x: getDescripcionElementos()){
                aDevolver = aDevolver.concat(x+"\n");
            }      
        }
        
            
        return aDevolver;
    }

    public int  buscarElemento(String nombreElemento){
        int respuesta = -1;
        int i =0;
        while (i < elementos.size()){
            if(elementos.get(i).getDescripcion().equals(nombreElemento)){
                respuesta = i;
                break;
            }
            i++;
        }
        
        return respuesta;
    }
    
    public void removerElemento(int index){
        elementos.remove(index);
    }
}
