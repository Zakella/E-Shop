package com.shop.eshop.jsonplaceholder;

public class Post {
    private final Integer userID;
    private final Integer id;
    private final Integer title;
    private final Integer body;

    public Post(Integer userID, Integer id, Integer title, Integer body) {
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

    public Integer getTitle() {
        return title;
    }

    public Integer getBody() {
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
