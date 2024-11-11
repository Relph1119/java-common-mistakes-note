package javaprogramming.commonmistakes.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;

public class MostPopularCollector<T> implements Collector<T, Map<T, Integer>, Optional<T>> {
    @Override
    public Supplier<Map<T, Integer>> supplier() {
        // 使用HashMap保存中间数据
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<T, Integer>, T> accumulator() {
        // 每次累计数据则累加值
        return (acc, elem) -> acc.merge(elem, 1, Integer::sum);
    }

    @Override
    public BinaryOperator<Map<T, Integer>> combiner() {
        // 合并多个Map就是合并其值
        return (a, b) -> Stream.concat(a.entrySet().stream(), b.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));
    }

    @Override
    public Function<Map<T, Integer>, Optional<T>> finisher() {
        // 找到Map中最值最大的键
        return (acc) -> acc.entrySet().stream()
                .reduce(BinaryOperator.maxBy(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
