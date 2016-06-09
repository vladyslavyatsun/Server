package sample;

/**
 * Created by dog on 6/9/16.
 */
public class Data {
    int [] block;
    int c [];
    int s [];

    public Data(int[] block, int[] c, int[] s) {
        this.block = block;
        this.c = c;
        this.s = s;
    }

    public int[] getBlock() {
        return block;
    }

    public void setBlock(int[] block) {
        this.block = block;
    }

    public int[] getC() {
        return c;
    }

    public void setC(int[] c) {
        this.c = c;
    }

    public int[] getS() {
        return s;
    }

    public void setS(int[] s) {
        this.s = s;
    }
}
