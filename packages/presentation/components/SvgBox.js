import React from "react";
import styled from "styled-components";

const Box = styled.rect`
    stroke-width: 2;
    fill: transparent;
    stroke: ${props => props.theme.colors.text};
`;
const Text = styled.text`
    text-anchor: middle;
    alignment-baseline: central;
    fill: ${props => props.theme.colors.text};
    font-size: ${props => props.theme.fontSizes[1]};
`;

export default function SvgBox({ x = 0, y = 0, w, h, children, ...props }) {
    if (props.style && props.style.visibility === "hidden") {
        return null;
    }
    return (
        <g transform={`translate(${x}  ${y})`}>
            <Box width={w} height={h} />
            <Text x={w / 2} y={h / 2}>
                {children}
            </Text>
        </g>
    );
}
