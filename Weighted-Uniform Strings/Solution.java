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
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
    // Write your code here
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    HashMap<Character, Integer> letterToNum = new HashMap<Character,Integer>();
    for(int i = 0; i< 26; i++){
        letterToNum.put(alphabet.charAt(i),i+1);
    }
    ArrayList<Integer> arr = new ArrayList<Integer>();
    
    char current_char = s.charAt(0);
    int current_len = 1;
    arr.add(letterToNum.get(current_char));
    for(int i = 1; i<s.length();i++){
        if(s.charAt(i) == current_char){
            current_len++;
            arr.add(letterToNum.get(current_char) * current_len);
            
            
        }else{
            current_len = 1;
            current_char = s.charAt(i);
            arr.add(letterToNum.get(current_char));
        }
    }
    
    List<String> yesNo = new ArrayList<String>();
    for(Integer num: queries){
        if(arr.contains(num)){
            yesNo.add("Yes");
        }else{
            yesNo.add("No");
        }
    }
    return yesNo;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
