import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 斐波那契数列，又称黄金分割数列、因数学家列昂纳多·斐波那契以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：
 *           F（0）=0，
 *           F（1）=1，
 *           F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
 *
 *         递归的时间复杂度： O(2^n)
 *      for循环的时间复杂度： O(n)
 *

 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("费波那奇数列：值=?");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 调用数列求值
        long s3= System.nanoTime();
        int result2 = FanabocciFor(n);
        long s4= System.nanoTime();
        System.out.println("for循环的时间："+(s4-s3));

        long s1= System.nanoTime();
        int result = Fanabocci(n);
        long s2= System.nanoTime();
        System.out.println("递归的时间："+(s2-s1));

        System.out.println("第"+n+"位的费波那奇数列的值："+result);
        System.out.println("第"+n+"位的费波那奇数列的值："+result2);
    }

    // 递归版本：但效率较低
    public static int Fanabocci(int n){

        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else {
            // 递归调用
            return Fanabocci(n-1)+Fanabocci(n-2);
        }
    }

    // for循环版本：效率高
    public static int FanabocciFor(int n){
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        if(n==0){
            return f0;
        }

        if(n==1 && n==2){
            return f1;
        }

        // for循环遍历
        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0+f1;
        }

        return f2;
    }
}

