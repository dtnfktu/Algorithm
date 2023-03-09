class MySorting
{

public static void main(String[] args) {
    int[] mas = getArray(25);
    System.out.println("Исходный массив:");
    System.out.println(printArray(mas));
    heapSort(mas);
    System.out.println("Отсортированный массив:");
    System.out.print(printArray(mas));

}

// Генерация случайного целочисленного массива заданной длины
public static int[] getArray(int n) {
    int[] array = new int[n];
    for(int i = 0;i < n;i++) {
        array[i] = (int) (Math.random() * 100);
    }
    return array;
}

// Преобразование массива в строку
public static String printArray(int[] array) {
    StringBuilder ans = new StringBuilder();
    for(int i = 0;i < array.length;i++) {
        ans.append(array[i] + " ");
    }
    return ans.toString();
}

// Просеивание элемента
public static void sifting(int[] array, int length, int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;
    if (left < length && array[left] > array[largest]) {
        largest = left;
    }
    if (right < length && array[right] > array[largest]) {
        largest = right;
    }
    if (largest != i) {
        int tmp = array[i];
        array[i] = array[largest];
        array[largest] = tmp;
        sifting(array, length, largest);
    }
}

// Пирамидальная сортировка
public static void heapSort(int[] array) {
    if (array.length == 0) {
        return;
    }
    
    int length = array.length;
    
    // Перемещение от первого не являющегося листом элемента к корню
    for (int i = length / 2 - 1; i >= 0; i--) {
        sifting(array, length, i);
    }
    
    for (int i = length - 1; i >= 0; i--) {
        int tmp = array[0];
        array[0] = array[i];
        array[i] = tmp;
        sifting(array, i, 0);
    }
}

}