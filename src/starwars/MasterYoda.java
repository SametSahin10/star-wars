package starwars;

/**
 *
 * @author sametsahin
 */
public class MasterYoda extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI 
            = "resources/upArrow.png";
    
    private int can;

    public MasterYoda(int x, int y) {
        super("Master Yoda", "iyi", KARAKTER_SIMGESI_DIZINI, x, y);
        can = 3;
    }
    
    
    
}
