package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassList {
    public static void main(String[] args) {
        COMP1110Student studentArray[] = {
                new COMP1110Student("Mary", 19, "u2345678", 4, 15, 5, 4, 4, 70),
                new COMP1110Student("Josh", 40, "u6678901", 5, 17, 4, 5, 4, 69),
                new COMP1110Student("Bob", 20, "u3456789", 3, 16, 4, 5, 5, 75),
                new COMP1110Student("Ting", 21, "u4567890", 4, 14, 4, 4, 5, 90),
                new COMP1110Student("Vijay", 18, "u5678901", 5, 17, 4, 5, 4, 69),
        };

        //List<COMP1110Student> studentList = new ArrayList<>();
        /* This is normal one
        for(var student: studentArray){
            studentList.add(student);
        }
         */

        List<COMP1110Student> studentList = new ArrayList<>(Arrays.asList(studentArray));//easy way

        for(var student: studentList){
            System.out.println(student);
        }
        var newArray = studentList.toArray(new COMP1110Student[studentList.size()]);

        COMP1110Student thirdStudent = studentList.get(2);
        System.out.println(thirdStudent);
        studentList.add(3, new COMP1110Student("Wancheng",28,"u6810586",5,17,4,5,4,69));
        for (var student: studentList
             ) {
            System.out.println(student);
        }
    }
}
