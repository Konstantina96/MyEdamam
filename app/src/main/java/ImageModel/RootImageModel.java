package ImageModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RootImageModel {
    @SerializedName("LARGE")
    @Expose
    private Largeimage largeimage;
    @SerializedName("SMALL")
    @Expose
    private Smallimage smallimage;
    @SerializedName("REGULAR")
    @Expose
    private Regularimage regularimage;
    @SerializedName("THUMBNAIL")
    @Expose
    private Thumbnail thumbnail;

    public RootImageModel(Largeimage largeimage, Smallimage smallimage, Regularimage regularimage, Thumbnail thumbnail) {
        this.largeimage = largeimage;
        this.smallimage = smallimage;
        this.regularimage = regularimage;
        this.thumbnail = thumbnail;
    }

    public Largeimage getLargeimage() {
        return largeimage;
    }

    public Smallimage getSmallimage() {
        return smallimage;
    }

    public Regularimage getRegularimage() {
        return regularimage;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }
}
