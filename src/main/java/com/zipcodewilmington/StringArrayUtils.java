package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int counter = 0;
        for (int i = 0; i < array.length ; i++) {
            if (value.equals(array[i])){
                counter++;
            }
        } return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] strArray = new String[array.length - 1]; // was able to use - 1 because there is only 1 value to be removed, not sure how to do the length of the array if more than 1 value to remove
        int counter = 0;
        for (int i = 0; i < array.length ; i++) {
            if (!valueToRemove.equals(array[i])){ //!= is the same as !parameter.equals()
              strArray[counter] = array[i];
              counter++;
            }
        } return strArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     * https://www.geeksforgeeks.org/for-each-loop-in-java/ resource used for how to write for each loops
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        List<String> words = new ArrayList<>(); // created new array list
        String previousElement = "";  // Created new string
        for (String element : array) { // Created for each loop. for every element in the array.
            if (!element.equals(previousElement)) { //if the current element is not equal to the last element populated in the words array list, then add the element to the words array list
                words.add(element); //
            }
            previousElement = element; // otherwise previous element is equal to current element
        }  return words.toArray(new String[0]); // returns the array list words, populated with only non duplicates
    }


    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        List<String> words = new ArrayList<>(); // created new arraylist called words
        StringBuilder current = new StringBuilder(array[0]); // created new stringbuilder at array index 0
        for (int i = 1; i < array.length; i++) {  // created for loop to loop through elements in array
            if (array[i].equals(array[i-1])) { // if current array element is equal to previous element...
                current.append(array[i]); // append the element to the current String builder, with .append concatenating them
            } else { //otherwise
                words.add(current.toString()); // convert current elements to string and add to words array list. This adds to array list,but does not append them.
                current = new StringBuilder(array[i]); // created new stringbuilder at array index i, to account for everything after the first index
            }
        }
        words.add(current.toString()); //convert current elements to string and adds it to words array list. I need this here to account for the array[0] that is outside for loop

        return words.toArray(new String[0]); // converts words to array form an array list and returns words array
    }


}
/*
intellij suggested an enhanced for loop instead of the code below for duplicate method
for (int i = 0; i < array.length; i++){
            if(!array[i].equals(duplicate)) {
                duplicate = array[i];
                }
 for (int i = 0; i < array.length; i++)
            if (!array[i].equals(duplicate)) {
                strArray[j] = array[i];
                duplicate = array[i];
                j++;
            }                  
 */
