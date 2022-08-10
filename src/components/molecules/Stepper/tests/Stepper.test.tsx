import { screen, render } from "@testing-library/react";
import "@testing-library/jest-dom";
import Stepper from "../index";
import React from "react";

describe("Stepper Test Cases", () => {
  render(<Stepper steps={["Hello", "Stepper", "asa"]} activeStep={0} />);
  it("Stepper Component should Render", () => {
    const stepperElement = screen.getByTestId("stepper");
    expect(stepperElement).toBeInTheDocument();
  });
});
