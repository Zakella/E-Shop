package com.shop.eshop.jsonplaceholder;

public class Post {
    private final Integer userID;
    private final Integer id;
    private final String title;
    private final String body;

    public Post(Integer userID, Integer id, String title, String body) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserID() {
        return userID;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userID=" + userID +
                ", id=" + id +
                ", title=" + title +
                ", body=" + body +
                '}';
    }
}
