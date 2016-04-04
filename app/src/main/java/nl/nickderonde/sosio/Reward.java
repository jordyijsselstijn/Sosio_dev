package nl.nickderonde.sosio;

/**
 * Created by jordyijsselstijn on 03-04-16.
 */
public class Reward {
    private String title;
    private String location;
    private String cost;
    private int imagePath;

    public Reward (String title, String location, String cost, int imagePath){
        this.title = title;
        this.location = location;
        this.cost = cost;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

}
