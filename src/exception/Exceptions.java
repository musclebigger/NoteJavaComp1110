package exception;

import java.util.Date;

public class Exceptions {
    /**
     * Example 1: 方法内可以用的部分被运行，当main停止
     *
     */
    static class myException extends Exception{
    }

    private static void exceptionalMethod(){
        System.out.println("start");

        Date d = null;
        try {
            System.out.println(d.toString());
            int x = 7 / 0;//problem
            System.out.println(x);//打印不出来
        }catch (ArithmeticException e){
            System.out.println("problem"+e+"stack trace");
            e.printStackTrace(System.out);
        }catch (Exception e){
            System.out.println("there");
        }
        finally {
            System.out.println("do it anyway");
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        System.out.println("main start");
        exceptionalMethod();
}}
