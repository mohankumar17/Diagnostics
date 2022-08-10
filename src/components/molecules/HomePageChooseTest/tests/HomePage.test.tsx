import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageChooseTest from "..";

test("HomePageChooseTest Render", async () => {
  render(<HomePageChooseTest />);
  const testInfoCard1 = screen.findByTestId("testInfoCard1");
  expect(testInfoCard1).toBeDefined();
  const testInfoCard2 = screen.findByTestId("testInfoCard2");
  expect(testInfoCard2).toBeDefined();
  const testInfoCard3 = screen.findByTestId("testInfoCard3");
  expect(testInfoCard3).toBeDefined();
});
