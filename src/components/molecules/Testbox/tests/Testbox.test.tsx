import React from "react";
import { render, screen } from "@testing-library/react";
import Testbox from "../index";

test("TestInformation Card Render", () => {
  const args = {
    component: require("../../../../assets/icons/body.svg"),
    content: "Full body Check",
  };
  render(<Testbox {...args} />);

  const body = screen.getByTestId("Fullbody");
  expect(body.textContent).toBe("Full body Check");
});
