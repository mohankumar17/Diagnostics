import React from "react";
import { render, screen } from "@testing-library/react";
import TestCostTimeInfo from "..";

test("TestCost Time and Information Render", () => {
  let args = {
    cardContents: { price: 1200, time: "24 Hours" },
  };
  render(<TestCostTimeInfo {...args} />);

  const testCostEl = screen.getByTestId("testCost");
  expect(testCostEl.textContent).toBe("Starting from $1200");

  const testTimeEl = screen.getByTestId("testTime");
  expect(testTimeEl.textContent).toBe("Reports ready in 24 Hours");
});
