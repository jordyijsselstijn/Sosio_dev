package nl.jordyijsselstijn.sosio_dev;

/**
 * Created by jordyijsselstijn on 06-04-16.
 */
public class ChallengeInstruction {
    private String title;
    private String description;
    private int imagePath;

    public ChallengeInstruction(String title, String description, int imagePath){

        this.title = title;
        this.description = description;
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

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }
}
