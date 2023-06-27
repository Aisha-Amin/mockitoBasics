package SpringUdemy.mockito.mockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private BusinessImpl businessImpl;

    @Test
    void findGreatestValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,2,15});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findGreatestOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_EmptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}

