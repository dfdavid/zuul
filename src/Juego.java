/**
 *  Es la clase principal del programa "World of Zuul". 
 *  "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *  Los usuarios pueden caminar en algun escenario, eso es todo. Puede 
 *  extenderse para hacerlo bastante m�s interesante.
 *  
 *  Para jugar a este juego, crear una instancia de esta clase y llamar
 *  al m�todo "jugar".
 * 
 *  Esta clase crea e inicializa a todas las otras: crea todas las habitaciones,
 *  crea el analizador e incia el juego. Adem�s evalua y ejecuta los comandos
 *  que el analizador devuelve.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Juego 
{
    private Analizador analizador;
    private Jugador jugador;
    //private Habitacion habitacionActual;
    //private Habitacion habitacionAnterior;
        
    /**
     * Crea el juego e inicializa el mapa interno.
     */
    public Juego() 
    {
        crearJugador();
        crearHabitaciones();
        analizador = new Analizador();
    }

    /**
     * Crea todas las habitaciones y relaciona todas sus salidas.
     */
    private void crearHabitaciones()
    {
        Habitacion exterior, teatro, bar, laboratorio, oficina, trastero, pasadizo, cocina, patioSO, sotanoTeatro, segundoSubsueloT;
        
        
        // crea las habitaciones
        exterior = new Habitacion("el exterior de la entrada principal a la universidad");
        teatro = new Habitacion("en el anfiteatro");
        bar = new Habitacion("en el bar del campus");
        laboratorio = new Habitacion("en el laboratorio de computacion");
        oficina = new Habitacion("en la oficina del director de computacion");
        trastero = new Habitacion("en el trastero del rincon del edificio");
        pasadizo = new Habitacion("en el pasadizo que une el trastero con la cocina");
        cocina = new Habitacion("en la cocina del bar de la facultad. Aqui se preparan los sanguchitos");
        patioSO = new Habitacion("en el patio contiguo al aula de computacion. Aca vienen las chicas en los recreos :) ");
        sotanoTeatro = new Habitacion("en el sotano del teatro");
        segundoSubsueloT = new Habitacion("en el segundo subsuelo del Teatro. Brrrr, que lugar aterrador...");
        
        // inicializa las salidas de las habitaciones
        cocina.establecerSalida("sur", bar);
        cocina.establecerSalida("este", pasadizo);
        cocina.agregarElemento("Sanguchitos_de_miga", 300, true);
        cocina.agregarElemento("Licuadora", 1500, false);
        pasadizo.establecerSalida("oeste", cocina);
        pasadizo.establecerSalida("este", trastero);
        trastero.establecerSalida("oeste", pasadizo);
        trastero.establecerSalida("sur", teatro);
        trastero.agregarElemento("Lingote_de_Oro", 5000, false);
        teatro.establecerSalida("norte", trastero);
        teatro.establecerSalida("oeste", exterior);
        teatro.establecerSalida("abajo", sotanoTeatro);
        exterior.establecerSalida("este", teatro);
        exterior.establecerSalida("sur", laboratorio);
        exterior.establecerSalida("oeste", bar);
        bar.establecerSalida("norte", cocina);
        bar.establecerSalida("este", exterior);
        bar.establecerSalida("sur", patioSO);
        bar.agregarElemento("Mesa", 5000, false);
        bar.agregarElemento("Sanguche_mordido", 50, true);
        bar.agregarElemento("Cubiertos_de_plastico", 150, false);
        bar.agregarElemento("Vaso_de_plastico", 50, false);
        patioSO.establecerSalida("norte", bar);
        patioSO.establecerSalida("este", laboratorio);
        laboratorio.establecerSalida("oeste", patioSO);
        laboratorio.establecerSalida("norte", exterior);
        laboratorio.establecerSalida("este", oficina);
        laboratorio.agregarElemento("Libro", 200, false);
        oficina.establecerSalida("oeste", laboratorio);
        sotanoTeatro.establecerSalida("arriba", teatro);

        //habitacionActual = exterior;  // el juego arranca desde afuera
        jugador.setHabitacionActual(exterior);
        
    }

    /**
     * Rutina principal para jugar. Ciclo que se ejecuta hasta que se 
     * termine de jugar
     */
    public void jugar() 
    {            
        imprimirBienvenida();

        // Entra en el ciclo principal. Ac� leemos repetidamente
        // los comandos y se los ejecuta hasta que termine el juego.
                
        boolean finalizado = false;
        while (! finalizado) {
            Comando comando = analizador.getComando();
            finalizado = procesarComando(comando);
        }
        System.out.println("Gracias por jugar. Hasta pronto.");
    }

    /**
     * Imprime el mensaje de apertura para el jugador
     */
    private void imprimirBienvenida()
    {
        System.out.println();
        System.out.println("Bienvenido a Zuul-badibial!");
        System.out.println("es un nuevo " +
                "juego de aventuras en la facu!.");
        System.out.println("Escriba 'ayuda' cuando la necesite.");
        System.out.println();
        //llamo al metodo que imprime la info de la habitacion actual
        imprimirInfoDeHabitacion();
        
    }

    /**
     * Dado un comando, procesar (esto es: ejecutar) el comando.
     * @param comando El comando a ser procesado.
     * @return true si el comando finaliza el juego, false caso contrario
     */
    private boolean procesarComando(Comando comando) 
    {
        boolean quiereSalir = false;

        if(comando.esDesconocido()) {
            System.out.println("No entiendo lo que quieres decir...");
            return false;
        }

        String palabraComando = comando.getPrimeraPalabra();
        if (palabraComando.equals("ayuda"))
            imprimirAyuda();
        else if (palabraComando.equals("ir"))
            irAHabitacion(comando);
        else if (palabraComando.equals("tomar"))
            jugador.tomarElemento(comando);    
        else if (palabraComando.equals("dejar"))
            jugador.dejarElemento(comando);
        else if (palabraComando.equals("salir"))
            quiereSalir = salir(comando);
        else if(palabraComando.equals("ver")){
            System.out.println(jugador.getHabitacionActual().getDescripcionLarga());
        }
        else if (palabraComando.equals("comer")){
           jugador.comer(comando.getSegundaPalabra());
        }
        else if (palabraComando.equals("putear")){
            System.out.println("La reputa madre que te pario!");
        }
        else if(palabraComando.equals("volver")){
            volver();
        }
        else if(palabraComando.equals("inventario")){
            jugador.inventario();
        }
        
        return quiereSalir;
    }

    // implementacion de los comandos:

    /**
     * Imprime informacion de ayuda.
     * Aqui imprimimos alguos mensajes estupidos y cripticos y una
     * lista de las palabras comando.
     */
    private void imprimirAyuda() 
    {
        System.out.println("Estas perdido. Estas solo. Deambulas");
        System.out.println("alrededor de la universidad.");
        System.out.println();
        System.out.println("Tus palabras comando son:");
        System.out.println(analizador.getComandos());
        ;
    }

    /** 
     * Tratar de ir en otra direcci�n. Si existe una salida,
     * entra en la nueva habitaci�n, en caso contrario imprime
     * un mensaje de error.
     */
    private void irAHabitacion(Comando comando) 
    {
        if(!comando.tieneSegundaPalabra()) {
            // si no hay segunda palabra no sabemos a donde ir...
            System.out.println("¿A donde queres ir?");
            return;
        }

        String direccion = comando.getSegundaPalabra();

        // Tratar de salir de la habitaci�n actual
        Habitacion siguienteHabitacion = null;
        
        //nueva implementacion que me permite ir en otras direcciones para salir de la habitacion actual
        //habitacionActual.getSalida();
        
        
        //vieja implementacion del cambio de habitacion con solo 4 habitaciones
        
        if(direccion.equals("norte")) {
            //habitacionAnterior = habitacionActual;
            //siguienteHabitacion = habitacionActual.getSalida("norte");
            jugador.setHabitacionSiguiente(jugador.getHabitacionActual().getSalida("norte"));
        }
        if(direccion.equals("este")) {
            //habitacionAnterior = habitacionActual;
            //siguienteHabitacion = habitacionActual.getSalida("este");
            jugador.setHabitacionSiguiente(jugador.getHabitacionActual().getSalida("este"));
        }
        if(direccion.equals("sur")) {
            //habitacionAnterior = habitacionActual;
            //siguienteHabitacion = habitacionActual.getSalida("sur");
            jugador.setHabitacionSiguiente(jugador.getHabitacionActual().getSalida("sur"));
        }
        if(direccion.equals("oeste")) {
            //habitacionAnterior = habitacionActual;
            //siguienteHabitacion = habitacionActual.getSalida("oeste");
            jugador.setHabitacionSiguiente(jugador.getHabitacionActual().getSalida("oeste"));
        }
        if(direccion.equals("abajo")){
            //habitacionAnterior = habitacionActual;
            //siguienteHabitacion = habitacionActual.getSalida(direccion);
            jugador.setHabitacionSiguiente(jugador.getHabitacionActual().getSalida("abajo"));
        }
         if(direccion.equals("arriba")){
            //habitacionAnterior = habitacionActual;
            //siguienteHabitacion = habitacionActual.getSalida(direccion);
            jugador.setHabitacionSiguiente(jugador.getHabitacionActual().getSalida("arriba"));
        }
        
        if (jugador.getHabitacionSiguiente() == null) {
            System.out.println("No hay ninguna puerta!");
        }
        else {
            //habitacionActual = siguienteHabitacion;
            jugador.setHabitacionActual(jugador.getHabitacionSiguiente());
            
            //llamar a un metodo que imprima informacion
            imprimirInfoDeHabitacion();
           
        }
    }
    
    /**
     * permite volver a la habitacion anterior desde la cual el jugador venia
     */
    private void volver()
    {
        //habitacionActual = habitacionAnterior;
        jugador.setHabitacionActual(jugador.getHabitacionAnterior());
        
        imprimirInfoDeHabitacion();
    }


    /** 
     * Se ingres� "salir". Verificar el resto de los comandos
     * para saber si realmente queremos salir del juego.
     * @return true, si el comando finaliza el juego, false en caso contrario.
     */
    private boolean salir(Comando comando) 
    {
        if(comando.tieneSegundaPalabra()) {
            System.out.println("salir de d�nde?");
            return false;
        }
        else {
            return true;  //se�al de que queremos salir del juego
        }
    }

    /**
     * Imprime informacion sobre las salidas que tiene la habitacion actual
     * 
     */
    private void imprimirInfoDeHabitacion()
    {
        // nuevo metodo para imprimir la informacion de la habitacion actual y sus salidas
        System.out.println(jugador.getHabitacionActual().getDescripcionLarga());
        
        //viejo metodo para imprimir la informacion de la habitacion y las salidas
        /*        *
        System.out.println("Usted esta en " + habitacionActual.getDescripcion());
        System.out.print("Salidas: ");
        habitacionActual.imprimirSalidas();
        System.out.println();
        System.out.println("chinguenguencha");
        */
    }

    /**
     *  Inicializa un jugador para el juego
     */
    private void crearJugador()
    {
        // put your code here
        jugador = new Jugador("player1", 3000);
    }

    

}
