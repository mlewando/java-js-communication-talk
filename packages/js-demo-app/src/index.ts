import { fromEvent } from "rxjs";
import { map } from "rxjs/operators";
import { getJavaEvents, sendToJava } from "./javaEventStream";

const rootElement = document.getElementById("root");
rootElement.innerHTML = "JUG demo application";

getJavaEvents<object>("state")
    .pipe(
        map(event => JSON.stringify(event, undefined, 4)),
        map(json => `<p>state:<br/><pre>${json}</pre></p>`)
    )
    .subscribe(html => (rootElement.innerHTML = html));

fromEvent(document.getElementById("send"), "click")
    .pipe(map(() => "js event"))
    .subscribe(sendToJava("text"));
