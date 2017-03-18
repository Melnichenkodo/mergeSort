package mergeSort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class MergeSortTest {

    @DataProvider(name = "test")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {new int[]{4, 8, 6, 2, 5, 1, 7, 3}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6, 7}},
                {new int[]{4, 8, 6, 2, 5, 1}, new int[]{1, 2, 4, 5, 6, 8}},
                {new int[]{4, 8, -6, 2, 5, -1}, new int[]{-6, -1, 2, 4, 5, 8}},
                {new int[]{4, 8, 6, 2, 5, 1, 9}, new int[]{1, 2, 4, 5, 6, 8, 9}},
                {new int[]{4, 8, 6, 2, 5,}, new int[]{2, 4, 5, 6, 8}},
                {new int[]{4, 8, 6,}, new int[]{4, 6, 8}},
                {new int[]{4, 8, 4,}, new int[]{4, 4, 8}},
                {new int[]{7, 4,}, new int[]{4, 7}},
                {new int[]{4}, new int[]{4}},
        };
    }

    @Test(dataProvider = "test")
    public void mergeSortTest(int[] mas, int[] expectedResult) {
        MergeSort ms = new MergeSort();
        int[] result = ms.sort(mas);
        assertEquals(result, expectedResult);
    }
}
