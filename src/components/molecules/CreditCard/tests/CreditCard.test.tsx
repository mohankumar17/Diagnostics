import React from "react";
import { render, screen } from "@testing-library/react";
import CreditCard from "..";

describe("Testing the CreditCard", () => {
  it("render default CreditCard", () => {
    render(
      <CreditCard
        sample={"Sample"}
        cardNumber={"1244 1234 1345 3255"}
        cardHolder={"Yessie"}
        expires={"02/25"}
      />,
    );

    const sample = screen.getByTestId("sample");
    expect(sample.textContent).toBe("Sample");

    const cardNumber = screen.getByTestId("cardNumber");
    expect(cardNumber.textContent).toBe("1244 1234 1345 3255");

    const cardHolderHeading = screen.getByTestId("cardHolderHeading");
    expect(cardHolderHeading.textContent).toBe("Card Holder");

    const cardHolder = screen.getByTestId("cardHolder");
    expect(cardHolder.textContent).toBe("Yessie");

    const expiresHeading = screen.getByTestId("expiresHeading");
    expect(expiresHeading.textContent).toBe("Expires");

    const expires = screen.getByTestId("expires");
    expect(expires.textContent).toBe("02/25");
  });
});
