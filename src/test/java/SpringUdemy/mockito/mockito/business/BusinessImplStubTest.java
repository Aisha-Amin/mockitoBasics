package SpringUdemy.mockito.mockito.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BusinessImplStubTest {

    @Test
    void findGreatestValue() {
        DataService datsServiceStub = new DataServiceStub();
        BusinessImpl businessImpl = new BusinessImpl(datsServiceStub);
        int result =  businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{25, 2, 15};
    }
}