package solution.datastructure.sort;

public abstract class Sorter {

    protected void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public abstract void sort(int[] arr);
}
