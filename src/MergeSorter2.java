import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import static java.lang.System.exit;

public class MergeSorter2 {
    private static void sort(List<String[]> input, int low, int high, String mode) {
        //in this example, we have 20 lines. Low index:0, high index: 19
        if (low < high) {

            int middle = (low + high) / 2; /* index of middle element */
            //left part
            sort(input, low, middle, mode);
            //right part
            sort(input, middle + 1, high, mode);

            merge(input, low, middle, high, mode);
        }
    }

    private static void merge(List<String[]> input, int low, int middle, int high, String mode) {
        int leftSize = middle - low + 1;
        int rightSize = high - middle;

        //initialize two lists for storing left part and right part
        List<String[]> leftList = new ArrayList<>(leftSize);
        List<String[]> rightList = new ArrayList<>(rightSize);
        //use for loop to copy elements from input to lists.
        for (int i = 0; i < leftSize; i++) {
            leftList.add(i, input.get(low + i));
        }
        for (int i = 0; i < rightSize; i++) {
            rightList.add(i, input.get(middle + 1 + i));
        }
        //mode count
        //merge
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = low;
        while (leftIndex < leftList.size() && rightIndex < rightList.size()) {
            switch (mode) {
                case "name":
                    // Sort by count logic
                    //use compare to compare the name
                    if (leftList.get(leftIndex)[0].compareTo(rightList.get(rightIndex)[0]) <= 0) {
                        input.set(mergeIndex, leftList.get(leftIndex));
                        leftIndex++;
                    } else {
                        input.set(mergeIndex, rightList.get(rightIndex));
                        rightIndex += 1;
                    }
                    mergeIndex++;
                    break;

                case "count":
                    //compare the value
                    if (Integer.parseInt(leftList.get(leftIndex)[1]) <= Integer.parseInt(rightList.get(rightIndex)[1])) {
                        input.set(mergeIndex, leftList.get(leftIndex));
                        leftIndex++;
                    } else {
                        input.set(mergeIndex, rightList.get(rightIndex));
                        rightIndex += 1;
                    }
                    mergeIndex++;
                    break;

                case "nameThenCount":
                    // Sort by name first, then count if names are the same
                    if (leftList.get(leftIndex)[0].compareTo(rightList.get(rightIndex)[0]) < 0) {
                        input.set(mergeIndex, leftList.get(leftIndex));
                        leftIndex++;
                    }//if the name are same, compare the value
                    else if (leftList.get(leftIndex)[0].compareTo(rightList.get(rightIndex)[0]) == 0) {
                        if (Integer.parseInt(leftList.get(leftIndex)[1]) <= Integer.parseInt(rightList.get(rightIndex)[1])) {
                            input.set(mergeIndex, leftList.get(leftIndex));
                            leftIndex++;
                        } else {
                            input.set(mergeIndex, rightList.get(rightIndex));
                            rightIndex += 1;
                        }
                    } else {
                        input.set(mergeIndex, rightList.get(rightIndex));
                        rightIndex += 1;
                    }
                    mergeIndex++;
                    break;

                case "countThenName":
                    // Sort by count first, then name if counts are the same
                    if (Integer.parseInt(leftList.get(leftIndex)[1]) < Integer.parseInt(rightList.get(rightIndex)[1])) {
                        input.set(mergeIndex, leftList.get(leftIndex));
                        leftIndex++;
                    } //if the value are same then compare the name
                    else if (Integer.parseInt(leftList.get(leftIndex)[1]) == Integer.parseInt(rightList.get(rightIndex)[1])) {
                        if (leftList.get(leftIndex)[0].compareTo(rightList.get(rightIndex)[0]) <= 0) {
                            input.set(mergeIndex, leftList.get(leftIndex));
                            leftIndex++;
                        } else {
                            input.set(mergeIndex, rightList.get(rightIndex));
                            rightIndex += 1;
                        }
                    } else {
                        input.set(mergeIndex, rightList.get(rightIndex));
                        rightIndex += 1;
                    }
                    mergeIndex++;
                    break;
            }

        }
        // collect remaining elements
        while (leftIndex < leftSize) {
            input.set(mergeIndex, leftList.get(leftIndex));
            leftIndex++;
            mergeIndex++;
        }
        while (rightIndex < rightSize) {
            input.set(mergeIndex, rightList.get(rightIndex));
            rightIndex++;
            mergeIndex++;
        }
    }

    public static void main(String[] args) throws Exception {
        //<input file> <number of entries> <mode> <output file>
        //--help

        /* If the number of command line parameters is incorrect or the user asks for help, the program must print:*/
        if (args.length != 4) {
            System.out.println("Usage: java Sorter <input file> <number of entries> <mode> <output file>");
            return;
        } else if (args.length == 1 && args[0].equals("--help")) {
            System.out.println("Usage: java Sorter <input file> <number of entries> <mode> <output file>");
            return;
        }
        //If the number of entries parameter is not positive, the program must print:
        if (Integer.parseInt(args[1]) < 0 || Integer.parseInt(args[1]) == 0) {
            System.out.println("ERROR: number of entries must be positive.");
            return;
        }
        //If the mode parameter is invalid, the program must print:
        if (!Objects.equals(args[2], "name") && !Objects.equals(args[2], "count") && !Objects.equals(args[2], "nameThenCount") && !Objects.equals(args[2], "countThenName")) {
            System.out.println("ERROR: mode must be name, count, nameThenCount, or countThenName.");
            return;
        }
        //read the file and create a list to store the textfile.
        File textFile = new File(args[0]);
        int count = Integer.parseInt(args[1]);
        String mode = String.valueOf(args[2]);

        List<String[]> inputList = new ArrayList<>();
        try (Scanner scanner = new Scanner(textFile)) {
            int linesRead = 0;
            while (scanner.hasNextLine() && linesRead < count) {
                String line = scanner.nextLine();
                String[] word = line.split(",");
                if (word.length == 2) {
                    String name = word[0];
                    String value = word[1];
                    inputList.add(new String[]{name, value});
                    linesRead++;
                }
            }

            MergeSorter2 object = new MergeSorter2();
            object.sort(inputList, 0, inputList.size() - 1, mode);

            //use write and split to generate an output file
            FileWriter writer = new FileWriter(args[3]);
            for (String[] split : inputList) {
                writer.write(split[0] + "," + split[1] + "\n");
            }
            writer.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: could not open input file");
        } catch (IOException e) {
            System.out.println("ERROR: could not generate output file");
        }

    }
}
