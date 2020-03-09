package 回溯;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Xiao Tao on 2020/3/2 9:39
 */
public class 顺次数 {
//    public List<Integer> sequentialDigits(int low, int high) {
//        int getheader(low);
//    }
//
//    Set<Integer> integers = new HashSet<>();
//    public void get() {
//        if(){
//
//        }
//
//    }

    public int getheader(int low) {
        while (low/10>0){
            low = low/10;
        }
        return low;
    }
}
