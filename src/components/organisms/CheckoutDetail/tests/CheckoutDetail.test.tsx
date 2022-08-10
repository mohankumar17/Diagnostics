import React from "react";
import { render, screen } from "@testing-library/react";
import CheckoutDetail from "..";
import { ReactComponent as altos } from "../../../../assets/icons/altos.svg";

describe("Testing the CheckoutDetail", () => {
  it("render default CheckoutDetail", () => {
    const patient = {
      name: "Patrick Smith",
      tests: ["COVID RT-PCR Test"],
      testCount: "1 Test",
      eReport: "E-Reports by 12hrs",
      testFor: "Self",
      gender: "M",
      age: 30,
      cost: "$1200",
    };

    render(
      <CheckoutDetail
        labIcon={altos}
        lab={"Los Altos Center Lab"}
        itemTotalVal={1200}
        discountVal={100}
        grandTotalVal={2300}
        noOfPatients={1}
        patients={[patient]}
        date={"Tue, Feb 23, 2022"}
        time={"07.00 - 08.00 AM"}
        addressType={"Home"}
        address={
          "2235 California Street Mountain View California APT#021 - 11023"
        }
      />,
    );

    const labIcon = screen.getByTestId("labIcon");
    expect(labIcon).toBeDefined();

    const lab = screen.getByTestId("lab");
    expect(lab.textContent).toBe("Los Altos Center Lab");

    const itemTotal = screen.getByTestId("itemTotal");
    expect(itemTotal.textContent).toBe("Item Total");

    const discount = screen.getByTestId("discount");
    expect(discount.textContent).toBe("Discount");

    const grandTotal = screen.getByTestId("grandTotal");
    expect(grandTotal.textContent).toBe("Grand Total");

    const itemTotalVal = screen.getByTestId("itemTotalVal");
    expect(itemTotalVal.textContent).toBe("$1200");

    const discountVal = screen.getByTestId("discountVal");
    expect(discountVal.textContent).toBe("-$100");

    const grandTotalVal = screen.getByTestId("grandTotalVal");
    expect(grandTotalVal.textContent).toBe("$2300");

    const noOfPatients = screen.getByTestId("noOfPatients");
    expect(noOfPatients.textContent).toBe("Patient Details (1)");

    const patrickSmith = screen.getByTestId("Patrick Smith");
    expect(patrickSmith.textContent).toBe("Patrick Smith");

    const COVIDRTPCRTest = screen.getByTestId("COVID RT-PCR Test");
    expect(COVIDRTPCRTest.textContent).toBe("COVID RT-PCR Test");

    const testCount = screen.getByTestId("testCount");
    expect(testCount.textContent).toBe("1 Test");

    const eReport = screen.getByTestId("eReport");
    expect(eReport.textContent).toBe("E-Reports by 12hrs");

    const testFor = screen.getByTestId("testFor");
    expect(testFor.textContent).toBe("Self");

    const gender = screen.getByTestId("gender");
    expect(gender.textContent).toBe("M");

    const age = screen.getByTestId("age");
    expect(age.textContent).toBe("30");

    const cost = screen.getByTestId("cost");
    expect(cost.textContent).toBe("$1200");

    const date = screen.getByTestId("date");
    expect(date.textContent).toBe("Tue, Feb 23, 2022");

    const time = screen.getByTestId("time");
    expect(time.textContent).toBe("07.00 - 08.00 AM");

    const addressType = screen.getByTestId("addressType");
    expect(addressType.textContent).toBe("Address Selected (Home)");

    const address = screen.getByTestId("address");
    expect(address.textContent).toBe(
      "2235 California Street Mountain View California APT#021 - 11023",
    );
  });
});
