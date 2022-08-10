import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import HomePageWhyChooseUs from "..";

test("HomePageWhyChooseUs Render", async () => {
  render(<HomePageWhyChooseUs />);
  const featureBox1 = screen.findByTestId("featureBox1");
  expect(featureBox1).toBeDefined();
  const featureBox2 = screen.findByTestId("featureBox2");
  expect(featureBox2).toBeDefined();
  const featureBox3 = screen.findByTestId("featureBox3");
  expect(featureBox3).toBeDefined();
  const featureBox4 = screen.findByTestId("featureBox4");
  expect(featureBox4).toBeDefined();
  const featureBox5 = screen.findByTestId("featureBox5");
  expect(featureBox5).toBeDefined();
  const featureBox6 = screen.findByTestId("featureBox6");
  expect(featureBox6).toBeDefined();
});
