import { map } from "rxjs/operators";
import { getJavaEvents } from "./javaEventStream";

const rootElement = document.getElementById("root");
rootElement.innerHTML = "JUG demo application";

getJavaEvents<object>("state")
    .pipe(
        map(event => JSON.stringify(event, undefined, 4)),
        map(json => `<p>state:<br/><pre>${json}</pre></p>`)
    )
    .subscribe(html => (rootElement.innerHTML = html));
