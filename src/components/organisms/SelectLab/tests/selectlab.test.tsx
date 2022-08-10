import React from "react";
import { render, screen } from "@testing-library/react";
import Selectlab from "../index";

test("Main Page Banner Render", () => {
  render(<Selectlab />);

  const testHeadingEl = screen.getByTestId("text1");
  expect(testHeadingEl.textContent).toBe("Add Test");

  const packageHeadingEl1 = screen.getByTestId("text2");
  expect(packageHeadingEl1.textContent).toBe("Select lab");
  const packageHeadingEl2 = screen.getByTestId("text3");
  expect(packageHeadingEl2.textContent).toBe("Sort");
});
