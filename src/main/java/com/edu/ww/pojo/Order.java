package com.edu.ww.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int	orderid;
private    int	userid;
private String	state;
private int	allprice;
private String	to;
private String time;

    public Order(int userid, String state, int allprice, String to, String time) {
        this.userid = userid;
        this.state = state;
        this.allprice = allprice;
        this.to = to;
        this.time = time;
    }
}
