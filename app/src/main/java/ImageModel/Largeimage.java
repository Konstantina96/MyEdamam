package ImageModel;

public class Largeimage {
    private String url;
    private int width;
    private int height;

    public Largeimage(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
