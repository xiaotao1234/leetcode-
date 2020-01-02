import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    List<String> list2 = new ArrayList<>();

    public static void main(String[] args) {
        电话号码的字母组合 s1 = new 电话号码的字母组合();
        s1.list2.add("abc");
        System.out.println(s1.letterCombinations1("23456"));
    }

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    public List<String> letterCombinations1(String digits) {
        if (digits.length() != 0) {
            mm("", digits);
        }
        return output;
    }

    public void mm(String combine, String next) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

            }
        }
        if (next.length() == 0) {
            output.add(combine);
        } else {
            String s = next.substring(0, 1);
            String le = phone.get(s);
            for (int i = 0; i < le.length(); i++) {
                String les = le.substring(i, i + 1);
                mm(combine + les, next.substring(1));
            }
        }
    }

    List<File> files = new ArrayList<>();
    public void findFile(File file){
        for(File file1:file.listFiles()){
            if(!file1.isDirectory()){
                files.add(file1);
            }else {
                findFile(file1);
            }
        }
    }


    List<String> output = new ArrayList<>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
