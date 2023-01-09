package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myedamam.R;
import java.util.ArrayList;

import models.RootObjectModel;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.FoodViewHolder> {
    private Context context;
    private ArrayList<RootObjectModel>recipes;

    public RecipeAdapter(Context context, ArrayList<RootObjectModel> recipes) {
        this.context = context;
        this.recipes = recipes;
    }

    public RecipeAdapter(String context) {

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_entries,parent, false);
        return new FoodViewHolder(view);

    }

    @Override
    public int getItemCount() {
        if (recipes != null){
            return recipes.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.label.setText("Label\t"+recipes.get(position).getRecipeModel().getLabel());
        holder.source.setText("Source\t"+recipes.get(position).getRecipeModel().getSource());
        holder.calories.setText("Calories\t"+recipes.get(position).getRecipeModel().getCalories());
        holder.totalNutrients.setText("totalNutrients\t"+recipes.get(position).getRecipeModel().getTotalNutrients());
        Glide.with(holder.itemView.getContext()).load(recipes.get(position).getRecipeModel().getImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);

    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView label, source, calories, totalNutrients;
        ImageView imageView;


        public FoodViewHolder (@NonNull View itemView) {

            super(itemView);
            label = itemView.findViewById(R.id.textView);
            source = itemView.findViewById(R.id.textView5);
            calories = itemView.findViewById(R.id.textView6);
            totalNutrients = itemView.findViewById(R.id.textView9);
            imageView = itemView.findViewById(R.id.recipeImg);

        }

    }
}
