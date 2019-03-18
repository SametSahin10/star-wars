package starwars;

/**
 *
 * @author sametsahin
 */
public class DarthVader extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI = 
            "resources/darthVader.png";

    public DarthVader(int x, int y, boolean isActive) {
        super("Darth Vader", "kötü", KARAKTER_SIMGESI_DIZINI, x, y, isActive);
    }
    
    @Override
    public int[][] enKisaYol() {
        return super.enKisaYol();
    }
   
}
