package starwars;

/**
 *
 * @author sametsahin
 */
public class Stormtrooper extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI = "resources/upArrow";

    public Stormtrooper(int x, int y) {
        super("Stormtrooper", "kötü", KARAKTER_SIMGESI_DIZINI, x, y);
    }

    @Override
    public int[][] enKisaYol() {
        return super.enKisaYol();
    }
    
}
