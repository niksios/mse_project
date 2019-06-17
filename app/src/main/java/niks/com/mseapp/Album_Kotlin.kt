package niks.com.mseapp

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import niks.com.mseapp.Album_Modal.Albums_Modal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class Album_Kotlin : Fragment(){

    internal lateinit var listview: ListView

    private val progressBar: ProgressDialog? = null

    private var ca: CustomAdapter_Kotlin? = null

    private var imageModelArrayList: ArrayList<Albums_Modal>? = null




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.activity_main2, container, false)

        listview = view.findViewById<View>(R.id.listViewHeroes) as ListView

        //call the albums list from the URL using Retrofit
        getAlbums()


        return super.onCreateView(inflater, container, savedInstanceState)

    }




    private fun getAlbums() {



        val retrofit = Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build()

        val api = retrofit.create(ApiInterface::class.java)

        val call = api.albums

        call.enqueue(object : Callback<List<Albums_Modal>> {
            override fun onResponse(call: Call<List<Albums_Modal>>, response: Response<List<Albums_Modal>>) {


                //getting the result from the API in json format
                val albumsList = response.body()


                var id = arrayOf<String>()[albumsList!!.size]
                var userID = arrayOf<String>()[albumsList!!.size]
                var title = arrayOf<String>()[albumsList!!.size]


                //looping through all the albums and inserting the columns data inside the string array
                if (albumsList != null) {
                    for (i in albumsList.indices) {

                        userID = albumsList[i].userId
                        id = albumsList[i].id
                        title = albumsList[i].title
                    }
                }


                //sort the title array alphabetically A-Z
                Collections.sort(albumsList, Comparator { o1, o2 ->
                    if (o1.title.compareTo(o2.title, ignoreCase = true) > 0) return@Comparator 1
                    if (o1.title.compareTo(o2.title, ignoreCase = true) < 0) -1 else 0
                })


                //sorted JSON array title alphabetically
                if (albumsList != null) {
                    for (i in albumsList.indices) {

                        userID = albumsList[i].userId
                        id = albumsList[i].id
                        title = albumsList[i].title
                    }
                }

                //design the custom list adapter and seetting the sorted array
                ca = CustomAdapter_Kotlin(activity!!, albumsList!!)

                //setting adapter to list view
                listview.setAdapter(ca)


            }

            override fun onFailure(call: Call<List<Albums_Modal>>, t: Throwable) {

                Toast.makeText(activity, "Data Fetching Error..", Toast.LENGTH_SHORT).show()

            }
        })


    }//getAlbums


}