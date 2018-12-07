import { Observable, Subject } from "rxjs";

const streams: { [name: string]: Subject<any> } = {};
(window as any).javaEvent = (name: string, event: any) => {
    streams[name] = streams[name] || new Subject();
    streams[name].next(event);
};
export function javaEventStream<T>(name: string): Observable<T> {
    streams[name] = streams[name] || new Subject();
    return streams[name];
}
