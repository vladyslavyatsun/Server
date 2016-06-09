package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Arrays;

public class Controller {
    private Application application = new Application(8, 4); // // TODO: cast to overall type
    private Server client = new Server();
    
    @FXML
    private Text smallDelta;

    @FXML
    private Text bigDelta;

    @FXML
    private TextField code;

    @FXML 
    protected void handleSubmitButtonAction(ActionEvent event) {
        System.out.println(code.getText());

        char bytes [] = code.getText().replaceAll(" ", "").toCharArray();

        System.out.println(Arrays.toString(bytes));


        int [] result = new int[bytes.length/4];//28 7 4
        for (int i = 0, j = 0; i < bytes.length; i++, j++) {
            result[j] = (bytes[i]-48)*8+(bytes[++i]-48)*4+(bytes[++i]-48)*2+(bytes[++i]-48)*1;
        }
        System.out.println(Arrays.toString(result));
        
        int [] c = application.countC(result);
        int [] s = application.countS(result);

        
        bigDelta.setText("C0 = "+String.format("%4s", Integer.toBinaryString(c[0])).replace(' ', '0') +
                "\nC1 = "+String.format("%4s", Integer.toBinaryString(c[1])).replace(' ', '0')+
                "\nC2 = "+String.format("%4s", Integer.toBinaryString(c[2])).replace(' ', '0')+
                "\nC3 = "+String.format("%4s", Integer.toBinaryString(c[3])).replace(' ', '0'));
        smallDelta.setText("S1 = "+String.format("%4s", Integer.toBinaryString(s[0])).replace(' ', '0') +
                "\nS2 = "+String.format("%4s", Integer.toBinaryString(s[1])).replace(' ', '0')+
                "\nS3 = "+String.format("%4s", Integer.toBinaryString(s[2])).replace(' ', '0'));

        client.sendData(new Data(result, c, s));
    }


}
