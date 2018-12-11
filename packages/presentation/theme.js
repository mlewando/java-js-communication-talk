import { hack as darkBase, swiss as lightBase } from "mdx-deck/themes";

const dark = {
    ...darkBase,
    css: {
        ...darkBase.css,
        background:
            "radial-gradient(ellipse at center, rgba(30,30,30,0.9) 0%, #000000 100%), url(./resources/background/2.png) center center no-repeat"
    }
};
const light = {
    ...lightBase,
    css: {
        ...lightBase.css,
        fontSize: "16px",
        "@media screen and (min-width:64em)": {
            fontSize: "32px"
        },
        background:
            "radial-gradient(ellipse at center, #FFFFFF 0%, #FFFFFF 50%, rgba(230,230,230,0.90) 100%), url(./resources/background/2.png) center center no-repeat"
    }
};

export default dark;
