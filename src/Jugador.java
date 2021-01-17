import java.util.ArrayList;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private String nombreJugador;
    private int maxPesoSoportado;
    private int pesoCargadoActual;
    ArrayList<Elemento> elementosDelJugador;
    private Habitacion habitacionAnterior;
    private Habitacion habitacionActual;
    private Habitacion habitacionSiguiente;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre, int maxObjetos)
    {
        // initialise instance variables
        nombreJugador = nombre;
        maxPesoSoportado = maxObjetos;
        pesoCargadoActual = 0;
        //me haria falta un array o algo para almacenar elementos
        elementosDelJugador = new ArrayList<Elemento>();
        habitacionActual = null;
        habitacionAnterior = null;
    }

    /**
     * 
     */
    public String getNombreJugador()
    {
        // put your code here
        return nombreJugador;
    }
    
    /**
     * 
     */
    public void setNombreJugador(String nombreJugador)
    {
        // put your code here
        this.nombreJugador = nombreJugador;
    }
    
    /**
     *  Permite setear la cant maxima de objetos que puede llevar el jugador
     */
    public int getmaxPesoSoportado(){
        return maxPesoSoportado;
    }
    
    /**
     *  Permite modificar la capcidad maxima de objetos
     */
    public void setmaxPesoSoportado(int capacidad){
        maxPesoSoportado = capacidad;
    }
    
    /**
     * 
     */
    public Habitacion getHabitacionActual(){
        return habitacionActual;
    }
    
    /**
     * 
     */
    public void setHabitacionActual(Habitacion nuevaHabitacion){
        habitacionAnterior = habitacionActual;
        habitacionActual = nuevaHabitacion;
    }
    
    /**
     * 
     */
    public Habitacion getHabitacionSiguiente(){
        return habitacionSiguiente;
    
    }
    
     /**
     * 
     */
    public void setHabitacionSiguiente(Habitacion nuevaHabitacion){
        
        habitacionSiguiente = nuevaHabitacion;
    }
    
    /**
     * 
     */
     public Habitacion getHabitacionAnterior(){
        return habitacionAnterior;
    }
    
    /**
     *  Toma un elemento de la habitacion actual
     */
    public boolean tomarElemento(Comando comando){
        //System.out.println("uy si, mira como tomo");
        
        int index = habitacionActual.buscarElemento(comando.getSegundaPalabra());
        
        if(index != -1){ //entra si el elemento existe en la habitacion
            int capacidadDeCarga = maxPesoSoportado - pesoCargadoActual;
            Elemento e = habitacionActual.getElemento(index);
            
            if(e.getPeso() <= capacidadDeCarga){ //toma el elemento si la capacidad de carga restante es suficiente
                elementosDelJugador.add(e);
                pesoCargadoActual += e.getPeso();
                habitacionActual.removerElemento(index);
                return true;
            }
            else {
                System.out.println("Es demasiado peso, no puedo llevarlo en este momento...");
                return false;
            }
            
            
        }
        else{
            return false;
        }
    }
    
    /**
     *  Deja un elemento del inventario en la habitacion actual
     * 
     */
    public void dejarElemento(Comando comando){
        System.out.println("uy si, mira como dejo");
        
        String nombreElemento = comando.getSegundaPalabra();
        int indexElementoJugador = buscarElemento(nombreElemento);
        if(indexElementoJugador != -1){
            String nombre = elementosDelJugador.get(indexElementoJugador).getDescripcion();
            int peso = elementosDelJugador.get(indexElementoJugador).getPeso();
            boolean comestible = elementosDelJugador.get(indexElementoJugador).getComestible();
            
            habitacionActual.agregarElemento(nombre, peso, comestible);
            elementosDelJugador.remove(indexElementoJugador);
        }
        
    }
    
    /**
     *  busca en en el arrayList de elementosDelJugador si el elemnto esta
     *  @param String nombre del elemento buscado
     *  @return -1 si no esta el elemento, un valor de indice del array si el elemento esta
     */
    public int buscarElemento(String nombreElemento){
        int index;
        int cantidadApariciones = 0;
        int tamArray = elementosDelJugador.size();
        
        for(index = 0 ; index < tamArray; index++){
            if(elementosDelJugador.get(index).getDescripcion().equals(nombreElemento)){
                cantidadApariciones++;
            }
        }
        
        int respuesta = -1;
        if(cantidadApariciones != 0){
            for(index = 0 ; index < tamArray; index++){
                if(elementosDelJugador.get(index).getDescripcion().equals(nombreElemento)){
                    respuesta = index;
                    break;
                }
            }
        }
        return respuesta;
    }
    
    /**
     *  Imprime en terminal una lista de nombres de los elementos que tiene el jugador en su poder
     */
    public void inventario(){
        //todo
        int cantElementos = elementosDelJugador.size();
        if(cantElementos ==0){
            System.out.println();
            System.out.println("No tengo ningun objeto en mi poder...");
        }
        else{
            System.out.println();
            System.out.println("Items en el inventario: ");
            for(Elemento elem: elementosDelJugador){
                System.out.println(elem.getDescripcion() +", Peso: "+elem.getPeso() );
            }
        }
        
    }
    
    /**
     * 
     */
    public void comer(String nombreElemento){
        
        if(nombreElemento != null){
            
            int index = buscarElemento(nombreElemento); //buscar el elemento en el inventario
            //chequear si es comestible
            
            if(index != -1){
                boolean comestible = elementosDelJugador.get(index).getComestible();
                if(comestible){
                    pesoCargadoActual -= elementosDelJugador.get(index).getPeso();
                    elementosDelJugador.remove(index);
                    
                    if(nombreElemento.equals("Sanguchitos_de_miga")){
                        maxPesoSoportado = 5000;
                        System.out.println();
                        System.out.println("He recuperado mucha energia!");
                        System.out.println("siento que puedo transportar mas peso....");
                    }
                }
            }
            
            
        }
        else{
            System.out.println("comer que?!!");
        }
    }
}
