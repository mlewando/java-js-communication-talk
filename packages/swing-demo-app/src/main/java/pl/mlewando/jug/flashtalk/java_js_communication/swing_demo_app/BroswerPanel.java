package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import io.reactivex.functions.Consumer;

class BroswerPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Browser browser;
    private final ObjectMapper objectMapper;

    BroswerPanel() {
        objectMapper = new ObjectMapper().registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
        browser = new Browser();
        var view = new BrowserView(browser);

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);

        browser.loadURL("http://localhost:1234");
    }

    void close() {
        browser.dispose();
    }

    <T> Consumer<T> sendToJs(String streamName) {
        return event -> browser.executeJavaScript(getJsEventCode(streamName, event));
    }

    private <T> String getJsEventCode(String streamName, T event) throws JsonProcessingException {
        return String.format("window.javaEvent(\"%s\", %s)", streamName, objectMapper.writeValueAsString(event));
    }
}
