public class Singly_LL_Ops {
    public static void main(String[] args) {
        Singly_LL list = new Singly_LL();
        list.insertFirst(10);
        list.insertAfter(2,0);
        list.display();
        list.displaySize();
        System.out.println(list.size());
    }
}
