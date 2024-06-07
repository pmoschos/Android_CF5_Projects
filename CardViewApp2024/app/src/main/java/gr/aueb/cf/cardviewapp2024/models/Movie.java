package gr.aueb.cf.cardviewapp2024.models;

public class Movie {
    private String title;
    private String category;
    private int image;

    public Movie() {}

    public Movie(String title, String category, int image) {
        this.title = title;
        this.category = category;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
