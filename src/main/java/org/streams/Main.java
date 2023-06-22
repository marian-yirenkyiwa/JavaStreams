package org.streams;

import org.streams.practice.Gender;
import org.streams.practice.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        //using the imperative approach
        List<Person> male = new ArrayList<>();

        for(Person person: people){
            if(person.getGender().equals(Gender.MALE)){
                male.add(person);
            }
        }
        //for each item in male list, print out item on a new line
        male.forEach(System.out::println);

        System.out.println();



        //using the declarative approach

        //--using filter method--
        List<Person> female = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();
        female.forEach(System.out::println);

        System.out.println();

        //--using the sort method to sort list of people by age--
        List<Person> sortedList =
                people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                        .toList();
        sortedList.forEach(System.out::println);


        System.out.println();


        //--reversed sort people list by gender--
        List<Person> reversedSort = people.stream()
                .sorted(Comparator.comparing(Person::getGender).reversed())
                .toList();
        reversedSort.forEach(System.out::println);

        System.out.println();

        //--using the max method in streams to get person with maximum age--
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println();


        //--using the min method in streams to get person with maximum age--
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }

    private static List<Person> getPeople(){
        return List.of(
                new Person("Marian Larbi", 25, Gender.FEMALE),
                new Person("Mark Tetteh", 26, Gender.MALE),
                new Person("Mary Afrane", 23, Gender.FEMALE),
                new Person("Elisha Amenuveve", 24, Gender.MALE),
                new Person("Emma Odamettey", 23, Gender.FEMALE)
        );
    }

 }