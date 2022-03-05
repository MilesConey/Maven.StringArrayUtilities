package com.zipcodewilmington;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        if (array.length >= 1) { // checking that there is at least one or more elements in the array.
        return array[0]; //if true, return first element of array. I couldve just returned this line, but in case i am given an empty array, i am taking into account that it would return null
        } else {
            return null; // returns null when first statement is false because there are no elements in the array
        }
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        if(array.length >=1){
        return array[1];
        }
        else {
          return null;
        }
    }

    /**
     * @param array array of String objects // I want to get last element of array. Can use index
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
//        int lastElement = array.length - 1;
        return array[array.length - 1]; // array. length - 1 will give me the last index in the array by taking the length of the array and subtracting 1. An alternative return could be return array[lastElement];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) { //is checking entire array (by looping through the array) for value. If the array contains the value, it will return true. Otherwise false. originally had array[i] == value but intelliJ suggested the switch to .equals
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        //array =["momo", "einstein","Miles", "Tati"] =4
//                 0          1        2       3
    //strArray = ["tati", "miles", "einstein", "momo"]=4
//                   0        1        2          3
        String[] strArray = new String[array.length]; //creating new array of strings that has the same length as the original string so that all elements of the original can be reversed in the new string array
        int counter = 0;
        for (int i = array.length - 1; i >= 0; i--) { //for loop runs backwards because we are reversing the array, for instance, the last element in the original array, will be looped through first and the first element in the array will be last.
             strArray[counter] = array [i]; // this is setting the strArray = to array[i] so that they loop together, in opposite directions, which allow the array to be reversed
             counter++; // incrementing the strArray
        }
        return strArray; // returning the reversed array
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        // array = ["hannah"]
        String[] strArray = reverse(array);

        return Arrays.equals(strArray, array);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     * https://www.baeldung.com/java-string-contains-all-letters- used this resource
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String pangramic = Arrays.toString(array);
        return pangramic.toLowerCase()
                .replaceAll("[^a-z]", "")
                .replaceAll("(.)(?=.*\\1)", "")
                .length() == 26;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        return 0;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        return null;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        return null;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        return null;
    }


}
