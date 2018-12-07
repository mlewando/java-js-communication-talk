import { fromEvent } from "rxjs";
import { map } from "rxjs/operators";

import { javaEventStream, sendToJava } from "./javaEventStream";

const rootElement = document.getElementById("root");
javaEventStream("state")
    .pipe(
        map(state => JSON.stringify(state, undefined, 4)),
        map(state => `<p>state:<br\><pre>${state}</pre></p>`)
    )
    .subscribe(state => (rootElement.innerHTML = state));

fromEvent(document.getElementById("send"), "click")
    .pipe(
        map(() => ({
            text: "data from js",
            time: "2018-12-07T22:30:48.0205918"
        }))
    )
    .subscribe(sendToJava("state"));
