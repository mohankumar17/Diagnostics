import "@testing-library/jest-dom/extend-expect";
import { render, screen, fireEvent } from "@testing-library/react";
import React from "react";
import Header from "../index";

it("renders navbar", () => {
  render(<Header location="abc" />);
  const testIcon = screen.getByTestId("header");
  expect(testIcon).toBeInTheDocument();
});

it("tab switch", () => {
  render(<Header location="abc" />);
  const tabs = screen.getAllByRole("tab");
  fireEvent.click(tabs[0]);
  expect(tabs[0]).toBeInTheDocument();
});
