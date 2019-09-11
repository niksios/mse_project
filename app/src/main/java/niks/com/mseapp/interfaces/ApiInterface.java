package niks.com.mseapp.interfaces;

import java.util.List;

import niks.com.mseapp.Album_Modal.Albums_Modal;
import niks.com.mseapp.Posts_Modal.Posts_Modal;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Balaji on 12/2/2017.
 */

public interface ApiInterface {


  String BASE_URL = "https://jsonplaceholder.typicode.com/";

  @GET("albums")
  Call<List<Albums_Modal>> getAlbums();

  @GET("posts")
  Call<List<Posts_Modal>> getPosts();

}
