package java8to11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferance {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting::hi;
        // ::이 찍혀있으면 메소드레퍼런스이다.

        //생성자도 참조 가능

        Supplier<Greeting> newGreeting = Greeting::new;
        // -> 메소드를 호출한 상태가 아님
        newGreeting.get();

        Function<String, Greeting> sjGreeting = Greeting::new; //1
        Greeting sj = sjGreeting.apply("sj");
        System.out.println(sj.getName());
        Supplier<Greeting> newGreeting2 = Greeting::new;        //2
        //1,2는 다른 곳을 가리킴


        String[] names = {"sangjin", "keesun", "whiteship"};
        Arrays.sort(names, String::compareToIgnoreCase);
        //compareToIgnoreCase 비교해서 같으면 정수값 넘겨준다.
        System.out.println(Arrays.toString(names));





    }
}
