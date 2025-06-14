public class Singly_LL_Ops {
    public static void main(String[] args) {
        Singly_LL list = new Singly_LL();
        list.insertLast(1);
        list.insertFirst(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(1);
        list.deleteLast();
        list.display();
        list.displaySize();
        System.out.println(list.size());
    }
}
