package com.edu.ww.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private Integer foodid;
    private Integer  number;
    private Integer  price;
    private String  sort;
    private String  img;
    private String  storeid;
    private String foodname;

    public Food(Integer number, Integer price, String sort, String img, String storeid, String foodname) {
        this.number = number;
        this.price = price;
        this.sort = sort;
        this.img = img;
        this.storeid = storeid;
        this.foodname = foodname;
    }
}
