package com.test.demo.test;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws Exception {
        B b = new B();

        A a = new A(10);

        b.setA(a);

//        Field declaredField = b.getClass().getDeclaredField("a");
//        declaredField.setAccessible(true);
//        Object object = declaredField.get(a);
//        System.out.println(object);

        Class<?> clazz = b.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(b);

            if(A.class == field.getType()){
                System.out.println("B Object fieldName : "+fieldName);
                System.out.println("B Object value: "+value);
                Object objectA = field.get(b);
                Field[] objectAfields = objectA.getClass().getDeclaredFields();
                for (Field aField : objectAfields){
                    aField.setAccessible(true);
                    String fieldNameA = aField.getName();
                    Object valueA = aField.get(a);
                    System.out.println("ObjectA fieldName : "+fieldNameA);
                    System.out.println("ObjectA value: "+valueA);
                }

            }else{
                System.out.println("B fieldName: "+fieldName);
                System.out.println("B value: "+value);
            }
        }

//        String[] split = "c.c1".split("\\.");
//        for (int i = 0; i < split.length; i++) {
//            Field field = object.getClass().getDeclaredField(split[i]);
//            field.setAccessible(true);
//            object = field.get(object);
//            System.out.println(field.getName() + "=" + object);
//        }
    }
}
