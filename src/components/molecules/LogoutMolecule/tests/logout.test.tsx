import React from "react";
import { render, screen } from "@testing-library/react";
import Trackordermolecule from "../index";

test("User molecule Render", () => {
  render(
    <Trackordermolecule
      content1="Logout"
      content2="Payment modes refund status"
    />,
  );

  const cardHeading = screen.getByTestId("heading");
  expect(cardHeading.textContent).toBe("Logout");

  const cardExpiry = screen.getByTestId("nameText");
  expect(cardExpiry.textContent).toBe("Payment modes refund status");
});
