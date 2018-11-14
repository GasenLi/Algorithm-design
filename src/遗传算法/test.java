package 遗传算法;

public class test {

    public static void main(String[] args) {
        System.out.println(fun(1.344));
    }

    public static double fun(double temp){
        return (Math.sin(temp)*Math.sin(temp) + 2*Math.sin(temp)*Math.cos(temp) - 3*Math.cos(temp)*Math.cos(temp) - 2.0);
    }
}
