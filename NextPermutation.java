public class NextPermutation {

    // (Question):  A permutation of integers is an
    //  arrangement of its members into a sequence or linear order.

    public static int[] permutationArray(int a[]) {
// Iterate the array from right to left
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] > a[i - 1]) {
                swap(a, i, i - 1); // 1 2 3 || 1 3 2 || 2 1 3 || 2 3 1
                return a;
            }
        }


        int ind = a.length-1;
        for(int j= 0; j < a.length-1; j++) {

        swap(a, ind, j);   // If {3,2,1} => {1,2,3}
        ind--;
     }
     
        return a;

    }

    // swap between 2 indexs in an array
    public static int[] swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        permutationArray(arr);

        System.out.println("Next Permutation Will be Here:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

// Output:
// Next Permutation Will be Here:
// 1 3 2
