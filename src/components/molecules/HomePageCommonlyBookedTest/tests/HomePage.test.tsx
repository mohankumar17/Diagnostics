import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageChooseTest from "..";

test("HomePageChooseTest Render", async () => {
  render(<HomePageChooseTest />);
  const testBox1 = screen.findByTestId("testBox1");
  expect(testBox1).toBeDefined();
  const testBox2 = screen.findByTestId("testBox2");
  expect(testBox2).toBeDefined();
  const testBox3 = screen.findByTestId("testBox3");
  expect(testBox3).toBeDefined();
  const testBox4 = screen.findByTestId("testBox4");
  expect(testBox4).toBeDefined();
  const testBox5 = screen.findByTestId("testBox5");
  expect(testBox5).toBeDefined();
  const testBox6 = screen.findByTestId("testBox6");
  expect(testBox6).toBeDefined();
  const testBox7 = screen.findByTestId("testBox7");
  expect(testBox7).toBeDefined();
  const testBox8 = screen.findByTestId("testBox8");
  expect(testBox8).toBeDefined();
});
