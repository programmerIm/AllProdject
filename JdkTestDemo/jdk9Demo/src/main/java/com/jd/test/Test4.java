package com.jd.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: liming522
 * @description:
 * @date: 2022/11/17 3:37 PM
 * @hope: The newly created file will not have a bug
 */
public class Test4
{
    public static void main(String[] args) {
             List<Integer> objects = new ArrayList<>();
                objects.add(1);
                objects.add(2);
                objects.add(3);

         Optional<List<Integer>> optional = Optional.ofNullable(objects);

         Stream<List<Integer>> stream = optional.stream();

         stream.flatMap(s->s.stream()).forEach(System.out::println);
    }
}
