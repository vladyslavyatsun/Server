package sample;

/**
 * Created by dog on 5/20/16.
 */
public class Application {
    private final int n;
    private final int m;

    public Application(int n, int m){
        this.n = n;
        this.m = m;
    }


    public int countZeroComponent(int [] B){
        int C0 = B[0];
        for (int i = 1; i < B.length; i++) {
            C0 ^= B[i];
        }
        return C0;
    }

    public int [] countC(int [] B){
        return toResultArray(B, n);
    }

    public int[] countS(int [] B){
        int size = Integer.toBinaryString(m-1).toCharArray().length; // size = log2/m
        int [][] L =  new int[B.length][size];
        for (int i = 0; i < B.length; i++) {
            L[i] = toResultArray(toIntegerArray(B[i]), size);
        }


        int [] resultArray = new int[m - 1];
        int k = 0;
        boolean f;
        int result;
        for (int mask = 1; mask < n; mask*=2) {
            f = true;
            for (int i = 0, index = 1; i < L.length; i++, index++) {
                if ((mask & index) != 0) {
                    result = multPolinom(L[i], index);
                    if(result == 0) continue;
                    if (f) {
                        resultArray[k] = result;
                        f = false;
                    } else {
                        resultArray[k] ^= result;
                    }
                }
            }
            k++;
        }

        return resultArray;
    }


    private int multPolinom(int array[], int index){
        int result = array[0]*index;
        for (int i = 1; i < array.length; i++) {
            result ^= (array[i]<<1)*index;
        }
        return result;
    }

    private int [] toResultArray(int [] B, int maskLength){
        int [] resultArray = new int[Integer.toBinaryString(maskLength).toCharArray().length];
        resultArray[0] = countZeroComponent(B);
        boolean f;
        for (int mask = 1, k = 1; mask < maskLength; mask*=2, k++) {
            f = true;
            for (int i = 0, index = 1; i < B.length; i++, index++) {
                if ((mask & index) != 0) {
                    if (f) {
                        resultArray[k] = B[i];
                        f = false;
                    } else {
                        resultArray[k] ^= B[i];
                    }
                }
            }
        }
        return resultArray;
    }

    public int[] toIntegerArray(int number){
        char [] temp = Integer.toBinaryString(number).toCharArray();
        int [] array = new int[m];
        for (int i = temp.length-1, j = array.length-1; i >= 0; i--, j--) {
            array[j] = temp[i] - 48;
        }
        return array;
    }


    public int[] countDelta(int s[], int r[]){
        int [] resultArray = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            resultArray[i] = s[i]^r[i];
        }
        return resultArray;
    }

}
