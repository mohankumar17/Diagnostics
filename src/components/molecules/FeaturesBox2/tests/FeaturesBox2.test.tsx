import React from "react";
import { render, screen } from "@testing-library/react";
import Featurebox2 from "../index";

test("TestInformation Card Render", () => {
  // eslint-disable-next-line prefer-const
  let args = {
    component: require("../../../../assets/icons/tests.svg"),
    content: "1600+ Tests",
  };

  render(<Featurebox2 {...args} />);
  const torch = screen.getByTestId("stack");
  expect(torch.childElementCount).toBe(1);
  expect(torch.lastChild?.textContent).toBe("1600+ Tests");
});
