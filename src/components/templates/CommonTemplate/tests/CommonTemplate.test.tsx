import React from "react";
import { render, screen } from "@testing-library/react";
import CommonTemplate from "../index";
import { Typography } from "@mui/material";
import Image from "../../../atoms/Image";

test("Appointment Booking Flow Template Check", () => {
  const args = {
    content: (
      <Typography variant="h1" data-testid="Card form">
        Add Card Form
      </Typography>
    ),
  };
  render(<CommonTemplate Component={Image} {...args} />);

  const card = screen.getByTestId("Card form");
  expect(card.textContent).toBe("Add Card Form");
});
