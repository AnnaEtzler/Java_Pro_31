package lesson4.lines;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPolyLine {

    @Test
    public void testPerimetr(){
        List l = new ArrayList();
        l.add(new Point(1,1));
        l.add(new Point(1,3));
        l.add(new Point(4,3));
        l.add(new Point(4,1));
        PolyLine polyLine = new PolyLine(l);
        assertEquals(10, polyLine.getLength(), 0.000001);

    }
}
