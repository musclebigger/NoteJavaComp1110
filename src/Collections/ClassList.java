package Collections;

import java.util.*;

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
        List<COMP1110Student> studentList1 = new ArrayList<>();//other way add all elements to list
        studentList1.addAll(Arrays.asList(studentArray));

        /*
        for(var student: studentList){
            System.out.println(student);
        }
         */
        var newArray = studentList.toArray(new COMP1110Student[studentList.size()]);//a new array
        System.out.println("Are studentArray and newArray the same? " + (studentArray==newArray));
        System.out.println("Do studentArray and newAarray refer to same objects? "+ Arrays.equals(studentArray,newArray));//check whether two arrays are equal

        COMP1110Student thirdStudent = studentList.get(2);
        System.out.println(thirdStudent);
        studentList.add(3, new COMP1110Student("Wancheng",28,"u6810586",5,17,4,5,4,69));
        //studentList.remove(5);
        for (var student: studentList
             ) {
            System.out.println(student);
        }


        //set for collection
        Set<COMP1110Student> studentSet = new HashSet<>();
        studentSet.add(studentList.get(0));
        boolean added = studentSet.add(studentList.get(1));
        System.out.println("Added Josh? "+added);
        added = studentSet.add(studentList.get(1));//add function return is boolean
        System.out.println("Added Josh? "+added);//false
        //try add same element twice,it should be neglected

        System.out.println("Element of studentSet");
        for (var student: studentSet
        ) {
            System.out.println(student);
        }

        boolean isBobInSet = studentSet.contains(studentList.get(2));// check elements in list
        System.out.println("is Bob in set? " + isBobInSet);

        /**
         * Map
         */

        Map<String, COMP1110Student> uidMap = new HashMap<>();
        for(var student: studentArray){
            uidMap.put(student.getUid(),student);
        }

        uidMap.remove("u6678901");//remove key
        uidMap.put("u6810586", new COMP1110Student("Wancheng Fu",28,"u6810586",5,15,5,4,4,40));

        System.out.println("Keys of uidMap:");
        for (var uid: uidMap.keySet()){
            System.out.println(uid);
        }

        System.out.println("Values of uidMap:");
        for (var student: uidMap.values()){
            System.out.println(student);
        }


        /**
         * Sort
         */
        System.out.println("Sorted studentlist");//sort based on name of student(getName())
        //Collections.sort(studentList,(s1,s2)->s1.getName().compareTo(s2.getName())); this is used when the class does not implement from Comparable<COMP1110Student>
        Collections.sort(studentList);//this is class implement from comparable
        for(var student: studentList){
            System.out.println(student);
        }



    }




}
