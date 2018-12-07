package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

class JsEvent {

    private final String name;
    private final String jsonPayload;

    JsEvent(String name, String jsonPayload) {
        this.name = name;
        this.jsonPayload = jsonPayload;
    }

    public String getName() {
        return name;
    }

    public String getJsonPayload() {
        return jsonPayload;
    }
}
