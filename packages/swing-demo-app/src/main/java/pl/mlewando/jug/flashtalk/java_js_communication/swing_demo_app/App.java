package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    App() {
        setTitle("JUG Flashtalk - Java-JS communication");
        setLayout(new BorderLayout());
        add(new TopPanel(System.out::println), BorderLayout.PAGE_START);
        pack();
    }

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        var app = new App();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
