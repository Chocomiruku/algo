package sorts.merge;

import static sorts.Utils.printArray;

/**
 // Сложность O(n log n) - линейно-логарифмическая.
 */
public class MergeSort {

    // Вспомогательная функция, которая сливает два подмассива array[].
    private static void merge(int[] array, int leftIndex, int midIndex, int rightIndex) {
        // Находим размеры двух подмассивов для слияния
        int leftArraySize = midIndex - leftIndex + 1;
        int rightArraySize = rightIndex - midIndex;

        // Создаем временные массивы
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        // Копируем данные во временные массивы
        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[leftIndex + i];
        }

        for (int j = 0; j < rightArraySize; j++) {
            rightArray[j] = array[midIndex + 1 + j];
        }

        // Слияние временных массивов

        // Инициализируем индексы первого и второго подмассивов
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        // Инициализируем индекс слияния подмассивов
        int mergedArrayIndex = leftIndex;
        while (leftArrayIndex < leftArraySize && rightArrayIndex < rightArraySize) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                array[mergedArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[mergedArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            mergedArrayIndex++;
        }

        // Копируем оставшиеся элементы leftArray[], если есть
        while (leftArrayIndex < leftArraySize) {
            array[mergedArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            mergedArrayIndex++;
        }

        // Копируем оставшиеся элементы rightArray[], если есть
        while (rightArrayIndex < rightArraySize) {
            array[mergedArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            mergedArrayIndex++;
        }
    }

    // Главная функция, которая сортирует array[leftIndex..rightIndex] с использованием
    // функции merge()
    public static void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        // Находим точку середины
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

        // Сортируем две половины
        mergeSort(array, leftIndex, midIndex);
        mergeSort(array, midIndex + 1, rightIndex);

        // Сливаем отсортированные половины
        merge(array, leftIndex, midIndex, rightIndex);
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Данный массив");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nОтсортированный массив");
        printArray(array);
    }
}
