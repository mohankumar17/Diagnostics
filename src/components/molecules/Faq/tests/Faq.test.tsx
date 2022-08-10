import { screen, render } from "@testing-library/react";
import "@testing-library/jest-dom";
import Faq from "../index";
import React from "react";

it("Faq should render", () => {
  render(<Faq content="abc" label="abc" />);
  const radioElement = screen.getByTestId("faq");
  expect(radioElement).toBeInTheDocument();
});
