package com.east.demo.other.usage.advanced.serializable;

import com.east.demo.other.model.advanced.serializable.ClassWithSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author: east
 * @date: 2023/10/24
 */

public class SerializableUsage {
    /**
     * 序列化相关操作
     */
    public void testSerializable() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("ClassWithSerializable.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            ClassWithSerializable classWithSerializable = new ClassWithSerializable("name", "age");
            objectOutputStream.writeObject(classWithSerializable);
            System.out.println("write done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDeSerializable() {
        try (FileInputStream fileInputStream = new FileInputStream("ClassWithSerializable.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {

            ClassWithSerializable o = (ClassWithSerializable) objectInputStream.readObject();
            System.out.println("read done");
            System.out.println(o.getName() + ", " + o.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SerializableUsage serializableUsage = new SerializableUsage();
        serializableUsage.testDeSerializable();
    }
}
