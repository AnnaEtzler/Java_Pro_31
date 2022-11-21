package Lesson31;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;


public class ListTest {


    List<String> words = List.of("Hello", "Hell");

    // проверьте что каждый элемент начинается на "H" и содержит "ll"
    // до 19:37
    @Test
    public void testList()
    {
       // assertThat(words, allOf(everyItem(startsWith("H")), everyItem(containsString("ll"))));
    }

}
