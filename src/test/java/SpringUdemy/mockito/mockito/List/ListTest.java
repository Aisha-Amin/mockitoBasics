package SpringUdemy.mockito.mockito.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simpleTest() {
        List list = mock(List.class);
        when(list.size()).thenReturn(3);
        assertEquals(3,list.size());
    }

    @Test
    void multipleTest() {
        List list = mock(List.class);
        when(list.size()).thenReturn(3).thenReturn(2).thenReturn(1);
        assertEquals(3,list.size());
        assertEquals(2,list.size());
        assertEquals(1,list.size());
    }

    @Test
    void listParameters() {
        List list = mock(List.class);
        when(list.get(0)).thenReturn("Something");
        assertEquals("Something",list.get(0));
        assertEquals(null,list.get(1)); // By default list returns null object
    }

    @Test
    void listGenericParameters() {
        List list = mock(List.class);
        // for any int value it will return something
        when(list.get(Mockito.anyInt())).thenReturn("Something");
        assertEquals("Something",list.get(0));
        assertEquals("Something",list.get(1));
    }
}
