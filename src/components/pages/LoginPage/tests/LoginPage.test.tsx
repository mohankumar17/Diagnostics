import { screen, render, fireEvent } from "@testing-library/react";
import "@testing-library/jest-dom";
import LoginScreens from "../index";
import React from "react";
import "@testing-library/jest-dom/extend-expect";
import "@testing-library/jest-dom/extend-expect";
import { MemoryRouter } from "react-router-dom";

global.open = jest.fn();
describe("Login Page", () => {
  it("Page Should Render", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const radioElement = screen.getByTestId("loginscreen");
    expect(radioElement).toBeInTheDocument();
  });
  it("Checks for all input fields being filled", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const inputFields = screen.getAllByRole("textbox");
    fireEvent.change(inputFields[0], { target: { value: "f" } });
    fireEvent.change(inputFields[1], { target: { value: "f" } });
    fireEvent.change(inputFields[2], { target: { value: "f" } });
    const button = screen.getByTestId("continue");
    expect(button).toBeInTheDocument();
  });
  it("Clicks on Continue", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const inputFields = screen.getAllByRole("textbox");
    fireEvent.change(inputFields[0], { target: { value: "f" } });
    fireEvent.change(inputFields[1], { target: { value: "f" } });
    fireEvent.change(inputFields[2], { target: { value: "f" } });
    const button = screen.getByTestId("continue");
    fireEvent.click(button);
  });
  it("clicks on Google Icon", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const Buttons = screen.getAllByTestId("iconbutton");
    fireEvent.click(Buttons[0]);
    expect(global.open).toBeCalled();
    const Element = screen.getByTestId("loginscreen");
    expect(Element).toBeInTheDocument();
  });
  it("clicks on Facebook Icon", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const Buttons = screen.getAllByTestId("iconbutton");
    fireEvent.click(Buttons[1]);
    expect(global.open).toBeCalled();
    const Element = screen.getByTestId("loginscreen");
    expect(Element).toBeInTheDocument();
  });
  it("clicks on Apple Icon", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const Buttons = screen.getAllByTestId("iconbutton");
    fireEvent.click(Buttons[2]);
    expect(global.open).toBeCalled();
    const Element = screen.getByTestId("loginscreen");
    expect(Element).toBeInTheDocument();
  });
  it("Get OTP Button not available", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const inputFields = screen.getAllByRole("textbox");
    const button = screen.getByTestId("continue");
    fireEvent.change(inputFields[0], { target: { value: "f" } });
    fireEvent.change(inputFields[1], { target: { value: "f" } });
    fireEvent.change(inputFields[2], { target: { value: "f" } });
    expect(button).toBeEnabled();
    fireEvent.click(button);
    const inputField = screen.getAllByRole("textbox");
    fireEvent.change(inputField[0], { target: { value: "935488840" } });
    const button2 = screen.getByTestId("mobile");
    expect(button2).toBeDisabled();
  });
  it("Enters OTP and sees verify disabled", () => {
    render(<LoginScreens />, { wrapper: MemoryRouter });
    const inputFields = screen.getAllByRole("textbox");
    fireEvent.change(inputFields[0], { target: { value: "f" } });
    fireEvent.change(inputFields[1], { target: { value: "f" } });
    fireEvent.change(inputFields[2], { target: { value: "f" } });
    const button = screen.getByTestId("continue");
    fireEvent.click(button);
    const inputField = screen.getAllByRole("textbox");
    fireEvent.change(inputField[0], { target: { value: "9354888401" } });
    const button2 = screen.getByTestId("mobile");
    fireEvent.click(button2);
    const button3 = screen.getByTestId("verify");
    expect(button3).toBeDisabled();
    const otpFields = screen.getAllByRole("textbox");
    fireEvent.change(otpFields[0], { target: { value: "1" } });
    fireEvent.change(otpFields[1], { target: { value: "2" } });
    fireEvent.change(otpFields[2], { target: { value: "3" } });
    fireEvent.change(otpFields[3], { target: { value: "3" } });
  });
});
