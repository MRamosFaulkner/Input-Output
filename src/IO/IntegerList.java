package IO;

import java.io.*;
import java.util.*;

public class IntegerList {
    public static void main(String[] args) {

        try {
            List<Integer> int1 = readIntsFromFile("src/NIO/input1.txt");
            List<Integer> int2 = readIntsFromFile("src/NIO/input2.txt");

            List<Integer> mergedFiles = mergeLists(int1, int2);
            writeIntsToNewFile(mergedFiles, "src/NIO/merged.txt");

            List<Integer> commonInts = findsCommonInts(int1, int2);
            writeIntsToNewFile(commonInts, "src/NIO/common.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("List of Integers 1");


    }

    private static List<Integer> readIntsFromFile(String fileName) throws IOException {
        List<Integer> numbers = new ArrayList<>();//Creates a new list and stores the numbers read from the list

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;//New var that will store each line read
            while ((line = reader.readLine()) != null) { //Loops until all lines are read via readLine and puts it in line
                int number = Integer.parseInt(line);
                numbers.add(number);
            }

            return numbers;
        }
    }

    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) { //Returns the merge list
        List<Integer> mergedLists = new ArrayList<>();//Creates new var to hold merged ints

        mergedLists.addAll(list1);
        mergedLists.addAll(list2);

        return mergedLists;
    }

    private static List<Integer> findsCommonInts(List<Integer> list1, List<Integer> list2) { //Returns ints found in both list
        List<Integer> commonInts = new ArrayList<>();

        for (Integer number : list1) {
            if (list2.contains(number)) {
                commonInts.add(number);
            }
        }

        return commonInts;
    }

//        HashSet<Integer> set1 = new HashSet<>(list1);
//        HashSet<Integer> set2 = new HashSet<>(list2);
//
//        set1.retainAll(set2);
//
//        return new ArrayList<>(set1);
//    }

    private static void writeIntsToNewFile(List<Integer> numbers, String fileName) throws IOException {

           FileWriter fileWriter = new FileWriter(fileName);
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

           for (Integer number : numbers) {
               bufferedWriter.write(number.toString());
               bufferedWriter.newLine();
           }

           bufferedWriter.close();

    }

}

