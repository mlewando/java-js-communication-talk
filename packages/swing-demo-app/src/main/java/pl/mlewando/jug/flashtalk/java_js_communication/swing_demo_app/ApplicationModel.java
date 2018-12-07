package pl.mlewando.jug.flashtalk.java_js_communication.swing_demo_app;

import java.time.LocalDateTime;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

class ApplicationModel {
    private Subject<ApplicationState> state = PublishSubject.create();

    void setText(String text) {
        state.onNext(new ApplicationState(text, LocalDateTime.now()));
    }

    Observable<ApplicationState> getState() {
        return state;
    }
}
