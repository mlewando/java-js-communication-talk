package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

final class ApplicationState {
    private final String text;
    private final LocalDateTime time;

    @JsonCreator
    ApplicationState(@JsonProperty("text") String text, @JsonProperty("time") LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "(" + time.format(DateTimeFormatter.ISO_DATE_TIME) + ") - " + text;
    }
}
