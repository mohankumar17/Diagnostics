import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageFAQ from "..";

test("HomePageFAQ Render", async () => {
  render(<HomePageFAQ />);
  const faq1 = screen.findByTestId("faq1");
  expect(faq1).toBeDefined();
  const faq2 = screen.findByTestId("faq2");
  expect(faq2).toBeDefined();
  const faq3 = screen.findByTestId("faq3");
  expect(faq3).toBeDefined();
  const faq4 = screen.findByTestId("faq4");
  expect(faq4).toBeDefined();
});
