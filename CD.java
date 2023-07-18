

public class CD extends Product {
    private String artist;

    public CD(String name, String artist, double price, int stock) {
        super(name, price, stock);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
