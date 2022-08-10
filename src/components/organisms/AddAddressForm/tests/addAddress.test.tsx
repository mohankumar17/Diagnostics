import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import AddAddressForm from "../index";

test("Add Card Form Render", () => {
  render(<AddAddressForm  />);

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

test("Address Home Change Test", () => {
  render(<AddAddressForm />);

  const cardNumber: HTMLInputElement = screen.getByTestId("cardnum");

  fireEvent.change(cardNumber, {
    target: {
      value: "H.No: 3-2-3",
    },
  });

  expect(cardNumber.value).toBe("H.No: 3-2-3");
});

test("Road Change Test", () => {
  render(<AddAddressForm />);

  const DOBChangeEl: HTMLInputElement = screen.getByTestId("expiry");

  fireEvent.change(DOBChangeEl, {
    target: {
      value: "Big bazar",
    },
  });

  expect(DOBChangeEl.value).toBe("Big bazar");
});

test("Zipcode change Test", () => {
  render(<AddAddressForm />);

  const CVVcard: HTMLInputElement = screen.getByTestId("cvvcard");

  fireEvent.change(CVVcard, {
    target: {
      value: "144",
    },
  });

  expect(CVVcard.value).toBe("144");
});

test("Name change Test", () => {
  render(<AddAddressForm />);

  const cardName: HTMLInputElement = screen.getByTestId("cardname");

  fireEvent.change(cardName, {
    target: {
      value: "Kamareddy",
    },
  });

  expect(cardName.value).toBe("Kamareddy");
});
