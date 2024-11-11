package javaprogramming.commonmistakes.java8;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void lambdavsanonymousclass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello1");
            }
        }).start();

        new Thread(() -> System.out.println("hello2")).start();
    }

    @Test
    public void functionalInterfaces() {
        //可以看一下java.util.function包
        Supplier<String> supplier = String::new;
        Supplier<String> stringSupplier = () -> "OK";

        //Predicate的例子
        Predicate<Integer> positiveNumber = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        assertTrue(positiveNumber.and(evenNumber).test(2));

        //Consumer的例子，输出两行abcdefg
        Consumer<String> println = System.out::println;
        println.andThen(println).accept("abcdefg");

        //Function的例子
        Function<String, String> upperCase = String::toUpperCase;
        Function<String, String> duplicate = s -> s.concat(s);
        assertEquals(upperCase.andThen(duplicate).apply("test"), "TESTTEST");

        //Supplier的例子
        Supplier<Integer> random = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(random.get());

        //BinaryOperator
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtraction = (a, b) -> a - b;
        assertSame(subtraction.apply(add.apply(1, 2), 3), 0);
    }
}
