package starwars;

/**
 *
 * @author sametsahin
 */
public class LukeSkywalker extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI = "resources/upArrow";
    
    private int can;

    public LukeSkywalker(int x, int y) {
        super("Luke Skywalker", "iyi", KARAKTER_SIMGESI_DIZINI, x, y);
    }
    
}
