import org.app.HighArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HighArrayTest {

    private HighArray array1;
    private HighArray array2;

    @BeforeEach
    void init(){
        array1 = new HighArray(5);
        array1.insert(5);
        array1.insert(5);
        array1.insert(22);
        array1.insert(5);
        array1.insert(10);

        array2 = new HighArray(5);
        array2.insert(11);
        array2.insert(5);
        array2.insert(123);
        array2.insert(5);
        array2.insert(10);
    }

    @Test
    public void getOcurrencesTest(){
        int coincidencesExpected = 3;
        int coincidencesReturned = array1.getOcurrences(array2);
        Assertions.assertEquals(coincidencesExpected, coincidencesReturned);
    }
}