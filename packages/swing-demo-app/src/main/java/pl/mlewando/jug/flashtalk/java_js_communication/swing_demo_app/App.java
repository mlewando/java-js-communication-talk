package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    App(ApplicationModel model) {
        setTitle("JUG Flashtalk - Java-JS communication");
        setLayout(new BorderLayout());
        add(new TopPanel(model::setText), BorderLayout.PAGE_START);
        var page = new PagePanel();
        add(page, BorderLayout.CENTER);
        pack();
        setSize(400, 200);

        final var subscription = model.getState().subscribe(page);

        addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                subscription.dispose();
            }
        });
    }

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        var app = new App(new ApplicationModel());
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
