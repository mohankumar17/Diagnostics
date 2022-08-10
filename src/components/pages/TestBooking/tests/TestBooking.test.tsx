import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import TestBookingPage from "..";
import PatientList from "../../../organisms/PatientList";
import Selectlab from "../../../organisms/SelectLab";
import AddAddressForm from "../../../organisms/AddAddressForm";
import { MemoryRouter } from "react-router-dom";

test("Test Booking Flow Render", () => {
  render(<TestBookingPage />, { wrapper: MemoryRouter });
});

test("Flow button footer", () => {
  render(<TestBookingPage />, { wrapper: MemoryRouter });

  const flowButtonEl = screen.getByTestId("flow-btn");

  for (let eachState = 0; eachState < 10; eachState++) {
    fireEvent.click(flowButtonEl);
  }
});

test("Back flow button footer", () => {
  render(<TestBookingPage />, { wrapper: MemoryRouter });

  const flowButtonEl = screen.getByTestId("back-flow-btn");

  for (let eachState = 0; eachState < 10; eachState++) {
    fireEvent.click(flowButtonEl);
  }
});

test("Patients Info", () => {
  const patientList = [
    {
      relation: "myself",
      name: "Patrick",
      dob: "1999-07-17",
      gender: "Male",
      id: 1,
    },
    {
      relation: "father",
      name: "John",
      dob: "1975-06-09",
      gender: "Male",
      id: 2,
    },
  ];
  render(<PatientList list={patientList} />, { wrapper: MemoryRouter });
  const testEl = screen.getByTestId("new-patient-click");
  fireEvent.click(testEl);
});

test("Select Lab", () => {
  render(<Selectlab />, { wrapper: MemoryRouter });
});

test("Add Address ", () => {
  render(<AddAddressForm></AddAddressForm>, { wrapper: MemoryRouter });
  const testEl = screen.getByTestId("heading");
  expect(testEl).toBeDefined();
});
