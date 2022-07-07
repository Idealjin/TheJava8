package java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Optional1 {

    public static void main(String[] args) {

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "Spring Boot", true));
        springClasses.add(new OnlineClass(2, "Spring Data Jpa", true));
        springClasses.add(new OnlineClass(3, "Spring MVC", false));
        springClasses.add(new OnlineClass(4, "Spring Core", false));
        springClasses.add(new OnlineClass(5, "Rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
       /*
        Duration studyDuration = spring_boot.getProgress().getStudyDuration();
        System.out.println(studyDuration);  //Referance타입은 기본값이 null이기 때문에 출력이 안됨
        */

        /* 이렇게 하면 되지만 오류가 많이 난다. null 체크를 깜박할 수 있기 때문에 ,
            2번째는 null을 리턴하는 것 자체가 문제
            그렇다고 에러를 던져주면 stackTrace를 사용하므로 리소스가 소모된다.
        Progress progress = spring_boot.getProgress();
        if (progress != null){
            System.out.println(progress.getStudyDuration());
        }*/





    }

}
