package nl.jordyijsselstijn.sosio_dev;

/**
 * Created by jordyijsselstijn on 29-03-16.
 */
public class Event {

    private int id;
    private String title;
    private int imagePath;
    private boolean favorited;


    public Event(int id, String title, int imagePath, boolean favorited){

        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.favorited = favorited;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }
}
