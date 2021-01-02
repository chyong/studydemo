package com.song.recursion;

public class EightQueens {

    int max = 8;
    //数组值存放列编号，索引号存放行编号
    int[] array = new int[max];
    static int count = 0;

    //校验是否可以放置皇后，如果是同一列或者同一斜线上则不能放置
    public boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //n为第一个皇后放置的位置，比如第一行第n+1列
    public void setQueens(int n) {
        if (n == max) {
            //所有皇后均已放置完毕
            print();
            return;
        }
        //依次放入皇后
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (check(n)) {
                //如果可以放置
                setQueens(n + 1);
            }
        }
    }

    public void print() {
        count++;
        for (int j = 0; j < max; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.setQueens(0);
        System.out.println("一共有" + count + "种方法");
    }

}
