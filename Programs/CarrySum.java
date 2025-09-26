package Programs;

import java.util.ArrayList;

public class CarrySum {
    int sum;

    public CarrySum() {
        sum = 0;
    }

    public ArrayList<Integer> addition(int num1, int num2, int carry){
        sum = num1 + num2 + carry;
        ArrayList<Integer> sc = new ArrayList<>();
        sc.add(sum % 10);
        sc.add(sum / 10);
        return sc;
    }

    public int addition(int num1, int num2, int carry, boolean both){
        sum = num1 + num2 + carry;
        ArrayList<Integer> sc = new ArrayList<>();
        if(both){
            return sum;
        }
        else{
            return 0;
        }
    }
}
