package Recursion;
/**
 * This is to use test, the test process contains 'red','green', 'refactor'
 * steps for test: 1. Create test that defines new requirement.
 * 2. 'red' Ensure fails, because the test codes are build when the program does not have code, if tests run correct,
 * it will mean the tests are not to test the target codes but having other meaning in the test.
 * 3. Write code to support the requirement
 * 4. Run tests to ensure code is correct
 * 5. 'Refactor' imporve code
 * 6. Repeat
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSort {

    public static int[] mergeSort(int[] unsorted){//von Neumann 1945, the implementing mergesort method(google search)
        if(unsorted.length<=1){//one element does not need to be sort, and empty one cannot be sorted
            return unsorted;
        }

        //split the list into two sublist and sort them
        var size = unsorted.length;
        var leftSize = size/2;//two same scale lists
        var rightSize = size - leftSize;
        var left = new int[leftSize];
        System.arraycopy(unsorted,0,left,0,leftSize);//copy the left list, from position 0 to position leftSize
        // of unsorted int[], to left int [], position 0 to leftSize.
        var right = new int[rightSize];
        System.arraycopy(unsorted,leftSize,right,0,rightSize);

        var sortedLeft  = mergeSort(left);//recursion by this mergeSort method, keep splitting the sublist to sublist
        var sortedRight = mergeSort(right);

        //merge the sorted sublist
        var result = new int[unsorted.length];
        int l = 0;//point to the first element position of sortedLeft [] above
        int r = 0;//point to the first element position of sortedRight [] above
        int idx = 0;//using in the result(output) elements

        while(l<sortedLeft.length||r< sortedRight.length){
            if (r>= sortedRight.length||(l<sortedLeft.length && sortedLeft[l]<sortedRight[r])){//this number is sorted, this is for one time split for the unsorted int[], therefore we need a while loop
                result[idx++] = sortedLeft[l++];//check each element in the left list, move idx as well
            }else {
                result[idx++] = sortedRight[r++];//right number is smaller than left
            }
        }
        return  result;
    }
    @Test
    public void testSort(){// configure the test junit 5.40, first open file( top right of corner), then open 'Project structure'
        //open 'library', click '+', input 'org.junit.jupiter', find Junit 5.40, install, change test to compile(IntelliJ will configure it automatically) '@Test' will run correct
        int [] unsorted = {16,1,12,43,41,0,19,25};
        int [] sorted = {0,1,12,16,19,25,41,43};
        Assertions.assertArrayEquals(sorted, mergeSort(unsorted));//import static org.junit.jupiter.api.Assertions.assertEquals;
    }
}
