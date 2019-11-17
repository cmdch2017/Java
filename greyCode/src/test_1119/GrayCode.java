package test_1119;

import java.util.*;

public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String gray[]=new String[(int)Math.pow(2,n)];
        if(n==1){
            gray[0]="0";
            gray[1]="1";
            return gray;
        }
        String last[]=getGray(n-1);
        for(int i=0;i<last.length;i++){
            gray[i]="0"+last[i];
            gray[gray.length-i-1]="1"+last[i];
        }
        return gray;
    }
}