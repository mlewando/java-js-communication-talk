import { map } from "rxjs/operators";

import { javaEventStream } from "./javaEventStream";

const rootElement = document.getElementById("root");
javaEventStream("state")
    .pipe(
        map(state => JSON.stringify(state, undefined, 4)),
        map(state => `<p>state:<br\><pre>${state}</pre></p>`)
    )
    .subscribe(state => (rootElement.innerHTML = state));
