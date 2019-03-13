package starwars;

/**
 *
 * @author sametsahin
 */
public class DarthVader extends Karakter {
    private static final String KARAKTER_SIMGESI_DIZINI = 
            "resources/upArrow.png";

    public DarthVader(int x, int y) {
        super("Darth Vader", "kötü", KARAKTER_SIMGESI_DIZINI, x, y);
    }
    
    @Override
    public int[][] enKisaYol() {
        return super.enKisaYol();
    }
   
}
