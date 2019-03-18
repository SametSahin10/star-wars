package starwars;

/**
 *
 * @author sametsahin
 */
public class KyloRen extends Karakter{
    private static final String KARAKTER_SIMGESI_DIZINI 
            = "resources/kyloRen.png";

    public KyloRen(int x, int y, boolean isActive) {
        super("Kylo Ren", "kötü", KARAKTER_SIMGESI_DIZINI, x, y, isActive);
    }
    
    @Override
    public int[][] enKisaYol() {
        return super.enKisaYol();
    }
    
}
