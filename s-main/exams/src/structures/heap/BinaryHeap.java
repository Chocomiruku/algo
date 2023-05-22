package structures.heap;

public class BinaryHeap {

    private final int[] heap; // Массив для хранения элементов кучи
    private int size; // Размер кучи

    // Конструктор кучи
    public BinaryHeap(int capacity) {
        heap = new int[capacity];
    }

    // Метод для проверки, является ли куча пустой
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для проверки, является ли куча полной
    public boolean isFull() {
        return size == heap.length;
    }

    // Метод для добавления элемента в кучу
    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Куча полна");
        }

        heap[size] = value; // Вставка элемента в конец кучи

        int index = size; // Индекс вставленного элемента
        int parentIndex = (index - 1) / 2; // Индекс родительского элемента

        // "Всплывание" элемента на верх кучи, если он больше своего родителя
        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }

        size++; // Увеличение размера кучи
    }

    // Метод для удаления максимального элемента из кучи
    public int extractMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Куча пуста");
        }

        int maxValue = heap[0]; // Запоминаем максимальный элемент

        heap[0] = heap[size - 1]; // Замена корня кучи последним элементом

        size--; // Уменьшение размера кучи

        int index = 0; // Индекс корня кучи
        boolean done = false;

        // "Погружение" элемента вниз по куче, если он меньше своего наибольшего потомка
        while (!done) {
            int leftChildIndex = 2 * index + 1; // Индекс левого потомка
            int rightChildIndex = 2 * index + 2; // Индекс правого потомка

            // Если у элемента нет потомков, то завершаем "погружение"
            if (leftChildIndex >= size) {
                break;
            }

            // Если у элемента есть только левый потомок
            if (rightChildIndex >= size) {
                if (heap[index] < heap[leftChildIndex]) {
                    swap(index, leftChildIndex);
                }
                break;
            }

            // Если у элемента есть оба потомка, то выбираем большего из них
            int largerChildIndex = heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex;

            // Если элемент меньше своего наибольшего потомка, то производим обмен и продолжаем "погружение"
            if (heap[index] < heap[largerChildIndex]) {
                swap(index, largerChildIndex);
                index = largerChildIndex;
            } else {
                break; // Если элемент не меньше своего наибольшего потомка, то завершаем "погружение"
            }
        }

        return maxValue;
    }

    // Метод для обмена элементов кучи по их индексам
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String... arg) {
        BinaryHeap heap = new BinaryHeap(15);
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);
        int max = heap.extractMax();
        System.out.println("max = " + max);
    }
}

/*
Куча (Heap) — это специализированная структура данных в виде дерева,
которая удовлетворяет свойству кучи: если B является узлом-потомком узла A,
то ключ(A) ≥ ключ(B) для максимальной кучи, или наоборот, ключ(A) ≤ ключ(B) для минимальной кучи.
То есть, для максимальной кучи родительский узел всегда больше или равен дочерним,
а для минимальной - всегда меньше или равен.

Иными словами, для максимальной кучи, максимальный элемент всегда находится в корне дерева,
а для минимальной кучи в корне всегда находится минимальный элемент.

Кучи обычно используются для реализации очередей с приоритетами и в алгоритмах на графах,
таких как алгоритм Дейкстры или алгоритм Прима.

Важным свойством кучи является то, что она позволяет вставлять новые элементы и
извлекать максимальный (или минимальный) элемент за время O(log n),
где n - количество элементов в куче.
 */
