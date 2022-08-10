import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageTestimonials from "..";

test("HomePageTestimonials Render", async () => {
  render(<HomePageTestimonials />);
  const reviewCard1 = screen.findByTestId("reviewCard1");
  expect(reviewCard1).toBeDefined();
  const reviewCard2 = screen.findByTestId("reviewCard2");
  expect(reviewCard2).toBeDefined();
  const reviewCard3 = screen.findByTestId("reviewCard3");
  expect(reviewCard3).toBeDefined();
});
