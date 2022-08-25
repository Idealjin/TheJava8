package java8to11;

import java.util.*;

public class optional2 {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));


        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        //spring으로 시작하는게 있을수도 없을수도 있기 때문에 Optional로 만들어진다.
        //자동변수 단축키 -> ctrl + alt + v

        //Optional에 값이 있는지 없는지 확인 isPresent / isEmpty
        boolean present = optional.isPresent(); //isEmpty()도 있음
        System.out.println(!present);


        //Optinal에 있는 값 가져오기 - 없는 값을 호출하면 런타임에러 발생 -> get 전에 있는지 확인 필요
        if (optional.isPresent()) {
            OnlineClass onlineClass1 = optional.get();
            System.out.println(onlineClass1.getTitle());
        }

        // -> 이렇게 사용하는 것을 권장
        optional.ifPresent(oc ->{
            System.out.println("ifPresent = " + oc.getTitle());
        });

        //있으면 가져오고 없는 경우는 ~~를 리턴하라
        OnlineClass onlineClass = optional.orElseGet(optional2::createNewClasses);
        //spring에 해당되는게 있더라도 createNewClasses 는 실행이 된다.
        //이럴떄는 orElseGet을 쓰면 된다.
        //뭔가 만들어 줄수 없는 경우 orElseThrow를 쓴다. 에러를 떤져주기
        //OnlineClass onlineClass = optional.orElseThrow(() ->{
        // return new IllegalArgumentException();  또는 (IllegalStateException::new)
        // });
        System.out.println(onlineClass.getTitle() + "orElse쪽 Title");


        //Optional에 있는 값 걸러 내기
        Optional<OnlineClass> onlineClass1 = optional.filter(oc -> !oc.isClosed());
        System.out.println(onlineClass1.isEmpty());

        //map 으로 값 변환하기
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent() + "map쪽");

        //map으로 꺼내는 타입이 Optional 이면 한번 더 꺼내야 된다.
        /* Optional<Integer> integer = optional.map(OnlineClass::getProgress);
           Optional<Progress> progress1 = progress.orElseThrow();
           Progress progress2 = progress1.orElseThrow();
           이럴떄 유용한 것이 flatMap
        * */

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        //Optional 안에 들어있는 인스턴스가 Optional인 경우에 사용하면 편리하다.
        //Stream에서의 flatMap과는 다르다.
        //Stream에서의 flatMap은 1대1 맵핑이다.

    }

    private static OnlineClass createNewClasses() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New class", false);
    }

}
