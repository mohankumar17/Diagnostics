import React from "react";
import { render, screen } from "@testing-library/react";
import Trackorder from "../index";

test("TestInformation Card Render", () => {
  render(<Trackorder />);
  const stack1 = screen.getByTestId("stack");
  expect(stack1.childElementCount).toBe(1);

  const stack2 = screen.getByTestId("stack1");
  expect(stack2.childElementCount).toBe(2);

  const stack3 = screen.getByTestId("stack2");
  expect(stack3.childElementCount).toBe(2);
});
