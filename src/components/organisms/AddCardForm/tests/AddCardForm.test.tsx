import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import AddCardForm from "../index";
import userEvent from "@testing-library/user-event";

test("Add Card Form Render", () => {
  render(<AddCardForm />);

  const cardHeading = screen.getByTestId("heading");
  expect(cardHeading.textContent).toBe("Add New Card");

  const cardExpiry = screen.getByTestId("expiryText");
  expect(cardExpiry.textContent).toBe("Expiry Date");

  const cardCvv = screen.getByTestId("cvvText");
  expect(cardCvv.textContent).toBe("CVV");

  const cardHolder = screen.getByTestId("holderText");
  expect(cardHolder.textContent).toBe("Card Holder Name");

  const buttonTextEl = screen.getByTestId("buttonType");
  expect(buttonTextEl.textContent).toBe("Add Card");
});

test("Card Number Change Test", () => {
  render(<AddCardForm />);

  const cardNumber: HTMLInputElement = screen.getByTestId("cardnum");

  fireEvent.change(cardNumber, {
    target: {
      value: "1233 4455 6666 8989",
    },
  });

  expect(cardNumber.value).toBe("1233 4455 6666 8989");
});

test("Expiry Change Test", () => {
  render(<AddCardForm />);

  const DOBChangeEl: HTMLInputElement = screen.getByTestId("expiry");

  fireEvent.change(DOBChangeEl, {
    target: {
      value: "2028-09-02",
    },
  });

  expect(DOBChangeEl.value).toBe("2028-09-02");
});

test("CVV change Test", () => {
  render(<AddCardForm />);

  const CVVcard: HTMLInputElement = screen.getByTestId("cvvcard");

  fireEvent.change(CVVcard, {
    target: {
      value: "144",
    },
  });

  expect(CVVcard.value).toBe("144");
});

test("Name change Test", () => {
  render(<AddCardForm />);

  const cardName: HTMLInputElement = screen.getByTestId("cardname");

  fireEvent.change(cardName, {
    target: {
      value: "Yessie",
    },
  });

  expect(cardName.value).toBe("Yessie");
});

test("Checkbox change Test", () => {
  render(<AddCardForm />);
  const cardName = screen.getByTestId("checkbox-1234");

  const card = cardName.querySelector('input[type="checkbox"]');
  expect(card).toHaveProperty("checked", true);
  userEvent.click(cardName);
  expect(card).toHaveProperty("checked", false);
});
