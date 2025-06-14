public class Singly_LL_Ops {
    public static void main(String[] args) {
        Singly_LL list = new Singly_LL();
        list.insertLast(1);
        list.insertFirst(2);
        list.insertLast(3);
        list.insertLast(3);
        list.deleteFirst();
        list.deleteFirst();
        list.display();
        list.displaySize();
    }
}
