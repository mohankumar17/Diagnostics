import React from "react";
import { render, fireEvent, screen } from "@testing-library/react";
import InputField from "../index";

const inputMock = jest.fn();

const Test = () => (
  <InputField
    onChange={inputMock}
    defaultValue={"mock@gmail.com"}
    placeholder={"Enter email id"}
  />
);

test("Input", () => {
  render(<Test />);

  const input = screen.getByDisplayValue("mock@gmail.com") as HTMLInputElement;

  fireEvent.change(input, { target: { value: "shivvarevanth@gmail.com" } });
  expect(input.value).toBe("shivvarevanth@gmail.com");
});
