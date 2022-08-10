import React from "react";
import { render, screen } from "@testing-library/react";
import Patientinfo from "../index";

test("Patient info Render", () => {
  render(
    <Patientinfo
      patientInfoDetails="Self, Male, 30 years"
      patientInfoName="Patrick Smith"
    />,
  );
  const patient = screen.getByTestId("stack");
  expect(patient.childElementCount).toBe(2);

  const name = screen.getByTestId("name");
  expect(name.textContent).toBe("Patrick Smith");

  const details = screen.getByTestId("details");
  expect(details.textContent).toBe("Self, Male, 30 years");

  const edit = screen.getByTestId("edit");
  expect(edit.textContent).toBe("Edit");
});
