package com.edu.ww.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complain {
    private int	id;
    private    int	orderid;
    private int	userid;
    private    String	call;
    private    String	text;
    private    String	state;

    public Complain(int orderid, int userid, String call, String text) {
        this.orderid = orderid;
        this.userid = userid;
        this.call = call;
        this.text = text;
    }
}
