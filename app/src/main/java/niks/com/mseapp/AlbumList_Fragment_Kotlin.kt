package niks.com.mseapp

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast

import java.util.Collections
import java.util.Comparator

import niks.com.mseapp.Album_Modal.Albums_Modal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumList_Fragment_Kotlin : Fragment() {


   // internal var listview: ListView
   //List view to show data
   private var ListView: ListView? = null

   private var progressBar: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //This layout contains your list view
        val view = inflater.inflate(R.layout.activity_main2, container, false)

        //now you must initialize your list view
        ListView = view.findViewById<View>(R.id.listViewHeroes) as ListView


        //call the albums list from the URL using Retrofit
        getAlbums()

        return view
    }


    private fun showProgress() {

        progressBar = ProgressDialog(activity)
        progressBar!!.setCancelable(false)//you can cancel it by pressing back button
        progressBar!!.setMessage("Fetching albums..")
        progressBar!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressBar!!.show()//displays the progress bar


    }

    private fun getAlbums() {

        showProgress()

        val retrofit = Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build()

        val api = retrofit.create(ApiInterface::class.java)

        val call = api.albums

        call.enqueue(object : Callback<List<Albums_Modal>> {
            override fun onResponse(call: Call<List<Albums_Modal>>, response: Response<List<Albums_Modal>>) {

                progressBar!!.dismiss()

                //getting the result from the API in json format
                val albumsList = response.body()

//                val id = arrayOfNulls<String>(albumsList!!.size)
//                val userID = arrayOfNulls<String>(albumsList.size)
//                val title = arrayOfNulls<String>(albumsList.size)

                val id = arrayOfNulls<String>(albumsList!!.size)
                val userID = arrayOfNulls<String>(albumsList.size)
                val title = arrayOfNulls<String>(albumsList.size)



                //looping through all the albums and inserting the columns data inside the string array
                if (albumsList != null) {
                    for (i in albumsList.indices) {

                        userID[i] = albumsList!![i].userId
                        id[i] = albumsList[i].id
                        title[i] = albumsList[i].title

                    }
                }


                //sort the title array alphabetically A-Z
                Collections.sort(albumsList, Comparator { o1, o2 ->
                    if (o1.title.compareTo(o2.title, ignoreCase = true) > 0) return@Comparator 1
                    if (o1.title.compareTo(o2.title, ignoreCase = true) < 0) -1 else 0
                })


                //sorted JSON array title alphabetically
                for (i in albumsList.indices) {

                    userID[i] = albumsList[i].userId
                    id[i] = albumsList[i].id
                    title[i] = albumsList[i].title
                }

                //design the custom list adapter and seetting the sorted array
                val ca = CustomAdapter(activity!!, userID, id, title)

                //setting adapter to list view
                ListView!!.adapter = ca


            }

            override fun onFailure(call: Call<List<Albums_Modal>>, t: Throwable) {

                progressBar!!.dismiss()
                Toast.makeText(activity, "Data Fetching Error..", Toast.LENGTH_SHORT).show()

            }
        })


    }//getAlbums


}
