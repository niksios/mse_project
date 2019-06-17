package niks.com.mseapp.Album_Modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Albums_Modal {

    @SerializedName("userId")
    String userId; //userId

    @SerializedName("id")
    String id; //id

    @SerializedName("title")
    String title; //title


    public Albums_Modal(String userId, String id, String title){

        this.userId = userId;
        this.id = id;
        this.title = title;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
