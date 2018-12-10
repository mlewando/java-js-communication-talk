import { constants, withDeck } from "mdx-deck";
import React from "react";

export default withDeck(
    class Step extends React.Component {
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
                        steps: this.getSteps(state)
                    }
                }
            }));
        }

        render() {
            const { step, mode } = this.props.deck;

            if (mode === constants.modes.grid) {
                return children;
            }

            if (
                typeof window !== "undefined" &&
                window.navigator.userAgent.includes("Print/PDF")
            ) {
                return children;
            }

            return React.cloneElement(this.props.children, {
                style: {
                    ...((this.props.children.props || {}).style || {}),
                    visibility: this.isVisible() ? "visible" : "hidden"
                }
            });
        }

        isVisible() {
            if (this.props.exact === true) {
                return this.props.deck.step === this.props.step;
            }
            if (this.props.toStep && this.props.toStep > this.props.step) {
                return (
                    this.props.deck.step >= this.props.step &&
                    this.props.deck.step < this.props.toStep
                );
            }
            return this.props.deck.step >= this.props.step;
        }

        getSteps(state) {
            const currentSteps =
                (state.metadata &&
                    state.metadata[this.props.deck.index] &&
                    state.metadata[this.props.deck.index].steps) ||
                0;
            if (this.props.exact === true) {
                return Math.max(this.props.step + 1, currentSteps);
            }
            if (this.props.toStep && this.props.toStep > this.props.step) {
                return Math.max(this.props.toStep, currentSteps);
            }
            return Math.max(this.props.step, currentSteps);
        }
    }
);
