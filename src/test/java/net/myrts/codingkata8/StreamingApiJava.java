package net.myrts.codingkata8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class StreamingApiJava {
    @Test
    public void shouldFilterStrings() {
        //given
        List<String> strList = new ArrayList<>(10);
        strList.add("adddd");
        strList.add("addddfdsfsdd");
        strList.add("addgdsgdsgdd");
        strList.add("agfdgdfgdddd");
        strList.add("addgdfdd");
        strList.add("add");
        strList.add("");
        strList.add("add");


        //when
        List<String> resList = filterStrings(strList);
        //then

        assertEquals("Length is not equal", 3, resList.size());
    }

    @Test
    public void shouldMapStrings() {
        //given
        List<String> strList = new ArrayList<>(10);
        strList.add("adddd");
        strList.add("addddfdsfsdd");
        strList.add("addgdsgdsgdd");
        strList.add("agfdgdfgdddd");
        strList.add("addgdfdd");
        strList.add("add");
        strList.add("");
        strList.add("add");


        //when
        List<String> resList = mapStrings(strList);
        //then

        assertEquals("Length is not equal", 8, resList.size());
    }

    @Test
    public void shouldFlatMapStrings() {
        //given
        List<String> strList = new ArrayList<>();
        strList.add("adddd");
        strList.add("addddfdsfsdd");
        strList.add("addgdsgdsgdd");
        strList.add("agfdgdfgdddd");
        strList.add("addgdfdd");
        strList.add("add");
        strList.add("");
        strList.add("add");
        strList.add(null);

        List<String> strList2 = new ArrayList<>();
        strList.add("adddd");
        strList.add("addddfdsfsdd");
        strList.add("");
        strList.add("add");

        List<List<String>> lists = new ArrayList<>();
        lists.add(strList);
        lists.add(strList2);

        //when
        List<String> resList = flatMapStrings(lists);
        //then

        assertEquals("Length is not equal", strList2.size() + strList.size(), resList.size());
    }

    @Test
    public void shouldProvideSumReduce() {
        //given
        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(4);
        intList.add(6);
        intList.add(1);
        intList.add(2);

        //when
        int sumValue = sumReduceInt(intList);
        int sumIntVal = sumInt(intList);
        //then
        assertEquals("Length is not equal", 18, sumValue);
        assertEquals("Length is not equal", 18, sumIntVal);
    }

    private int sumReduceInt(List<Integer> intList) {
        return intList.stream().reduce((integer, integer2) -> integer + integer2).get();
    }

    private int sumInt(List<Integer> intList) {
        IntStream intStream = intList.stream().mapToInt(Integer::intValue);
        return intStream.sum();
    }

    private List<String> flatMapStrings(List<List<String>> strList) {
        Stream<String> stream = strList.stream()
                .flatMap(Collection::stream);
        return stream.collect(Collectors.toList());
    }

    private List<String> mapStrings(List<String> strList) {
        Stream<String> stream = strList.stream()
                .map(String::toUpperCase);
        return stream.collect(Collectors.toList());
    }

    private static List<String> filterStrings(List<String> strList) {
        Stream<String> strUnder4 = strList.stream().filter(p -> p.length() < 4);
        return strUnder4.collect(Collectors.toList());
    }

}
