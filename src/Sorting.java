public class Sorting {

    static void insertion_sort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {  //for (int i : arr)
            int temp = arr[i];
            int j = i - 1;

            // Compare key with elements on the left of it
            while (j > -1 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key at the correct position
            arr[j + 1] = temp;
        }

        System.out.println("\ninsertion_sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void quicksort(int[] arr, int start, int end ){

        int mid = (start+end)/2;
        int i = start;
        int j = end;
        int pivot = arr[mid];
        while (i<=j){
            while (arr[i] < pivot){
                i++;
            }
            while (arr[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;

            }
        }

        if(start < j){
            quicksort(arr,start,j);
        }
        if(end>i){
            quicksort(arr,i,end);
        }

    }

    static void mergeSort(int[] arr) {
        if (arr.length < 2) {  // base case
            return;
        }
        int mid = arr.length/2;


        int[] left = new int[mid];
        int[] right = new int[arr.length-mid];


        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];  // left array
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];  // right array
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);

    }


    static void merge(int[] left, int[] right,int[] array){
        int leftLen = array.length / 2;
        int rightLen = array.length - leftLen;
        int i = 0;  // array
        int l = 0;  // left
        int r = 0;  // right
        while(l < leftLen && r < rightLen) {
            if(left[l] < right[r]) {
                array[i] = left[l];
                i++;
                l++;
            }
            else {
                array[i] = right[r];
                i++;
                r++;
            }
        }
        while (l < leftLen){        //  all reminder left element add to array
            array[i] = left[l];
            i++;
            l++;
        }
        while (r < rightLen){       //  all reminder right element add to array
            array[i] = right[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {


        int[] arr = {9, 14, 3, 2, 43, 11, 58, 22};

        long startTime, endTime;
        double duration1, duration2, duration3;


        System.out.println("Original array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        startTime = System.nanoTime();
        insertion_sort(arr);
        endTime = System.nanoTime();
        duration1 = (endTime - startTime) / 1_000_000_000.0;


        startTime = System.nanoTime();
        quicksort(arr,0, arr.length-1);
        System.out.println("\nQuick sort:");
        for(int num : arr){
            System.out.print(num + " ");
        }
        endTime = System.nanoTime();
        duration2 = (endTime - startTime) / 1_000_000_000.0;



        startTime = System.nanoTime();
        mergeSort(arr);
        System.out.println("\nMerge Sort:");
        for(int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        endTime = System.nanoTime();
        duration3 = (endTime - startTime) / 1_000_000_000.0;


        System.out.println("     ");
        System.out.println("\nExecution time of insertion_sort: " + duration1 + " seconds");
        System.out.println("\nExecution time of Quick sort: " + duration2 + " seconds");
        System.out.println("\nExecution time of Merge Sort: " + duration3 + " seconds");


    }
}
