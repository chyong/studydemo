package com.song.linkedlist;

public class NumberReverse {

public static void main(String[] args){
    System.out.println(reverse(214768364));
}

public static int reverse(int x) {
    int rev = 0;
    int pop;
    while(x != 0){
        pop = x % 10;
        x = x / 10;
        if(rev > Integer.MAX_VALUE / 10) return 0;
        if(rev < Integer.MIN_VALUE / 10) return 0;
        rev = rev * 10 + pop;
    }
    return rev;
}

}
