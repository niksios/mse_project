package niks.com.mseapp.fragments

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast

import niks.com.mseapp.interfaces.ApiInterface
import niks.com.mseapp.adapters.CustomAdapter_Posts
import niks.com.mseapp.Posts_Modal.Posts_Modal
import niks.com.mseapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumList_Fragment_Main3 : Fragment() {


    private var listview: ListView? = null

    private var ca: CustomAdapter_Posts? = null

    private var progressBar: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        //This layout contains your list view
        val view = inflater.inflate(R.layout.activity_main4, container, false)

        //now you must initialize your list view
        listview = view.findViewById<View>(R.id.listViewPost) as ListView


        //call the albums list from the URL using Retrofit
        getPosts()

        return view
    }


    private fun showProgress() {

        progressBar = ProgressDialog(activity)
        progressBar!!.setCancelable(false)//you can cancel it by pressing back button
        progressBar!!.setMessage("Fetching posts..")
        progressBar!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressBar!!.show()//displays the progress bar


    }

    private fun getPosts() {

        showProgress()

        val retrofit = Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build()

        val api = retrofit.create(ApiInterface::class.java)

        val call = api.posts

        call.enqueue(object : Callback<List<Posts_Modal>> {
            override fun onResponse(call: Call<List<Posts_Modal>>, response: Response<List<Posts_Modal>>) {

                progressBar!!.dismiss()

                //getting the result from the API in json format
                val albumsList = response.body()


                val id = arrayOfNulls<String>(albumsList!!.size)
                val userID = arrayOfNulls<String>(albumsList.size)
                val title = arrayOfNulls<String>(albumsList.size)
                val body = arrayOfNulls<String>(albumsList.size)


                //looping through all the albums and inserting the columns data inside the string array
                for (i in albumsList.indices) {

                    userID[i] = albumsList[i].userId
                    id[i] = albumsList[i].id
                    title[i] = albumsList[i].title
                    body[i] = albumsList[i].body
                }


                //design the custom list adapter and seetting the sorted array
                ca = CustomAdapter_Posts(activity!!, userID, id, title, body)

                //setting adapter to list view
                listview!!.adapter = ca


            }

            override fun onFailure(call: Call<List<Posts_Modal>>, t: Throwable) {

                progressBar!!.dismiss()
                Toast.makeText(activity, "Data Fetching Error..", Toast.LENGTH_SHORT).show()

            }
        })


    }//getAlbums


}
