package com.example.trytry;

public class post {
     String type,gender,pname,breed,desc;

     public post(){
     }

    public post(String type,String gender,String pname, String breed, String desc) {
         this.type=type;
        this.gender = gender;
        this.pname = pname;
        this.breed = breed;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
