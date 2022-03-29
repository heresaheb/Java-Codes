package code_Studio;

//(Problem Statement):- Given an integer N, return the first N rows of Pascal's triangle

public class PascalsTriangle {

    // From arr[1][0] to all value calculate and store into in array called sumVal[]
    public static void sumTheVal(int[][] arr) {
        int[] sumVal = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length + 1; j++) {

                // j if j reach the limit break the inner loop
                if (j + 1 == sumVal.length) {
                    break;
                }

                sumVal[j] = arr[i][j] + arr[i][j + 1];

            }

            // if i== row not reaches it's limit call the Func
            if (i + 1 != arr.length) {

                setValue(i + 1, arr, sumVal);
            }

        }

    }

    // replace all val= 1 (stored val) values by sumVal
    // index = sumVal (row +1)
    public static void setValue(int index, int arr[][], int[] sumVal) {

        for (int i = index; i <= index; i++) {
            for (int j = 1; j < i; j++) {

                // [j-1] to leave the last val as it, which val is= 1
                arr[i][j] = sumVal[j - 1];

            }
        }

    }

    public static void makeTree(int input) {

        int[][] arr = new int[input][input];

        // set the value array = 1
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < i + 1; j++) {

                arr[i][j] = 1;

            }

        }

        // after set the all val=1 call the func
        sumTheVal(arr);

        // print the final output

        System.out.println("Pascal's Triangle ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");

                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        makeTree(5);

    }

}

/*
 * 1. all defalut val replace by 1 input (arr) 2D array.
 * 2. sum the between 2 values store in another array.
 * 3. replace middle values by sum values.
 * 4. print the ready output.
 */

 /*

    Pascal's Triangle 
    1 
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1

 */