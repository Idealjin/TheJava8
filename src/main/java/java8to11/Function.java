package java8to11;

import java.util.function.*;

public class Function {


    public static void main(String[] args) {

        Consumer<Integer> printT = (i) -> System.out.println(i);
        Supplier<Integer> get10 = () -> 10;
        //body가 한줄이면 생략가능 {}
        //        Supplier<Integer> get10 = () -> {
        //        return 10};
        System.out.println(get10.get());

        BinaryOperator<Integer> sum = (a,b) -> a + b;

        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(2));

        Function foo = new Function();
        foo.run();




    }

    private void run() {
        final int baseNumber = 10;
        //자바8부터는 final을 생략할수 있는 경우 : 이 변수가 사실상 final인 경우(어디서도 이 변수를 변경하지 않는 경우)
        //        -> 이펙티브 파이널

        //로컬 클래스
        class LocalClass {
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber); //11
            }
        }

        //익명클래스
        Consumer<Integer> integerConsumer =  new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };
        //람다는 Scope가 상위 클래스(여기서는 run)와 같아서 쉐도잉 적용이 안된다.
        /*같은 Scope안에 동일한 변수명 사용 X, i자리에 baseNumber 넣으면 오류 */

        printInt.accept(10);
    }
}
