package java8to11;

public class FooApp {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("sangjin");
        foo.printName();
        foo.printNameUpperCase();
        Foo.printAnything(); // 인터페이스 메소드를 직접 불러와서 사용할수도 있다.

    }
}
