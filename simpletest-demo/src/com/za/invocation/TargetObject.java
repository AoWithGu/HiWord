package com.za.invocation;

/**
 * @Author 张傲
 * @Description TODO
 * @Date 2023/3/26 16:32
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
