package javaprogramming.commonmistakes.concurrenttool.ciavspia;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CommonMistakesApplication {

    /**
     * 当键存在时，putIfAbsent耗时较长，而computeIfAbsent应为传入的是Lambda表达式而不是实际值，耗时短。
     * 当键不存在时，putIfAbsent会返回null，要小心NPE问题，而computeIfAbsent返回的是计算结果，不存在NPE问题。
     * 当键不存在时，putIfAbsent允许存放null，而computeIfAbsent不允许。
     */
    public static void main(String[] args) {
        test(new HashMap<>());
        test(new ConcurrentHashMap<>());
    }

    private static void test(Map<String, String> map) {
        log.info("class : {}", map.getClass().getName());
        try {
            log.info("putIfAbsent null value : {}", map.putIfAbsent("test1", null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("test containsKey after putIfAbsent : {}", map.containsKey("test1"));
        log.info("computeIfAbsent null value : {}", map.computeIfAbsent("test2", k -> null));
        log.info("test containsKey after computeIfAbsent : {}", map.containsKey("test2"));
        log.info("putIfAbsent non-null value : {}", map.putIfAbsent("test3", "test3"));
        log.info("computeIfAbsent non-null value : {}", map.computeIfAbsent("test4", k -> "test4"));
        log.info("putIfAbsent expensive value : {}", map.putIfAbsent("test4", getValue()));
        log.info("computeIfAbsent expensive value : {}", map.computeIfAbsent("test4", k -> getValue()));

    }

    private static String getValue() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
}

