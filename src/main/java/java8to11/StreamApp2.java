package java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StreamApp2 {
    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        System.out.println("spring으로 시작하는 수업");

        springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
                        .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");

        springClasses.stream().filter(oc -> !oc.isClosed())
                        .forEach(oc -> System.out.println(oc.getId()));
        System.out.println("위 코드를 메소드 레퍼런스이용");
        springClasses.stream()
                        .filter(Predicate.not(OnlineClass::isClosed))       //predicate에 Not이 존재 !와 같은기능
                        .forEach(oc-> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
            springClasses.stream()
                    .map(OnlineClass::getTitle)
                    .forEach(System.out::println);


        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 잇는 모든 수업아이디 출력");

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 뺴고 최대 10개 까지만");

        System.out.println("자바 수업 중에 Test가 들어잇는 수업이 잇는지 확인");


    }
}
