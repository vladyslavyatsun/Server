package sample;

/**
 * Created by dog on 5/22/16.
 */
public class ErrorCorrector {

    public int[] findErrors(int [] deltas, int array []){
        boolean f = false;
        StringBuilder p = new StringBuilder();
        StringBuilder q = new StringBuilder();

        int deltaQ = -1;
        int deltaP;
        for (int j = deltas.length-1; j > 0; j--) {
            if(deltas[j] == 0){ p.append('0'); q.append('0'); continue;}
            if(deltas[j] == deltas[0]){ p.append('1'); q.append('1'); continue;}
            if(deltas[j] != 0 && deltas[j] != deltas[0] && f == false){p.append('0'); q.append('1');f = true; deltaQ = deltas[j]; continue;}
            if(deltas[j] != 0 && deltas[j] != deltas[0] && f == true){
                if(deltas[j] == deltaQ){
                    q.append('1'); p.append('0');
                } else {
                    q.append('0'); p.append('1');
                }
            }
        }
        deltaP = deltaQ ^ deltas[0];

        array[Integer.parseInt(q.toString(), 2)-1] ^= deltaQ;
        array[Integer.parseInt(p.toString(), 2)-1] ^= deltaP;

        return array;
    }


    public int[] findErrors2(int [] deltasC, int[] deltasS, int [] array){
        boolean f = false;
        StringBuilder p = new StringBuilder();
        StringBuilder q = new StringBuilder();

        int deltaQ = -1;
        int deltaP;

        for (int j = deltasC.length-1; j > 0; j--) {
            if(deltasS[j] == 0){ p.append('0'); q.append('0'); continue;}
        }

        return null;
    }
}
