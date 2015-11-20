package net.mammothmkiv.testchat.client;

public class ChatClient {

    public static void main(String[] args)
    {
        try {
            FormManager.getInstance().showLoginForm();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
