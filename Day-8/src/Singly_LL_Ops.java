public class Singly_LL_Ops {
    public static void main(String[] args) {
        Singly_LL list = new Singly_LL();
        for (int i = 1; i <= 5; i++) {
            list.insertFirst(i * 10); // 50, 40, ..., 10
            list.insertLast(i * 100); // 100, 200, ..., 500
        }
        list.display();

    }
}
