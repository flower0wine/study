package designpattern.prototype;

import java.io.*;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Sheep implements Serializable, Cloneable {
    String name;
    int age;
    Student student;

    public Sheep(String name, int age, Student student) {
        this.name = name;
        this.age = age;
        this.student = student;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = (Sheep) super.clone();
        sheep.student = (Student) student.clone();
        return sheep;
    }

    public Sheep deepObject() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep sheep = (Sheep) ois.readObject();

        bos.close();
        oos.close();
        bis.close();
        ois.close();

        return sheep;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", student=" + student +
                '}';
    }
}
