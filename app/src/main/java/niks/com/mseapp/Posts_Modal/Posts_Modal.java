package niks.com.mseapp.Posts_Modal;

import com.google.gson.annotations.SerializedName;

public class Posts_Modal {

    @SerializedName("userId")
    String userId; //userId

    @SerializedName("id")
    String id; //id

    @SerializedName("title")
    String title; //title

    //body
    @SerializedName("body")
    String body; //title


    public Posts_Modal(String userId, String id, String title, String body ){

        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
