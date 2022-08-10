import { screen, render } from "@testing-library/react";
import "@testing-library/jest-dom";
import CardDetail from "../index";
import React from "react";

describe("Card Detail Test", () => {
  render(<CardDetail carddetail={undefined} />);
  it("Card Detail Component should Render", () => {
    const stepperElement = screen.getByTestId("carddetail");
    expect(stepperElement).toBeInTheDocument();
  });
});
