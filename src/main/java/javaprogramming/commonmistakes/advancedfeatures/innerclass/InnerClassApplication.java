package javaprogramming.commonmistakes.advancedfeatures.innerclass;

public class InnerClassApplication {

    private final String gender = "male";

    public static void main(String[] args) throws Exception {

        InnerClassApplication application = new InnerClassApplication();
        application.test();

    }

    private void test() {
        MyInnerClass myInnerClass = new MyInnerClass();
        System.out.println(myInnerClass.name);
        myInnerClass.test();
    }

    class MyInnerClass {
        private final String name = "zhuye";

        void test() {
            System.out.println(gender);
        }
    }
}
