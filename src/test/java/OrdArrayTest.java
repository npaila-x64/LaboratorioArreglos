import org.app.HighArray;
import org.app.OrdArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class OrdArrayTest {

    private OrdArray ordArray1;
    private OrdArray ordArray2;
    private HighArray highArray1;
    private HighArray highArray2;

    @BeforeEach
    void init(){
        highArray1 = new HighArray(5);
        highArray1.insert(5);
        highArray1.insert(5);
        highArray1.insert(22);
        highArray1.insert(5);
        highArray1.insert(10);

        highArray2 = new HighArray(5);
        highArray2.insert(11);
        highArray2.insert(5);
        highArray2.insert(123);
        highArray2.insert(5);
        highArray2.insert(10);

        ordArray1 = new OrdArray(highArray1.getSize());
        ordArray1.copyElementsOf(highArray1);

        ordArray2 = new OrdArray(highArray2.getSize());
        ordArray2.copyElementsOf(highArray2);

    }

    @Test
    public void getOcurrencesTest(){
        int coincidencesExpected = 3;
        int coincidencesReturned = ordArray1.getOcurrences(ordArray2);
        Assertions.assertEquals(coincidencesExpected, coincidencesReturned);
    }

    @Test
    public void copyElementsOfTest(){
        HighArray highArray = new HighArray(10000);

        for (int index = 0; index < 10000; index++) {
            highArray.insert(Math.round(Math.random() * 10000));
        }

        OrdArray ordArray = new OrdArray(10000);
        ordArray.copyElementsOf(highArray);

        List<Long> ordList = ordArray.getArrayList();
        List<Long> highList = highArray.getArrayList();

        Collections.sort(highList);

        Assertions.assertEquals(highList, ordList);
    }
}
