package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import io.reactivex.disposables.CompositeDisposable;

public class App extends JFrame {

    private static final long serialVersionUID = 1L;

    App(ApplicationModel model) {
        setTitle(
                "JUG Flashtalk - Java-JS communication");
        setLayout(new BorderLayout());
        add(new TopPanel(model::setText),
                BorderLayout.PAGE_START);

        var swingPage = new PagePanel();
        var browserPage = new BrowserPanel();
        add(swingPage, BorderLayout.CENTER);

        pack();
        setSize(400, 400);

        final var subscription = new CompositeDisposable(
                model.getState().subscribe(swingPage));

        addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                subscription.dispose();
                browserPage.close();
            }
        });
    }

    public static void main(String[] args) {
        var app = new App(new ApplicationModel());
        app.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
