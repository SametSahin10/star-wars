package starwars;

/**
 *
 * @author sametsahin
 */
public class Stormtrooper extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI 
            = "resources/stormtrooper.png";

    public Stormtrooper(int x, int y, boolean isActive) {
        super("Stormtrooper", "kötü", KARAKTER_SIMGESI_DIZINI, x, y, isActive);
    }

    @Override
    public int[][] enKisaYol() {
        return super.enKisaYol();
    }
    
}
