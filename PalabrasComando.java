
/**
 * Esta clase es parte de la apliciacion "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Esta clase define todos los comandos v�lidos del juego mediante un 
 * arreglo de cadenas que contiene las palabras que se usar�n como
 * comandos
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class PalabrasComando
{
    // un arreglo que contiene las palabras comando
    private static final String[] comandosValidos = {
        "ir", "salir", "ayuda", "ver", "comer", "putear", "volver"
    };

    /**
     * Constructor - inicializa las palabras comando
     */
    public PalabrasComando()
    {
        // no hay nada que inicializar por el momento...
    }

    /**
     * Verifica si una cadena es una palabra comando v�lida 
     * @return true si la cadena es una palabra comando v�lida
     * false si no lo es.
     */
    public boolean esComando(String unaCadena)
    {
        for(int i = 0; i < comandosValidos.length; i++) {
            if(comandosValidos[i].equals(unaCadena))
                return true;
        }
        // si llegamos aqu�, la cadena no fue encontrada entre los comandos v�lidos
        return false;
    }
    
    /**
     * Imprime en la consola todas las palabras comando validas
     */
    public String  getPalabras()
    {
        String aDevolver = "";
        for(String x: comandosValidos){
            aDevolver = aDevolver.concat(x+" ");
        }
        return aDevolver;
    }

}
