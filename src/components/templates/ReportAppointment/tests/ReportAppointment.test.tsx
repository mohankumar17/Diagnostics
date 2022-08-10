import React from "react";
import { render, screen } from "@testing-library/react";
import ReportAppointment from "..";
import { Typography } from "@mui/material";

test("Appointments and Reports Page  Template Check", () => {
  const args = {
    location: "Mountain view, CA, USA",
    content: (
      <Typography variant="h1" data-testid="heading">
        Reports
      </Typography>
    ),
  };
  render(<ReportAppointment {...args} />);

  const headingEl = screen.getByTestId("heading");
  expect(headingEl.textContent).toBe("Reports");
});
