import { hack as theme } from "mdx-deck/themes";

export default {
    ...theme,
    colors: {
        ...theme.colors
    },
    css: {
        background:
            "radial-gradient(ellipse at center, rgba(30,30,30,0.9) 0%, #000000 100%), url(./resources/background/2.png) center center no-repeat"
    }
};
