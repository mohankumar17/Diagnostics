import "@testing-library/jest-dom/extend-expect";
import { fireEvent, render, screen } from "@testing-library/react";
import React from "react";
import InputField from "../index";

const handleChange = jest.fn();
it("renders Patients Info", () => {
  render(
    <InputField label="" placeholder="" handleChange={handleChange} id="1" />,
  );
  const testIcon = screen.getByTestId("inputfield");
  expect(testIcon).toBeInTheDocument();
});

it("changes input field", () => {
  render(
    <InputField label="" placeholder="" handleChange={handleChange} id="1" />,
  );
  const field = screen.getByRole("textbox");
  fireEvent.change(field, { target: { value: "f" } });
  expect(handleChange).toBeCalled();
});
