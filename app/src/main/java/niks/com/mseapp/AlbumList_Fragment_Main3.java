package niks.com.mseapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import niks.com.mseapp.Album_Modal.Albums_Modal;
import niks.com.mseapp.Posts_Modal.Posts_Modal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlbumList_Fragment_Main3 extends Fragment {


    ListView listview;

    CustomAdapter_Posts ca;


    private ProgressDialog progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //This layout contains your list view
        View view = inflater.inflate(R.layout.activity_main4, container, false);

        //now you must initialize your list view
        listview =(ListView)view.findViewById(R.id.listViewPost);


        //call the albums list from the URL using Retrofit
        getPosts();

        return view;
    }


    private void showProgress() {

        progressBar = new ProgressDialog(getActivity());
        progressBar.setCancelable(false);//you can cancel it by pressing back button
        progressBar.setMessage("Fetching albums..");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();//displays the progress bar


    }

    private void getPosts() {

        showProgress();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call<List<Posts_Modal>> call = api.getPosts();

        call.enqueue(new Callback<List<Posts_Modal>>() {
            @Override
            public void onResponse(Call<List<Posts_Modal>> call, Response<List<Posts_Modal>> response) {

                progressBar.dismiss();

                //getting the result from the API in json format
                List<Posts_Modal> albumsList = response.body();



                String[] id = new String[albumsList.size()];
                String[] userID = new String[albumsList.size()];
                String[] title = new String[albumsList.size()];
                String[] body = new String[albumsList.size()];


                //looping through all the albums and inserting the columns data inside the string array
                for (int i = 0; i < albumsList.size(); i++) {

                    userID[i] = albumsList.get(i).getUserId();
                    id[i] = albumsList.get(i).getId();
                    title[i] = albumsList.get(i).getTitle();
                    body[i] = albumsList.get(i).getBody();
                }


                //design the custom list adapter and seetting the sorted array
                ca = new CustomAdapter_Posts(getActivity(), userID, id, title, body);

                //setting adapter to list view
                listview.setAdapter(ca);


            }

            @Override
            public void onFailure(Call<List<Posts_Modal>> call, Throwable t) {

                progressBar.dismiss();
                Toast.makeText(getActivity(), "Data Fetching Error..", Toast.LENGTH_SHORT).show();

            }
        });


    }//getAlbums







}
