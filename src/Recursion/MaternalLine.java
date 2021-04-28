package Recursion;

public class MaternalLine {
    /**
     * Return a string representation of the maternal ancestor
     * n generations in the past
     * @param n n=1 -> mother n=2 -> grandmother
     * @return
     */
    static String maternalAncestor(int n){
        assert n>=1;//must have a maternal
        if(n==1){
            return "mother";
        }
        else if(n==2){//how to handle over than 2,3,4,5,therefore we need to recurse
            return  "grandmother";
        }
        //return "not sure yet";this is an one-by-one case
        return "great-" +maternalAncestor(n-1);//recursion
    }

    public static void main(String[] args) {
        System.out.println("My maternal ancestor order 1 is my "+ maternalAncestor(1));
        System.out.println("My maternal ancestor order 2 is my "+ maternalAncestor(2));
        System.out.println("My maternal ancestor order 3 is my "+ maternalAncestor(3));//recursion
        System.out.println("My maternal ancestor order 10 is my "+ maternalAncestor(10));//more number to test
        //recursion, using debug to test what happen in the recursion
    }



}
