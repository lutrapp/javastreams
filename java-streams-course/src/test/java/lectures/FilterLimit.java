package lectures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;import com.google.common.collect.Ordering;

import org.assertj.core.util.Lists;
import org.junit.Test;

import beans.Person;
import beans.Car;
import mockdata.MockData;


public class FilterLimit {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    List<Person> youngPeople = Lists.newArrayList();

    final int limit = 10;
    int counter = 0;

    for( Person person : people) {
      if(person.getAge() <= 18) {
        youngPeople.add(person);
        counter++;
        if(counter == limit) {
          break;
        }
      }
    }

    for (Person young : youngPeople) {
      System.out.println(young);
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
//    ImmutableList<Person> people = MockData.getPeople();
//
//    List<Person> youngPeople = people.stream()
//        .filter(person -> person.getAge() <= 18)
//        .limit(10)
//        .collect(Collectors.toList());
//
//    youngPeople.forEach(System.out::println);

    List<Car> cars = MockData.getCars();
    List<Car> oldCars = cars.stream()
    		.filter(c -> c.getYear()>=2000)
    		.filter(c -> c.getColor().equalsIgnoreCase("red"))
    		.filter(c -> c.getPrice()>=10000)
    		.limit(3)
    		.collect(Collectors.toList());
    
    oldCars.forEach(System.out::println);
  }
}
