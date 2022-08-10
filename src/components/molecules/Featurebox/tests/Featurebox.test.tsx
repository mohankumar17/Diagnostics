import React from "react";
import { render, screen } from "@testing-library/react";
import Featurebox from "../index";

test("TestInformation Card Render", () => {
  // eslint-disable-next-line prefer-const
  let args = {
    component: require("../../../../assets/icons/doctors.svg"),
    content: "Free consultation",
  };
  render(<Featurebox {...args} />);
  const doctor = screen.getByTestId("stack");
  expect(doctor.childElementCount).toBe(2);
  expect(doctor.lastChild?.textContent).toBe("Free consultation");
});
