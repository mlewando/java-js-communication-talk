document.getElementById("root").innerHTML = "OK, it works";

(window as any).javaEvent = (name: string, event: any) => {
    document.getElementById(
        "root"
    ).innerHTML = `<p>${name}:<br /><pre>${JSON.stringify(
        event,
        undefined,
        4
    )}</pre></p>`;
};
