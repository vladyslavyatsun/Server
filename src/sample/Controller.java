package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
    private Application application = new Application(8, 4);
    private ErrorCorrector errorCorrector= new ErrorCorrector();
    @FXML
    private Text blockCode;

    @FXML
    private Text deltaS;

    @FXML
    private Text deltaC;

    @FXML
    private Text bigDelta;

    @FXML
    private Text smallDelta;

    @FXML
    private Text result;

    protected void showText(Data data) {
        StringBuilder sb = new StringBuilder();
        int [] block = data.getBlock();
        block[3] = 5;
        block[5] = 4;
        for (int b : block) {
            sb.append(String.format("%4s", Integer.toBinaryString(b)).replace(' ', '0')+" ");
        }
        blockCode.setText(sb.toString());


        int [] c = application.countC(block);
        int [] s = application.countS(block);

        deltaC.setText("C0 = "+String.format("%4s", Integer.toBinaryString(c[0])).replace(' ', '0') +
                "\nC1 = "+String.format("%4s", Integer.toBinaryString(c[1])).replace(' ', '0')+
                "\nC2 = "+String.format("%4s", Integer.toBinaryString(c[2])).replace(' ', '0')+
                "\nC3 = "+String.format("%4s", Integer.toBinaryString(c[3])).replace(' ', '0'));
        deltaS.setText("S1 = "+String.format("%4s", Integer.toBinaryString(s[0])).replace(' ', '0') +
                "\nS2 = "+String.format("%4s", Integer.toBinaryString(s[1])).replace(' ', '0')+
                "\nS3 = "+String.format("%4s", Integer.toBinaryString(s[2])).replace(' ', '0'));

        int deltaC [] = application.countDelta(c, data.getC());
        int deltaS [] = application.countDelta(s, data.getS());

        bigDelta.setText("C0 = "+String.format("%4s", Integer.toBinaryString(deltaC[0])).replace(' ', '0') +
                "\nC1 = "+String.format("%4s", Integer.toBinaryString(deltaC[1])).replace(' ', '0')+
                "\nC2 = "+String.format("%4s", Integer.toBinaryString(deltaC[2])).replace(' ', '0')+
                "\nC3 = "+String.format("%4s", Integer.toBinaryString(deltaC[3])).replace(' ', '0'));
        smallDelta.setText("S1 = "+String.format("%4s", Integer.toBinaryString(deltaS[0])).replace(' ', '0') +
                "\nS2 = "+String.format("%4s", Integer.toBinaryString(deltaS[1])).replace(' ', '0')+
                "\nS3 = "+String.format("%4s", Integer.toBinaryString(deltaS[2])).replace(' ', '0'));

        int resultArray [] = errorCorrector.findErrors(deltaC, block);
        sb = new StringBuilder();
        for (int b : resultArray) {
            sb.append(String.format("%4s", Integer.toBinaryString(b)).replace(' ', '0')+" ");
        }
        result.setText(sb.toString());
    }




}
