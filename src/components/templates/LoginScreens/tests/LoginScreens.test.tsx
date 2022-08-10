import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import React from "react";
import LoginScreens from "../index";

it("renders template", () => {
  render(<LoginScreens />);
  const template = screen.getByTestId("loginscreen");
  expect(template).toBeInTheDocument();
});
