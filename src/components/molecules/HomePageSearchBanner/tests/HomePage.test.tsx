import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageSearchBanner from "..";

test("HomePageSearchBanner Render", async () => {
  render(<HomePageSearchBanner />);
  const searchBar = screen.findByTestId("searchBar");
  expect(searchBar).toBeDefined();
  const banner = screen.findByTestId("banner");
  expect(banner).toBeDefined();
});
