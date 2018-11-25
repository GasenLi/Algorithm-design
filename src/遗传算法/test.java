package 遗传算法;

import java.math.BigDecimal;

public class test {

    public static void main(String[] args) {
        System.out.println(new BigDecimal(fun(1.571)+""));
    }

    public static double fun(double temp){
        return (Math.sin(temp)*Math.sin(temp) + 2*Math.sin(temp)*Math.cos(temp) - 3*Math.cos(temp)*Math.cos(temp) - 1.0);
    }
}
