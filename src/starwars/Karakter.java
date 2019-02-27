package starwars;

/**
 *
 * @author sametsahin
 */
public class Karakter {
    private String karakterAdi;
    private String karakterTuru;
    private int x;
    private int y;

    public Karakter() {};
    
    public Karakter(String karakterAdi, String karakterTuru, int x, int y) {
        this.karakterAdi = karakterAdi;
        this.karakterTuru = karakterTuru;
        this.x = x;
        this.y = y;
    }

    public String getKarakterAdi() {
        return karakterAdi;
    }

    public void setKarakterAdi(String karakterAdi) {
        this.karakterAdi = karakterAdi;
    }

    public String getKarakterTuru() {
        return karakterTuru;
    }

    public void setKarakterTuru(String karakterTuru) {
        this.karakterTuru = karakterTuru;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int[][] enKisaYol() {
        return null;
    }
    
}
