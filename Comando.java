/**
 * Esta clase es parte de la apliciacion "World of Zuul". 
 * "World of Zuul" es un juego de aventuras sencillo basado en texto.  
 *
 * Esta clase contiene informaci�n sobre los comandos que han sido editados
 * por el usuario.
 * Un comando consiste de dos cadenas: una palabra comando y una segunda 
 * palabra (por ejemplo, si el comando fue "tomar mapa", entonces las dos
 * palabras ser�n obviamente "tomar" y "mapa").
 * 
 * La forma en que esto se usa es: Comandos han sido verificados como
 * palabras comando. Si el usuario ingresa un comando invalido (una palabra 
 * desconocida) entonces la plabra comando es  <null>.
 *
 * Si el comando solo contiene una palabra, entonces la segunda palabra
 * es <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Comando
{
    private String primeraPalabra;
    private String segundaPalabra;

    /**
     * Crea un objecto comando. Debe proveerse una primera y una segunda palabra,
     * pero una (o ambas) pueden ser null
     * @param primerPalabra La primer palabra del comando. Null si el comando no
     * fue reconocido.
     * @param segundaPalabra La segunda palabra del comando.
     */
    public Comando(String primerPalabra, String segundaPalabra)
    {
        this.primeraPalabra = primerPalabra;
        this.segundaPalabra = segundaPalabra;
    }

    /**
     * Devuelve la plabara comando (la primer palabra) de este comando. Si
     * el comando no fue entendido, el resultado es null
     * @return La palabra comando.
     */
    public String getPrimeraPalabra()
    {
        return primeraPalabra;
    }

    /**
     * @return La segunda palabra de este comando. Devuelve null si no 
     * hay segunda palabra.
     */
    public String getSegundaPalabra()
    {
        return segundaPalabra;
    }

    /**
     * @return true si el comando no fue reconocido.
     */
    public boolean esDesconocido()
    {
        return (primeraPalabra == null);
    }

    /**
     * @return true si el comando tiene segunda palabra
     */
    public boolean tieneSegundaPalabra()
    {
        return (segundaPalabra != null);
    }
}

