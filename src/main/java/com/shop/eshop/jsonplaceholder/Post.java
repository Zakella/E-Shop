package com.shop.eshop.jsonplaceholder;

import lombok.Data;

@Data
public class Post {
    private final Integer userID;
    private final Integer id;
    private final String title;
    private final String body;

}
