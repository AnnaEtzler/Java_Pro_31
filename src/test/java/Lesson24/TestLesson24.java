package Lesson24;

import lesson24.Lesson24;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestLesson24 {
    @Test
    public void testLesson24(){
        List<String> months = List.of("january", "february", "march", "june", "march");
        Set<String> set = new HashSet<> ();
        set.addAll((List.of("january", "february", "march")));

        assertEquals(set, Lesson24.filterList(months, "r"));
    }
}
