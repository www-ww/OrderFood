package com.edu.ww.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
/*
用户类
 */
public class User {
     private Integer userid;
     private String  username;
     private String  password;
     private String  phone;
     private String  email;
     private String gender;
     private Integer score;
     private String vip;
     public User(String username, String password) {
          this.username = username;
          this.password = password;
     }
}
