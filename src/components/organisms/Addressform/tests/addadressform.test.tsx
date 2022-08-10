import React from "react";
import { render, screen } from "@testing-library/react";
import AddressForm from "../index";

test("Add Card Form Render", () => {
  render(<AddressForm />);

  const cardHeading = screen.getByTestId("heading");
  expect(cardHeading.textContent).toBe("Add Address");

  const cardExpiry = screen.getByTestId("nameText");
  expect(cardExpiry.textContent).toBe("House/ Flat/ Block No.");

  const cardCvv = screen.getByTestId("expiryText");
  expect(cardCvv.textContent).toBe("Road / Area");

  const cardHolder = screen.getByTestId("cvvText");
  expect(cardHolder.textContent).toBe("Zipcode");

  const buttonTextEl = screen.getByTestId("holderText");
  expect(buttonTextEl.textContent).toBe("City, State");
});
