package starwars;

/**
 *
 * @author sametsahin
 */
public class MasterYoda extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI 
            = "resources/masterYoda.jpg";
    
    private int can;

    public MasterYoda(int x, int y, boolean isActive) {
        super("Master Yoda", "iyi", KARAKTER_SIMGESI_DIZINI, x, y, isActive);
        can = 3;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }
}
