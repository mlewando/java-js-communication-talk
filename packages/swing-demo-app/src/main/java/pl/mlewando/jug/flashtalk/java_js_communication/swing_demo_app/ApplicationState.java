package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.time.LocalDateTime;

final class ApplicationState {
    private final String text;
    private final LocalDateTime time;

    ApplicationState(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}
