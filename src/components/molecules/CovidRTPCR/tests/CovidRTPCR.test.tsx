import React from "react";
import { render, screen } from "@testing-library/react";
import CovidRTPCR from "..";

test("Main Page Banner Render", () => {
  render(<CovidRTPCR />);

  const testHeadingEl = screen.getByTestId("testHeading");
  expect(testHeadingEl.textContent).toBe("Covid RTPCR Test");

  const packageHeadingEl = screen.getByTestId("packageHeading");
  expect(packageHeadingEl.textContent).toBe(
    "Why you should book this package?",
  );
});
