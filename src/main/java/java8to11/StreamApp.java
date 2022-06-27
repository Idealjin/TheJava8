package java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {

        //Stream은 데이터를 담고 잇는 저장소가 아니다.
        List<String> names = new ArrayList<>();
        names.add("sangjin");
        names.add("jieun");
        names.add("hyesung");
        names.add("genie");

//        Stream<String> stringStream = names.stream()
//                .map(String::toUpperCase);
        //스트림이 처리하는 데이터 소스를 변경하지 않는다.(위에 코드처럼 대문자로 변경 X)
        //스트림 여러 api 크게 2가지로 나뉜다
        // 중개형 / 종료 오퍼레이션
        /* 중개 오퍼레이션은 stream을 리턴, 종료형은 stream이 아닌 다른타입을 리턴한다.
        위에 MAP은 스트림을 리턴하기댸문에 중개형

        * */

        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList()); // 이렇게하면 종료형 오퍼레이터이기떄문에 실행한다.
        collect.forEach(System.out::println);

        // 출력 X, 중개형 오퍼레이터는 터미널 오퍼레이터가 오기전에는 실행을 안한다.


        System.out.println("========");

        names.forEach(System.out::println);

        for (String name : names){
            if(name.startsWith("S")){
                System.out.println(name.toUpperCase());
            }
        }
        //위 코드는 병렬처리가 어렵다
        //스트림은 손쉽게 병렬처리를 할 수 있다.
        System.out.println("병렬처리가 쉽다.");
        names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        //추가로
        System.out.println("병렬처리222");
        List<String> collect2 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
        //parallel이 무조건 빠른것은 아니다. thread를 사용하는데는 비용이 든다.
        //데이터가 정말 방대하게 큰 경우에만 유용하고 보통은 그냥 스트림 쓰는게 유용하다(parallel보다)

    }
}
