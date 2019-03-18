package starwars;

/**
 *
 * @author sametsahin
 */
public class LukeSkywalker extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI = 
            "resources/lukeSkywalker.png";
    
    private int can;
    private boolean isActive;

    public LukeSkywalker(int x, int y, boolean isActive) {
        super("Luke Skywalker", "iyi", KARAKTER_SIMGESI_DIZINI, x, y, isActive);
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
}
