package net.mammothmkiv.testchat.client;

import javax.swing.*;

public class FormManager {
    private static FormManager instance = new FormManager();
    private ClientLoginForm loginForm;
    private GlobalChatForm chatForm;

    private FormManager() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FormManager getInstance() {
        return instance;
    }

    public void showLoginForm() {
        loginForm = new ClientLoginForm();
        ChatCore.getInstance().registerEventHandler(loginForm);
        loginForm.show();
    }

    public void showChatForm() {
        chatForm = new GlobalChatForm();
        ChatCore.getInstance().registerEventHandler(chatForm);
        chatForm.show();
    }

    public void hideLoginForm() {
        ChatCore.getInstance().unregisterEventHandler(loginForm);
        loginForm.dispose();
    }

    public void hideChatForm() {
        ChatCore.getInstance().unregisterEventHandler(chatForm);
        chatForm.dispose();
    }
}
