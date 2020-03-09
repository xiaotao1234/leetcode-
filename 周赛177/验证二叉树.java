package 周赛177;

import java.util.HashMap;

/**
 * Created by Xiao Tao on 2020/2/23 10:34
 */
public class 验证二叉树 {

    public static void main(String[] args) {
        验证二叉树 s = new 验证二叉树();
        System.out.println(s.validateBinaryTreeNodes(4,new int[]{1,-1,3,-1},new int[]{2,-1,-1,-1}));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        boolean findsmallzero = false;
        for(int l:leftChild){
            if(l!=-1){
                if(hashMap.get(l)!=null){
                    return false;
                }
                hashMap.put(l,1);
            }else {
                findsmallzero = true;
            }
        }
        if(!findsmallzero){
            return false;
        }
        findsmallzero = false;
        for(int r:rightChild){
            if(r!=-1){
                if(hashMap.get(r)!=null){
                    return false;
                }
                hashMap.put(r,1);
            }
            if(r==-1){
                findsmallzero = true;
            }
        }
        if(!findsmallzero){
            return false;
        }
        int max = 0;
        int lar = 0;
        for(int k:hashMap.keySet()){
            if(k>max){
                max = k;
            }
            lar++;
        }
        if(max!=lar){
            return false;
        }
        return true;
    }
}
