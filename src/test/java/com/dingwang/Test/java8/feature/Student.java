/*
 * Copyright 2016 Zhongan.com All right reserved. This software is the
 * confidential and proprietary information of Zhongan.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Zhongan.com.
 */
package com.dingwang.Test.java8.feature;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 类Student.java的实现描述：TODO 类实现描述
 * 
 * @author dingwang 2016年1月13日 上午11:21:23
 */
public class Student {

    private String name;

    private int    age;

    private String sex;

    public Student() {
        this.name = "dw";
        this.age = 12;
        this.sex = "男";
    }

    public Student update(Student student, Predicate<Student> predicate, Consumer<Student> consumer) {
        if (predicate.test(student)) {
            consumer.accept(student);
        }
        return student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }

    public static void main(String[] args) {

        Student s = new Student();
        System.out.println(s);

        s = s.update(s, student -> student.name == "dw", student -> student.name = "dingwang");
        System.out.println(s);

        System.out.println((4 >> 1));
    }

}
