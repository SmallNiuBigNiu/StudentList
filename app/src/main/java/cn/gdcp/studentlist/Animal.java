package cn.gdcp.studentlist;

import java.io.Serializable;

/**
 * Created by acer on 2018/10/9.
 */

public class Animal implements Serializable {
    private  String name;
    private int imageId;
    private int age;
    private int deleteId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public Animal(String name, int imageId, int age, int deleteId) {
        this.name = name;
        this.imageId = imageId;
        this.age = age;
        this.deleteId = deleteId;
    }
}
