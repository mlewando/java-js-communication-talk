package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

class BroswerPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Browser browser;

    BroswerPanel() {
        browser = new Browser();
        var view = new BrowserView(browser);

        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);

        browser.loadURL("http://google.com");
    }

    void close() {
        browser.dispose();
    }
}
