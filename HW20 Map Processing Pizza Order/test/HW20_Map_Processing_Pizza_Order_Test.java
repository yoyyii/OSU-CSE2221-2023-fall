import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class HW20_Map_Processing_Pizza_Order_Test {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetPriceMap() {
        String file = "data\\test1.txt";
        SimpleReader in = new SimpleReader1L(file);
        Map<String, Integer> map = new Map1L<>();

        HW20_Map_Processing_Pizza_Order.getPriceMap(file, map);

        Map<String, Integer> mapExpected = new Map1L<>();
        mapExpected.add("pizza 1", 20);
        mapExpected.add("pizza2", 10);
        mapExpected.add("PIZZA 3", 2);

        assertEquals(mapExpected, map);

    }

}
