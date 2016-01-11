package imageviewer.model;

public interface Image {
    public Object bitMap();
    public Image previous();
    public Image next();
}