import React from "react";
import { screen, render } from "@testing-library/react";
import ReportDetail from "../index";

test("Report Detail Render for completed test", () => {
  render(
    <ReportDetail
      isCompleted={true}
      labName="Los Altos Center Lab"
      testName="Covid RTPCR Test"
      dateTime="02 Feb 2022 | 8.30 AM"
    />,
  );
  const testElement = screen.getByTestId("heading");
  expect(testElement.textContent).toBe("Los Altos Center Lab");
});

test("Report Detail Render for upcoming test", () => {
  render(
    <ReportDetail
      isCompleted={false}
      labName="Los Altos Center Lab"
      testName="Covid RTPCR Test"
      dateTime="pending"
    />,
  );
});
