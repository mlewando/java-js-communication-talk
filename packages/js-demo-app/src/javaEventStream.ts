import { Observable, Subject } from "rxjs";
import { filter, map } from "rxjs/operators";

interface JavaEvent {
    readonly streamName: string;
    readonly event: any;
}
const javaEvents = new Subject<JavaEvent>();
(window as any).javaEvent = (streamName: string, event: any) => {
    javaEvents.next({ streamName, event });
};

export function getJavaEvents<T>(streamName: string): Observable<T> {
    return javaEvents.pipe(
        filter(javaEvent => javaEvent.streamName === streamName),
        map(javaEvent => javaEvent.event)
    );
}

export function sendToJava<T>(streamName: string): (event: T) => void {
    return event => (window as any).jsEvent(streamName, JSON.stringify(event));
}
