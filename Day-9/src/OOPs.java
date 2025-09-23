public class OOPs {
    public static void main(String[] args) {
        Test user = new Test(23,"Sougata",67.9f);
        System.out.println(user.name);
    }

    public static class Test {
        int rno;
        String name;
        float marks;

        Test(int rnoll, String namell, float markll){
            name = namell;
            rno = rnoll;
            marks = markll;
        }
    }
}
