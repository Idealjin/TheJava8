package java8to11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collector;

public class App7 {
    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("sangjin");
        name.add("jieun");
        name.add("heasung");
        name.add("genie");

        name.forEach(System.out::println);
        //메소드 레퍼런스
        System.out.println("---------------");
        for (String n : name){
            System.out.println(n);
        }
        //위랑 같은 코드
        System.out.println("---------------");

        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();// 쪼개준다.
        while (spliterator.tryAdvance(System.out::println));
        //다음게 없으면 false가 리턴되기떄문에 있으면 게속 출력해준다
        //역시; 위와 같은 코드
        System.out.println("---------------");
        while (spliterator1.tryAdvance(System.out::println));
        //다음에 배울 스트림에 스플리터레이터가 사용된다.

        System.out.println("---------------");
        //name.removeIf(s -> s.startsWith("s")); //s로 시작하는걸 빼라
        name.forEach(System.out::println);

        System.out.println("--------정렬------");
        name.sort(String::compareToIgnoreCase); //문자열 정렬
        //역순
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
    }
}
