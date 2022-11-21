package Lesson29;
import lesson24.Car;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.number.IsCloseTo.closeTo;
//import static org.hamcrest.Matchers.*;

public class ProbeTester {

    @Test
    public void testProbeMessage()
    {
        assertThat(Probe.getMessage(3), anyOf(is("Hello"), is("World")));
        assertThat(Probe.getMessage(33), anyOf(is("Hello"), is("World")));
        assertThat(Probe.getMessage(23), is("Hello"));
        assertThat(Probe.getMessage(3), is("World"));


        assertThat(Probe.getMessage(23), allOf(startsWith("He"), endsWith("lo")));

    }

    @Test
    public void carTest(){
        assertThat(Probe.getCar(), instanceOf(Car.class));
        assertThat((Car) Probe.getCar(), hasProperty("price", closeTo(20_000, 0.1)));
    }

    @Test
    public void collectionTest()
    {
        List<String> names = List.of("Max", "Dima", "Alex", "Marina");
        // напишите тест который проверит что в names есть элементы Dima и Alex
        // до 21:36
        assertThat(names, allOf(hasItem("Dima"), hasItem("Alex")));
        assertThat(names, Matchers.hasItems("Dima", "Alex"));
        assertThat(names, containsInAnyOrder("Dima", "Alex", "Max", "Marina"));
    }


}
