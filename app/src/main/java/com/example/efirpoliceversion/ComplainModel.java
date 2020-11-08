package com.example.efirpoliceversion;

public class ComplainModel {

    String name;
    String fatherName;
    String district;
    String type;
    String description;
    String status;

    public ComplainModel(String name,String fatherName,String district,String type,String description,String status){
        this.name = name;
        this.fatherName = fatherName;
        this.district = district;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    public static void createComplainList(int i) {
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getFatherName(){
        return fatherName;
    }
    public void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }

    public String getDistrict(){
        return district;
    }
    public void setDistrict(String type){
        this.district = district;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

}
