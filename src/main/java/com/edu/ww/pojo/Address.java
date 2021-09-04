package com.edu.ww.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer id;
    private String address;
    private Integer userid;

    public Address(String address, Integer userid) {
        this.address = address;
        this.userid = userid;
    }
}
