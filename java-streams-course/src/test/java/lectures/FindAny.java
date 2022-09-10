package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class FindAny {

  final Predicate<Integer> numbersBetween6and10 = n -> n > 5 && n < 10;
  final Predicate<Integer> numbersLessThan10 = n ->  n < 10;


    @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int any = Arrays.stream(numbers)
        .filter(numbersBetween6and10)
        .findAny()
        .get();
    System.out.println(any);
  }

  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int first = Arrays.stream(numbers)
        .filter(numbersLessThan10)
        .findFirst()
        .get();
    System.out.println(first);
  }
}

