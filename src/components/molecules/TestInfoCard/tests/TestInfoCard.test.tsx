import React from "react";
import { render, screen } from "@testing-library/react";
import TestInfoCard from "..";

test("TestInformation Card Render", () => {
  let args = {
    imagePath: require("../../../../assets/body_test.png"),
    cardHeading: "Full body checkup",
    cardContents: { price: 1299, time: "24 Hrs", count: 42 },
  };
  render(<TestInfoCard {...args} />);

  const cardHeadingEl = screen.getByTestId("cardHeadingTest");
  expect(cardHeadingEl.textContent).toBe("Full body checkup");

  const priceEl = screen.getByTestId("priceTest");
  expect(priceEl.textContent).toBe("Starting from $1299");

  const timeEl = screen.getByTestId("timeTest");
  expect(timeEl.textContent).toBe("Reports ready in 24 Hrs");

  const countEl = screen.getByTestId("countTest");
  expect(countEl.textContent).toBe("42 tests");
});
