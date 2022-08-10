import React from "react";
import { render, screen } from "@testing-library/react";
import OrderConfirmation from "..";

describe("Testing the OrderConfirmation", () => {
  it("render default OrderConfirmation", () => {
    render(
      <OrderConfirmation
        instructions={
          "Please don't eat or drink anything other than water for 8 -10 hours prior to the appointment."
        }
      />,
    );
    const heading = screen.getByTestId("heading");
    expect(heading.textContent).toBe("Your order has been placed");

    const subHeading = screen.getByTestId("subHeading");
    expect(subHeading.textContent).toBe("Instructions");

    const instructions = screen.getByTestId("instructions");
    expect(instructions.textContent).toBe(
      "Please don't eat or drink anything other than water for 8 -10 hours prior to the appointment.",
    );
  });
});
