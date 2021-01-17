

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HabitacionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HabitacionTest
{
    private Habitacion habitaci1;
    private Jugador jugador1;
    private Comando comando1;

    

    /**
     * Default constructor for test class HabitacionTest
     */
    public HabitacionTest()
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
        jugador1.tomarElemento(comando1);
        assertEquals(habitaci1.buscarElemento("perfume"), -1);
        
    }
}

