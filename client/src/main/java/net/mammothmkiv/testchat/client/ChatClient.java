package net.mammothmkiv.testchat.client;


import net.mammothmkiv.testchat.common.TestPacket;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args)
    {
        try {
            FormManager.getInstance().showLoginForm();

//            FileInputStream fs = new FileInputStream("test.txt");
//            Socket client = new Socket("127.0.0.1", 25565);
//
//            ObjectOutputStream ous = new ObjectOutputStream(client.getOutputStream());
//
//            TestPacket packet = new TestPacket();
//            packet.value = 42;
//            packet.message = "Variable length message !!!";
//
//            ous.writeObject(packet);

//
//            byte[] buffer = new byte[512];
//
//            int read;
//
//            while (true) {
//                read = fs.read(buffer);
//
//                if (read == -1) {
//                    break;
//                }
//
//                client.getOutputStream().write(buffer, 0, read);
//            }
//
//            fs.close();
            //client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
