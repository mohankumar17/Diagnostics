import "@testing-library/jest-dom/extend-expect";
import { render, screen } from "@testing-library/react";
import React from "react";
import PatientsInfo from "../index";

const patientList = [
  {
    relation: "myself",
    name: "Mohan",
    dob: "1999-07-17",
    gender: "Male",
    id: 1,
  },
  {
    relation: "father",
    name: "Kishore",
    dob: "1975-06-09",
    gender: "Male",
    id: 2,
  },
];
it("renders Patients Info", () => {
  render(<PatientsInfo list={patientList} />);
  const testIcon = screen.getByTestId("patientslist");
  expect(testIcon).toBeInTheDocument();
});
