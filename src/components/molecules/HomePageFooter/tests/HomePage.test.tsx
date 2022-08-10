import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageFooter from "..";

test("HomePageFooter Render", async () => {
  render(<HomePageFooter />);
  const footer = screen.findByTestId("footer");
  expect(footer).toBeDefined();
});
