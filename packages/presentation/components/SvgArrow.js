import React from "react";
import styled, { withTheme } from "styled-components";

const Line = styled.path`
    stroke: ${props => props.theme.colors.text};
    stroke-width: 2;
`;
const Text = styled.text`
    text-anchor: middle;
    alignment-baseline: central;
    fill: ${props => props.theme.colors.text};
    font-size: ${props => props.theme.fontSizes[0]};
`;
const ArrowEndMarker = withTheme(({ theme, markerId }) => (
    <marker
        id={markerId}
        markerWidth="10"
        markerHeight="10"
        refX="19"
        refY="10"
        orient="auto"
        markerUnits="strokeWidth"
        viewBox="0 0 20 20"
    >
        <path d="M0,0 L5,10 L0,20 L20,10 z" fill={theme.colors.text} />
    </marker>
));

export default function SvgArrow({ path, x, y, children, ...props }) {
    if (props.style && props.style.visibility === "hidden") {
        return null;
    }
    return (
        <g>
            <defs>
                <ArrowEndMarker markerId="arrow" />
            </defs>
            <Line d={path} markerEnd="url(#arrow)" />
            <Text x={x} y={y}>
                {children}
            </Text>
        </g>
    );
}
