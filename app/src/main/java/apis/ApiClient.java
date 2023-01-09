package apis;

import Response.SearchRecipes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
   @GET("https://api.edamam.com/api/recipes/v2")
   Call<SearchRecipes>searchRecipes(@Query("type") String type,
                                    @Query("q") String query,
                                    @Query("app_id") String idApp,
                                    @Query("app_key") String keyApp, String apiKey);
}
