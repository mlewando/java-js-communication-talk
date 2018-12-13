package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSFunctionCallback;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.events.ScriptContextAdapter;
import com.teamdev.jxbrowser.chromium.events.ScriptContextEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

class BrowserPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Browser browser;
    private final ObjectMapper objectMapper;

    BrowserPanel() {
        objectMapper = new ObjectMapper()
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        browser = new Browser();
        var view = new BrowserView(browser);

        objectMapper.configure(
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                false);

        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);

        browser.loadURL("http://localhost:1234");
    }

    void close() {
        browser.dispose();
    }

    private JSValue getWindowObject() {
        return browser.executeJavaScriptAndReturnValue(
                browser.getJSContext().getFrameId(),
                "window");
    }
}
