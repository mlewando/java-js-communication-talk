# Java <-> JS communication talk

## Example

### Prerequisites

- Java 11
- gradle
- Node
- pnpm

### Java browser

In the provided example [JxBrowser](https://www.teamdev.com/jxbrowser) as Java browser. For this to work correctly, you need a license. You can download 30 days license from their [page](https://www.teamdev.com/jxbrowser#evaluate). After that just put `license.jar` file into `packages/swing-demo-app/lib/` directory.

### Starting static file server with JS application

- enter `packages/js-demo-app` directory
- execute command `pnpm run start`
- the server should be available on <http://localhost:1234>

In case of port 1234 being used on your PC, other random free port will be chosen. The correct url will be listed on the console.

Any change to files in `packages/js-demo-app/src` will be automatically refreshed in the browser.

### Starting Java example application

- enter `packages/js-demo-app`
- execute command `./gradlew run`

--------------------------------------------------------------------------------

## Presentation

- enter `packages/presentation`
- execute command `pnpm run start`
- presentation should be available on <http://localhost:8080>

Presentation was done with help of [mdx-deck](https://github.com/jxnblk/mdx-deck) library.
