import React from "react";
import { render, screen } from "@testing-library/react";
import MainPageBanner from "..";

test("Main Page Banner Render", () => {
  render(<MainPageBanner />);

  const bannerHeadingEl = screen.getByTestId("bannerHeadingTest");
  expect(bannerHeadingEl.textContent).toBe("60% off on your first order");

  const bannerCaptionEl = screen.getByTestId("bannerCaptionTest");
  expect(bannerCaptionEl.textContent).toBe("Your health is our priority");
});
