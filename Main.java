import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.deepToString(ShiftArray(arr, 2)));

    } // Only requirement is, that the inner matrices should be the same size.

    public static int[][] ShiftArray(int[][] arr,int ShiftAmount){
        int length = arr.length * arr[0].length;
        int realShiftAmt = ShiftAmount % (length);
        int[] temp = new int[length];
        int count = realShiftAmt;
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                count = (count % length);
                temp[count++] = ints[j];
            }
        }
      count = 0;
      for (int i = 0; i < arr.length; i++){
          for(int j = 0 ; j < arr[0].length; j++){
              arr[i][j] = temp[count++];
          }
      }
        return arr;
    }
}