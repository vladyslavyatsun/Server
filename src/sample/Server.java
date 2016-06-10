package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dog on 6/9/16.
 */
public class Server extends Thread{
    private Controller controller;
    public Server(Controller controller){
        this.controller = controller;
    }


    public void run(){
        int port = 1488; // случайный порт (может быть любое число от 1025 до 65535)
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
            System.out.println();

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataOutputStream out = new DataOutputStream(sout);
            ObjectInputStream ois = new ObjectInputStream(sin);
            String line = null;


            boolean f = true;


            while(true) {
                Data data = (Data) ois.readObject();
                out.writeUTF("success"); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                controller.showText(data);
                System.out.println("Waiting for the next line...");
                System.out.println();
            }
        } catch(Exception x) {
            x.printStackTrace();
            run(); }
    }


}
