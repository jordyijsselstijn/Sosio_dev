package nl.jordyijsselstijn.sosio_dev;

/**
 * Created by jordyijsselstijn on 03-04-16.
 */
public class Challenge {

    private int id;
    private int imagePath;
    private String title;
    private String description;
    private String points;


    public Challenge(int id, int imagePath, String title, String description, String points){

        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.description = description;
        this.points = points;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
