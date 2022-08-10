import React from "react";
import { render, screen } from "@testing-library/react";
import Receipt from "..";

describe("Testing the Receipt", () => {
  it("render default Receipt", () => {
    const patient = { name: "Patrick Smith", tests: ["COVID RT-PCR Test"] };

    render(
      <Receipt
        patients={[patient]}
        address={"2235 California Street Mountain View California APT.."}
        total={2400}
        instructions={
          "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment."
        }
      />,
    );
    const patientPatrickSmith = screen.getByTestId("Patrick Smith");
    expect(patientPatrickSmith.textContent).toBe("Patrick Smith");

    const testCOVIDRTPCRTest = screen.getByTestId("COVID RT-PCR Test");
    expect(testCOVIDRTPCRTest.textContent).toBe("COVID RT-PCR Test");

    const address = screen.getByTestId("address");
    expect(address.textContent).toBe(
      "2235 California Street Mountain View California APT..",
    );

    const total = screen.getByTestId("total");
    expect(total.textContent).toBe("Total Amount Paid - $2400");

    const instructionsHeading = screen.getByTestId("instructionsHeading");
    expect(instructionsHeading.textContent).toBe("Instructions");

    const instructions = screen.getByTestId("instructions");
    expect(instructions.textContent).toBe(
      "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
    );
  });

  it("render Patient1Tests2 Receipt", () => {
    const patient = {
      name: "Patrick Smith",
      tests: ["COVID RT-PCR Test", "full body checkup"],
    };
    render(
      <Receipt
        patients={[patient]}
        address={"2235 California Street Mountain View California APT.."}
        total={2400}
        instructions={
          "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment."
        }
      />,
    );
    const patientPatrickSmith = screen.getByTestId("Patrick Smith");
    expect(patientPatrickSmith.textContent).toBe("Patrick Smith");

    const testCOVIDRTPCRTest = screen.getByTestId("COVID RT-PCR Test");
    expect(testCOVIDRTPCRTest.textContent).toBe("COVID RT-PCR Test");

    const testfullbodycheckup = screen.getByTestId("full body checkup");
    expect(testfullbodycheckup.textContent).toBe("full body checkup");

    const address = screen.getByTestId("address");
    expect(address.textContent).toBe(
      "2235 California Street Mountain View California APT..",
    );

    const total = screen.getByTestId("total");
    expect(total.textContent).toBe("Total Amount Paid - $2400");

    const instructionsHeading = screen.getByTestId("instructionsHeading");
    expect(instructionsHeading.textContent).toBe("Instructions");

    const instructions = screen.getByTestId("instructions");
    expect(instructions.textContent).toBe(
      "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
    );
  });

  it("render Patients2Tests1 Receipt", () => {
    const patient1 = {
      name: "Patrick Smith",
      tests: ["COVID RT-PCR Test"],
    };
    const patient2 = {
      name: "Peter Smith",
      tests: ["full body checkup"],
    };
    render(
      <Receipt
        patients={[patient1, patient2]}
        address={"2235 California Street Mountain View California APT.."}
        total={2400}
        instructions={
          "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment."
        }
      />,
    );
    const patientPatrickSmith = screen.getByTestId("Patrick Smith");
    expect(patientPatrickSmith.textContent).toBe("Patrick Smith");

    const patientPeterSmith = screen.getByTestId("Peter Smith");
    expect(patientPeterSmith.textContent).toBe("Peter Smith");

    const testCOVIDRTPCRTest = screen.getByTestId("COVID RT-PCR Test");
    expect(testCOVIDRTPCRTest.textContent).toBe("COVID RT-PCR Test");

    const testfullbodycheckup = screen.getByTestId("full body checkup");
    expect(testfullbodycheckup.textContent).toBe("full body checkup");

    const address = screen.getByTestId("address");
    expect(address.textContent).toBe(
      "2235 California Street Mountain View California APT..",
    );

    const total = screen.getByTestId("total");
    expect(total.textContent).toBe("Total Amount Paid - $2400");

    const instructionsHeading = screen.getByTestId("instructionsHeading");
    expect(instructionsHeading.textContent).toBe("Instructions");

    const instructions = screen.getByTestId("instructions");
    expect(instructions.textContent).toBe(
      "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
    );
  });
});
