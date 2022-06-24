package java8to11;

public interface Bar extends Foo{

    //void printNameUpperCase();
    //이렇게도 가능하다. 하지만 bar를 상속받는 클래스에서 모두 재정의를 해줘야한다.

    //FOO, BAR 모두 디폴트가 있을경우 DefaultFoo에서 Foo와 Bar 모두 상속받을경우 컴파일에러 발생
    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
