package code_Studio;

// (Problem Statement):- Given a matrix if an element in the matrix is 0 then you will have to
// set its entire column and row to 0 and then return the matrix.

public class Matrix3D {

    public static void itarateMatrix(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int k = 0; k < arr.length; k++) {

                System.out.print(arr[i][k] + " ");

            }

            System.out.println();
        }

    }

    public static void findLoaction() {

        // intaializing input array here. (Manually) (To convenient relace with nasted loops)
        int[][] arr = new int[4][4];

        arr[0][0] = 2;
        arr[0][1] = 1;
        arr[0][2] = 6;
        arr[0][3] = 9;
        arr[1][0] = 9;
        arr[1][1] = 0;
        arr[1][2] = 5;
        arr[1][3] = 9;
        arr[2][0] = 9;
        arr[2][1] = 5;
        arr[2][2] = 9;
        arr[2][3] = 9;
        arr[3][0] = 3;
        arr[3][1] = 2;
        arr[3][2] = 1;
        arr[3][3] = 3;

        // print the array by calling function
        System.out.println("---Then---");
        itarateMatrix(arr);

        int j = 0;

        // Initializing 2 array for save the location of 0 from input array in
        // Cordinates X & Y
        int[] x = new int[arr.length];
        int[] y = new int[arr.length];

        int ind = 0;

        // first set the array X & Y value 0 (default value of array) to -1
        while (ind != arr.length) {

            x[ind] = -1;
            y[ind] = -1;
            ind++;
        }

        // save into X & Y array of the location of 0 by iterating 2D array
        for (int i = 0; i < arr.length; i++) {

            for (j = 0; j < arr.length; j++) {

                if (arr[i][j] == 0) {

                    x[i] = i;

                    y[j] = j;
                }

            }

        }

        int m = 0;

        // by iterating X & Y array call the function
        while (m != x.length) {

            if (x[m] != -1 || y[m] != -1) {

                replaceWithZero(arr, x, y);

            }

            m++;
        }

        // after function print the complete output
        System.out.println("---Now---");
        itarateMatrix(arr);

    }

    // Is the function which is replace all value into 0 of X & Y cordinates access
    // the input array 0 location

    public static void replaceWithZero(int[][] arr, int x[], int y[]) {

        int tempX = -1;

        int tempY = -1;

        for (int k = 0; k < x.length; k++) {

            tempX = x[k]; // row

            tempY = y[k]; // column

            for (int i = 0; i < arr.length; i++) {

                if (i == tempX) {

                    for (int j = 0; j < arr.length; j++) {

                        arr[i][j] = 0;

                    }
                }

                for (int j = 0; j < arr.length; j++) {

                    if (j == tempY) {

                        arr[i][j] = 0;

                    }

                }

            }

        }
    }

    public static void main(String[] args) {
        findLoaction();
    }

}


/*

Output Become: (According to input)

---Then---
2 1 6 9 
9 0 5 9
9 5 9 9
3 2 1 3
---Now---
2 0 6 9
0 0 0 0
9 0 9 9
3 0 1 3
*/
