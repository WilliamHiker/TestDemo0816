package com.toocms.www.testdemoforwzw;

public class ShuXue {

    public int add(int a, int b) {
        return a + b;
    }



    public int getMaxAge(){
        int[] ages = {18,23,21,25,29,17};
        int max =0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i]>max){
                max = ages[i];
            }
        }
        return max;
    }


}
