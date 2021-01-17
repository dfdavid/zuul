

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JugadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class JugadorTest
{
    private Habitacion habitaci1;
    private Jugador jugador1;
    private Comando comando1;
    private Elemento elemento1;

    /**
     * Default constructor for test class JugadorTest
     */
    public JugadorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        habitaci1 = new Habitacion("pieza");
        habitaci1.agregarElemento("media", 100, false);
        habitaci1.agregarElemento("zapato", 250, false);
        habitaci1.agregarElemento("perfume", 100, false);
        jugador1 = new Jugador("player", 2000);
        jugador1.setHabitacionActual(habitaci1);
        comando1 = new Comando("tomar", "perfume");
        elemento1 = new Elemento("soga", 350, false);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void tomarElemento()
    {
        assertTrue(jugador1.tomarElemento(comando1));
    }

    @Test
    public void tomarElementoInexistente()
    {
        assertEquals(false, jugador1.tomarElemento(new Comando("tomar","soga")));
    }
    
    @Test
    public void buscarElementoInexistente()
    {
        assertEquals(-1, jugador1.buscarElemento("matafuego"));
    }
    
    @Test
    public void buscarElementoQueElJugadorTiene()
    {
        habitaci1.agregarElemento("soga",2000, false);
        jugador1.tomarElemento(new Comando("tomar","soga")); // a drede se pone el comando ir ya que no tiene importncia. Nadie valida la primera palabra en est
        assertEquals(0, jugador1.buscarElemento("soga"));
    }
}


