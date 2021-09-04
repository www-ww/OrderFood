package com.edu.ww.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    private int	detailid;
    private int	orderid;
    private    int	foodid;
    private    int	number;

    public Detail(int orderid, int foodid, int number) {
        this.orderid = orderid;
        this.foodid = foodid;
        this.number = number;
    }
}
