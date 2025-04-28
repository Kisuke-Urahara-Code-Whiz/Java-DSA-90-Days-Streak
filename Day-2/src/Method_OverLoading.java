public class Method_OverLoading {
    public static void main(String[] args) {
        fun(2);
        fun("Kunal");
        vararg(2,3,4);
        vararg("Kunal","Hello");
        //vararg(); throws error as empty params

    }
    static void fun(int a){
        System.out.println("Fun num");
    }

    static void fun(String a){
        System.out.println("Fun string");
    }

    static void vararg(int ...a){
        System.out.println("Fun num varargs");
    }

    static void vararg(String ...b){
        System.out.println("Fun string varargs");
    }
}
