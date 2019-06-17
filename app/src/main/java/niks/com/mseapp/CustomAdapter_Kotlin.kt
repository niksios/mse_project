package niks.com.mseapp

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import niks.com.mseapp.Album_Modal.Albums_Modal

class CustomAdapter_Kotlin(private val context: Activity, private val imageModelArrayList: List<Albums_Modal>) : BaseAdapter() {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView

        if (convertView == null) {

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.custom_list, null, true)

            val txt_userID = convertView!!.findViewById<View>(R.id.txt_userID) as TextView
            val txt_ID = convertView!!.findViewById<View>(R.id.txt_ID) as TextView
            val txt_title = convertView!!.findViewById<View>(R.id.txt_title) as TextView


            txt_userID.text = imageModelArrayList.get(position).userId
            txt_ID.text = imageModelArrayList.get(position).id
            txt_title.text = imageModelArrayList.get(position).title


            return convertView




        }

            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItem(position: Int): Any {

        return position
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {

        imageModelArrayList.size

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

