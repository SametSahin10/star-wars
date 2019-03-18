package starwars;

import javax.swing.ImageIcon;

/**
 *
 * @author sametsahin
 */
public class Karakter {
    private String karakterAdi;
    private String karakterTuru;
    private Lokasyon lokasyon;
    private boolean isActive;
    
    private ImageIcon karakterSimgesi;
    
    public Karakter() {}
    
    public Karakter(String karakterAdi, 
            String karakterTuru, 
            String KARAKTER_SIMGESI_DIZINI,
            int x,
            int y, boolean isActive) {
        this.karakterAdi = karakterAdi;
        this.karakterTuru = karakterTuru;
        this.lokasyon = new Lokasyon(x, y);
        this.isActive = isActive;
        this.karakterSimgesi = new ImageIcon(KARAKTER_SIMGESI_DIZINI);
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

    public int[][] enKisaYol() {
        return null;
    }

    public Lokasyon getLokasyon() {
        return lokasyon;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ImageIcon getKarakterSimgesi() {
        return karakterSimgesi;
    }
    
}
