package ImageModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeModel {
    private String label;
    private String image;
    private String source;
    private float calories;
    private float totalNutrients;
    @SerializedName("image")
    @Expose
    private RootImageModel rootImageModel;

    public RecipeModel(){
        new RecipeModel(label, image, source, calories, totalNutrients, rootImageModel);
    }

    public RecipeModel(String label, String image, String source, float calories, float totalNutrients, RootImageModel rootImageModel) {
        this.label = label;
        this.image = image;
        this.source = source;
        this.calories = calories;
        this.totalNutrients = totalNutrients;
        this.rootImageModel = rootImageModel;
    }

    public String getLabel() {
        return label;
    }

    public String getImage() {
        return image;
    }

    public String getSource() {
        return source;
    }

    public float getCalories() {
        return calories;
    }

    public float getTotalNutrients() {
        return totalNutrients;
    }

    public RootImageModel getRootImageModel() {
        return rootImageModel;
    }
}





