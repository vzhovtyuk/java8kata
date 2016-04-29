package net.myrts.codingkata8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class CodingKata81 {
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
        List<String> strList = new ArrayList<>(10);
        strList.add("adddd");
        strList.add("addddfdsfsdd");
        strList.add("addgdsgdsgdd");
        strList.add("agfdgdfgdddd");
        strList.add("addgdfdd");
        strList.add("add");
        strList.add("");
        strList.add("add");

        List<String> strList2 = new ArrayList<>(10);
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

    private List<String> flatMapStrings(List<List<String>> strList) {
        List<String> resList = new ArrayList<>();        
        Stream<String> stream = strList.stream()
                .flatMap(new Function<List<String>, Stream<? extends String>>() {
                    @Override
                    public Stream<? extends String> apply(List<String> strings) {
                        //return resList.add(strings);
                        return null;
                    }
                });
        return stream.collect(Collectors.toList());
    }

    private List<String> mapStrings(List<String> strList) {
        Stream<String> stream = strList.stream()
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String str) {
                        return str.toUpperCase();
                    }
                });
        return stream.collect(Collectors.toList());
    }

    private static List<String> filterStrings(List<String> strList) {
        Stream<String> strUnder4 = strList.stream().filter(p -> p.length() < 4);
        return strUnder4.collect(Collectors.toList());
    }

}
