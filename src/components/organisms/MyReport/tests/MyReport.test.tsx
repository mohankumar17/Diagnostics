import React from "react";
import { render, screen } from "@testing-library/react";
import MyReport from "..";

test("My Reports UI Render", () => {
  render(<MyReport />);

  const headingEl = screen.getByTestId("heading-rep");
  expect(headingEl.textContent).toBe("Reports");

  const upcomingEl = screen.getByTestId("upcoming-rep");
  expect(upcomingEl.textContent).toBe("Upcoming Reports");

  const recentEl = screen.getByTestId("recent-rep");
  expect(recentEl.textContent).toBe("Recent Reports");
});
