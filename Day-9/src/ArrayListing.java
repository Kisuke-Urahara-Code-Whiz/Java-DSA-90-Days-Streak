import java.util.ArrayList;

public class ArrayListing {
    public static void main(String[] args) {
        ArrayList<Integer> list = fin(1);
        System.out.println(list);
    }

    public static ArrayList fin(int a){
        ArrayList<Integer> list = new ArrayList<>();
        if(a==5) {
            list.add(a);
            return list;
        } else{
           list.add(a);
           list.addAll(fin(a+1));
           return list;
        }
    }
}
