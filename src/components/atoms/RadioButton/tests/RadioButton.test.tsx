import { screen, render } from "@testing-library/react";
import "@testing-library/jest-dom";
import RadioButton from "../index";
import React from "react";

it("Radio Button should Render", () => {
  render(<RadioButton value="abc" />);
  const radioElement = screen.getByTestId("radioButton");
  expect(radioElement).toBeInTheDocument();
});
