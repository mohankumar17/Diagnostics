import React from "react";
import { render, screen } from "@testing-library/react";
import MyAppointment from "..";

test("My Appointment UI Render", () => {
  render(<MyAppointment />);

  const headingEl = screen.getByTestId("heading-app");
  expect(headingEl.textContent).toBe("Appointments");

  const upcomingEl = screen.getByTestId("upcoming-app");
  expect(upcomingEl.textContent).toBe("Upcoming Tests");

  const recentEl = screen.getByTestId("recent-app");
  expect(recentEl.textContent).toBe("Recent Tests");
});
