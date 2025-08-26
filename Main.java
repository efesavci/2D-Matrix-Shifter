import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        boolean readInt = false;
        String line = "";
        int val = 0;
        boolean readBorders = false;
        String lengthStr, widthStr;
        int length = 0, width = 0;
        System.out.println("Enter the length and width of your wanted matrice: ");
        while(!readBorders) {
            try{
                System.out.print("Length: ");
                lengthStr = br.readLine();
                length = Integer.parseInt(lengthStr);
                System.out.print("Width: ");
                widthStr = br.readLine();
                width = Integer.parseInt(widthStr);
                readBorders = true;
            }catch (NumberFormatException ne) {
                System.out.println("Invalid value, please enter an integer value.");
            }
        }
        System.out.print("Enter an amount to shift the matrix: ");
        while(!readInt) {
            try {
                line = br.readLine();
                val = Integer.parseInt(line);
                readInt = true;
            } catch (NumberFormatException ne) {
                System.out.println("Invalid value, please enter an integer value.");
            }
        }
        int idx = 1;
        int[][] arr = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                arr[i][j] = idx++;
             }
        }
        System.out.println("Shifting the matrice: "+Arrays.deepToString(arr)+" by "+val+".");
        System.out.println("Resulting array: "+Arrays.deepToString(ShiftArray(arr, val)));
    } // Only requirement is, that the inner matrices should be the same size.

    public static int[][] ShiftArray(int[][] arr, int shiftAmount){
        int length = arr.length * arr[0].length;

        int realShiftAmt = shiftAmount > 0 ? shiftAmount % length : (length - ((shiftAmount * -1) % length));
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