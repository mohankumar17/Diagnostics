import React from "react";
import { render, screen } from "@testing-library/react";
import MainPageFooter from "..";

test("Main Page Footer Render", () => {
  render(<MainPageFooter />);
  const footerHeadingEl = screen.getByTestId("footerLogoTest");

  expect(footerHeadingEl.textContent).toBe("Zemoso Diagnostics");
});
