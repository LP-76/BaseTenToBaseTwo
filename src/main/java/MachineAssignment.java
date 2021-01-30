import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Program takes in command-line arguments and converts them from base ten to base two.
 *
 * 1) To run this program, compile the files using javac MachineAssignment.java
 * 2) Then run "java MachineAssignment value value value"
 *
 */

public class MachineAssignment {

    public static void main(String[] args) {

        prettyPrint(Convert(args), args);
    }

    /**
     *
     *  Function converts Base 10 to Base 2 by taking the value passed, multiplying by by two.
     *  If the currentDouble is less then 1, we add a 0 to result. If the currentDouble is greater than or equal to 1, we add a 1 to result.
     *
     * @param list - array of base 10 numbers.
     * @return - ArrayList of base 2 numbers
     */
    private static ArrayList<String> Convert(String[] list){

        int fractionalLength =  8;
        ArrayList<String> data = new ArrayList<>();
        String result = "0.";
        double[] doubleArray = Arrays.stream(list).mapToDouble(Double::parseDouble).toArray(); //converting String Array to Double Array

        for (int i = 0; i < doubleArray.length; i++) {

            double currentDouble = doubleArray[i];

            while ( result.length() != fractionalLength ){

                currentDouble *= 2;

                if (currentDouble < 1 ){
                    result += "0";
                } else if (currentDouble >= 1 ){
                    result += "1";
                    currentDouble -= 1;
                }
            }
            data.add(result);

            result = "0.";
        }
        return data;
    }

    /**
     * Prints out the results displaying base 10 and base 2 side by side.
     *
     * @param baseTen - ArrayList of base ten
     * @param baseTwo - Array of base two
     */
    private static void prettyPrint(ArrayList<String> baseTen, String[] baseTwo){

        System.out.println("|\tBase 10\t|\tBase 2\t|\n| :--------\t| :--------\t|");

        for (int i = 0; i < baseTen.size(); i++) {
            System.out.printf("|%20s\t|%n", baseTwo[i] + "\t| " + baseTen.get(i)  );
        }
    }
}
