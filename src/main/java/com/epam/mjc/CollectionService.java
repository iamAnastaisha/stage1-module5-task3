package com.epam.mjc;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionService {

    public List<Integer> filterEvenNumbers(List<Integer> list) {
        return list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public Optional<Integer> findMax(List<Integer> list) {
        return list.stream().max(Comparator.naturalOrder());
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {
        return list.stream().flatMap((Function<List<Integer>, Stream<Integer>>)
                integers -> integers.stream().min(Comparator.naturalOrder()).stream()).collect(Collectors.toList()).stream().min(Comparator.naturalOrder());
    }

    public Integer sum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
