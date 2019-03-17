package starwars;

/**
 *
 * @author sametsahin
 */
public class KyloRen extends Karakter{
    private static final String KARAKTER_SIMGESI_DIZINI 
            = "resources/upArrow.png";

    public KyloRen(int x, int y) {
        super("Kylo Ren", "kötü", KARAKTER_SIMGESI_DIZINI, x, y);
    }
    
    @Override
    public int[][] enKisaYol() {
        return super.enKisaYol();
    }
    
}
