import React from "react";
import { render, screen } from "@testing-library/react";
import SelectAddress from "..";

test("Main Page Banner Render", () => {
  render(<SelectAddress />);

  const testHeadingEl = screen.getByTestId("heading");
  expect(testHeadingEl.textContent).toBe("Select Address");

  const packageHeadingEl = screen.getByTestId("heading2");
  expect(packageHeadingEl.textContent).toBe("Add Address");
});
