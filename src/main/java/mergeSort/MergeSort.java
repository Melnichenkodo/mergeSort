package mergeSort;


public class MergeSort {

    public int[] sort(int[] mas) {
        int[] result = mas;
        int numberOfSortedValues = 1;
        while (numberOfSortedValues < mas.length) {

            int index = 0;

            while (index < mas.length) {

                int[] firstSubMas;

                if (mas.length - index < numberOfSortedValues) {
                    firstSubMas = new int[mas.length - index];
                } else {
                    firstSubMas = new int[numberOfSortedValues];
                }

                int[] secondSubMas;

                if (mas.length - index - numberOfSortedValues <= 0) {
                    secondSubMas = new int[0];
                } else if (mas.length - index - numberOfSortedValues < numberOfSortedValues) {
                    secondSubMas = new int[mas.length - index - numberOfSortedValues];
                } else {
                    secondSubMas = new int[numberOfSortedValues];
                }

                for (int i = 0; i < (firstSubMas.length + secondSubMas.length); i++) {
                    if (i < firstSubMas.length) {
                        firstSubMas[i] = mas[i + index];
                    } else {
                        secondSubMas[i - firstSubMas.length] = mas[i + index];
                    }
                }

                int[] subResult = compare(firstSubMas, secondSubMas);

                for (int i = 0; i < subResult.length; i++) {
                    result[i + index] = subResult[i];
                }

                index += firstSubMas.length + secondSubMas.length;
            }
            numberOfSortedValues *= 2;
        }
        return result;
    }

    private int[] compare(int[] firstMas, int[] secondMas) {
        int[] result = new int[firstMas.length + secondMas.length];
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < result.length; i++) {

            if (firstIndex == firstMas.length) {
                result[i] = secondMas[secondIndex];
                secondIndex++;
            } else if (secondIndex == secondMas.length) {
                result[i] = firstMas[firstIndex];
                firstIndex++;
            } else {
                if (firstMas[firstIndex] < secondMas[secondIndex]) {
                    result[i] = firstMas[firstIndex];
                    firstIndex++;
                } else {
                    result[i] = secondMas[secondIndex];
                    secondIndex++;
                }
            }
        }
        return result;
    }

}
