package com.jdbc;

import java.util.Date;

// Students 对应 students表的记录
public class Students { //javabean POJO doMAIN
    private Integer id;
    private Integer age;
    private Integer class_id;
    private String  name;
    private String create_time;
//    private Date create_time;


    public Students() { // 反射需要
    }



    public Students(Integer id, Integer age, Integer class_id, String name, String create_time) {
        this.id = id;
        this.age = age;
        this.class_id = class_id;
        this.name = name;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", age=" + age +
                ", class_id=" + class_id +
                ", name='" + name + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
