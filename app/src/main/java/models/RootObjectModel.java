package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ImageModel.RecipeModel;

public class RootObjectModel {
    @SerializedName("recipe")
    @Expose
    private RecipeModel recipeModel;

    public RecipeModel getRecipeModel() {
        return recipeModel;
    }

    public void setRecipeModel(RecipeModel recipeModel) {
        this.recipeModel = recipeModel;
    }

    public RootObjectModel(RecipeModel recipeModel) {
        this.recipeModel = recipeModel;

    }
}
