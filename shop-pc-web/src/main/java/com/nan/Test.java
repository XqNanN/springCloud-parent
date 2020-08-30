package com.nan;

public class Test {
    public static void main(String[] args) {
        System.out.println( test("abcdef"));

    }


    public static String test(String str){
       String ssss= str==null|| str.length()<2?
                str:test(str.substring(1))+str.charAt(0);

        System.out.println(ssss);
        return  ssss;

    }
}
