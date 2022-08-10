import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import AddPatientForm from "..";

test("Patient Form Render", () => {
  render(<AddPatientForm />);

  const formHeadingEl = screen.getByTestId("formHeading");
  expect(formHeadingEl.textContent).toBe("Add Patient Details");

  const relationTextEl = screen.getByTestId("relationText");
  expect(relationTextEl.textContent).toBe("Booking for whom");

  const nameTextEl = screen.getByTestId("nameText");
  expect(nameTextEl.textContent).toBe("Name");

  const DOBTextEl = screen.getByTestId("DOBText");
  expect(DOBTextEl.textContent).toBe("Date of Birth");

  const genderTextEl = screen.getByTestId("genderText");
  expect(genderTextEl.textContent).toBe("Gender");
});

test("Name Change Test", () => {
  render(<AddPatientForm />);

  const nameChangeEl: HTMLInputElement = screen.getByTestId("nameChange");

  expect(nameChangeEl.value).toBe("");

  fireEvent.change(nameChangeEl, {
    target: {
      value: "Mohan",
    },
  });

  expect(nameChangeEl.value).toBe("Mohan");
});

test("DoB Change Test", () => {
  render(<AddPatientForm />);

  const DOBChangeEl: HTMLInputElement = screen.getByTestId("DOBChange");

  fireEvent.change(DOBChangeEl, {
    target: {
      value: "1999-07-17",
    },
  });

  expect(DOBChangeEl.value).toBe("1999-07-17");
});

test("Checkbox Test", () => {
  render(<AddPatientForm />);

  const checkBoxEl: HTMLInputElement = screen.getByTestId(
    "save-details-checkbox",
  );

  fireEvent.click(checkBoxEl);
});

test("Relation change tabs", () => {
  render(<AddPatientForm />);
  const selectElement = screen.getAllByRole("tab");
  fireEvent.click(selectElement[1]);
});

test("Gender change radio buttons", () => {
  render(<AddPatientForm />);
  const selectElement = screen.getAllByRole("radio");
  fireEvent.click(selectElement[1]);
});
