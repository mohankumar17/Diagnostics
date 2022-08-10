import { screen, render } from "@testing-library/react";
import "@testing-library/jest-dom";
import TestDetail from "../index";
import covid from "../../../../assets/icons/covid.png";
import React from "react";

it("Test Detail Card should Render", () => {
  render(
    <TestDetail
      testDisplayIcon={covid}
      testName="abc"
      labName="- abc"
      patientName="abc"
      time="abc"
    />,
  );
  const testElement = screen.getByTestId("testdetail");
  expect(testElement).toBeInTheDocument();
});
