import { withDeck } from "mdx-deck";
import React from "react";

export default withDeck(
    class WebView extends React.Component {
        constructor(props) {
            super(props);
        }

        componentDidMount() {
            this.props.deck.update(state => ({
                metadata: {
                    ...state.metadata,
                    [this.props.deck.index]: {
                        ...((state.metadata || [])[this.props.deck.index] ||
                            {}),
                        steps: 1
                    }
                }
            }));
        }

        render() {
            const { step, mode } = this.props.deck;
            const headerStyles = {};
            if (step > 0) {
                headerStyles.textDecoration = "line-through";
            }

            return (
                <React.Fragment>
                    <h1 style={headerStyles}>WebView</h1>
                    <h2 style={{ visibility: step > 0 ? "visible" : "hidden" }}>
                        Legacy system
                    </h2>
                </React.Fragment>
            );
        }
    }
);
