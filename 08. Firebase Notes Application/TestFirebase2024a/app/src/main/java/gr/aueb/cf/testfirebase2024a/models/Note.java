package gr.aueb.cf.testfirebase2024a.models;

public class Note {
    private String id;
    private String title;
    private String description;
    private String backgroundColor;
    private String titleColor;
    private String descriptionColor;
    private String datestamp;

    public Note() {}

    public Note(String id, String title, String description, String backgroundColor, String titleColor, String descriptionColor, String datestamp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.titleColor = titleColor;
        this.descriptionColor = descriptionColor;
        this.datestamp = datestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }

    public String getDescriptionColor() {
        return descriptionColor;
    }

    public void setDescriptionColor(String descriptionColor) {
        this.descriptionColor = descriptionColor;
    }

    public String getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(String datestamp) {
        this.datestamp = datestamp;
    }
}
