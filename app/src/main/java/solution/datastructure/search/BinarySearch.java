package solution.datastructure.search;

public class BinarySearch {

    public static int binarySearchWithRecursion(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) return -1;
        int middle = (low + high) / 2;
        if (key < arr[middle]) {
            //比关键字大则关键字在左区域
            return binarySearchWithRecursion(arr, key, low, middle - 1);
        } else if (key > arr[middle]) {
            //比关键字小则关键字在右区域
            return binarySearchWithRecursion(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        if (key < arr[low] || key > arr[high] || low > high) return -1;

        while (low <= high) {
            middle = (low + high) / 2;
            if (key < arr[middle]) {
                //比关键字大则关键字在左区域
                high = middle - 1;
            } else if (key > arr[middle]) {
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 5;

//        int position = binarySearchWithRecursion(arr, key, 0, arr.length - 1);
        int position = binarySearch(arr, key);

        if (position == -1) {
            System.out.println("查找的是" + key + ",序列中没有该数！");
        } else {
            System.out.println("查找的是" + key + ",找到位置为：" + position);
        }

    }
}
