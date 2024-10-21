package com.admin.bean;

import lombok.Data;

@Data
public class Operators {
    private Integer id;
    private String name;
    private String password;
    private String originalPassword;
    private String newPassword;
    private String img;
    private String email;
    private String emailVcode;

    @Override
    public String toString() {
        return "Operators{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", originalPassword='" + originalPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", img='" + img + '\'' +
                ", email='" + email + '\'' +
                ", emailVcode='" + emailVcode + '\'' +
                '}';
    }

}
