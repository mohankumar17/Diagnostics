import React from "react";
import { render, screen } from "@testing-library/react";
import Usermolecule from "../index";

test("User molecule Render", () => {
  render(
    <Usermolecule
      content1="Revanth"
      content2="s@gmail.com"
      content3="703244444"
    />,
  );

  const cardHeading = screen.getByTestId("heading");
  expect(cardHeading.textContent).toBe("Revanth");

  const cardExpiry = screen.getByTestId("nameText");
  expect(cardExpiry.textContent).toBe("s@gmail.com");

  const cardCvv = screen.getByTestId("expiryText");
  expect(cardCvv.textContent).toBe("703244444");
});
