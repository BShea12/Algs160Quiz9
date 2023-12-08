import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    int holdMax = 0;
    int holdMin = 0;
    for(int i = 0; i<5;i++){
        if(arr.get(i) > arr.get(holdMax)){
            holdMax = i;
        }
        if(arr.get(i) < arr.get(holdMin)){
            holdMin = i;
        }
    }
    long totalMax = 0;
    long totalMin = 0;
    for(int i = 0; i< 5; i++) {
        if(i != holdMax){
            totalMin += arr.get(i);
        }
        if(i != holdMin){
            totalMax += arr.get(i);
        }
    }
    System.out.println(totalMin + " " + totalMax);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
