package net.myrts.codingkata8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;

public class StreamingApiJavaBean {
    @Test
    public void shouldFilterAndMapNameOlderAs18() {
        //given
        List<Person> personList = createPersonList();

        //when
        List<String> resList = filterStrings(personList);
        //then

        assertEquals("Length is not equal", 4, resList.size());
    }

    @Test
    public void shouldGroupByNationality() {
        //given
        List<Person> personList = createPersonList();

        //when
        Map<String, List<Person>> resList = groupByNationality(personList);
        //then

        assertEquals("Length is not equal", 6, resList.size());
    }

    @Test
    public void shouldPartitionByOlderBy18AsMap() {
        //given
        List<Person> personList = createPersonList();

        //when
        Map<Boolean, List<Person>> resList = partitionByOlderBy18AsMap(personList);

        assertEquals("Length is not equal", 2, resList.size());
    }

    @Test
    public void shouldListAllNamesCommaSeparated() {
        //given
        List<Person> personList = createPersonList();

        //when
        String resList = commaSeparatedNames(personList);

        assertEquals("Length is not equal", "Names: Bob. Nick. Linda. Maria. Huan. Don. Don2", resList);
    }

    private String commaSeparatedNames(List<Person> personList) {
        return personList.stream().map(Person::getName).collect(Collectors.joining(". ", "Names: ", ""));
    }

    @Test
    public void shouldGetOldestPerson() {
        //given
        List<Person> personList = createPersonList();

        //when
        Person person = getOldestPerson(personList);

        assertEquals("Length is not equal", "Bob", person.getName());
    }

    private Person getOldestPerson(List<Person> personList) {
        return personList.stream().max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).get();
    }

    @Test
    public void shouldSummariseStatsPerson() {
        //given
        List<Person> personList = createPersonList();

        //when
        Stats stats = getStatsForPerson(personList);

        assertEquals("Size is not equal", 7, stats.getSize());
        assertEquals("Min is not equal", 10, stats.getMin());
        assertEquals("Max is not equal", 25, stats.getMax());
        assertEquals("Sum is not equal", 133, stats.getSum());
    }

    private Stats getStatsForPerson(List<Person> personList) {
        Stats stats = new Stats();
        long count = personList.stream().count();
        stats.setSize((int) count);
        IntStream sum = personList.stream().mapToInt(Person::getAge);
        stats.setSum(sum.sum());
        sum = personList.stream().mapToInt(Person::getAge);
        stats.setMin(sum.min().getAsInt());
        sum = personList.stream().mapToInt(Person::getAge);
        stats.setMax(sum.max().getAsInt());
        return stats;
    }


    private Map<Boolean, List<Person>> partitionByOlderBy18AsMap(List<Person> personList) {
        return personList.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 18));
    }

    private Map<String, List<Person>> groupByNationality(List<Person> strList) {
        return strList.stream().collect(
                Collectors.groupingBy(Person::getNationality));
    }

    private static List<String> filterStrings(List<Person> strList) {
        Stream<String> strUnder4 = strList.stream().filter(p -> p.getAge() > 18).map(Person :: getName);
        return strUnder4.collect(Collectors.toList());
    }

    private List<Person> createPersonList() {
        final List<Person> persons = new ArrayList<>();
        persons.add(new Person(25, "Bob", "german"));
        persons.add(new Person(16, "Nick", "english"));
        persons.add(new Person(10, "Linda", "bulgarian"));
        persons.add(new Person(15, "Maria", "turkish"));
        persons.add(new Person(21, "Huan", "spanich"));
        persons.add(new Person(23, "Don", "mexikanish"));
        persons.add(new Person(23, "Don2", "mexikanish"));
        return persons;
    }

}
