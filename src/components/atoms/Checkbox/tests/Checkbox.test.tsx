import Checkbox from "../index";
import { render, screen } from "@testing-library/react";
import "@testing-library/jest-dom/extend-expect";
import React from "react";

test("Renders an Chexkbox", () => {
  render(<Checkbox />);

  const checkboxElement = screen.getByTestId("checkboxes");

  expect(checkboxElement).toBeInTheDocument();
});
