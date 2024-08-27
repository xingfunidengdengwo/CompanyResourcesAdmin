package com.admin.bean;

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

    public String getEmailVcode() {
        return emailVcode;
    }

    public void setEmailVcode(String emailVcode) {
        this.emailVcode = emailVcode;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOriginalPassword() {
        return originalPassword;
    }

    public void setOriginalPassword(String originalPassword) {
        this.originalPassword = originalPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getImg() {
        return img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
