import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import CheckoutDetail from "..";
import { ReactComponent as altos } from "../../../../assets/icons/altos.svg";

export default {
  title: "Organisms/CheckoutDetail",
  component: CheckoutDetail,
} as ComponentMeta<typeof CheckoutDetail>;

const Template: ComponentStory<typeof CheckoutDetail> = (args) => (
  <CheckoutDetail {...args} />
);

export const Default = Template.bind({});
var patient = {
  name: "Patrick Smith",
  tests: ["COVID RT-PCR Test"],
  testCount: "1 Test",
  eReport: "E-Reports by 12hrs",
  testFor: "Self",
  gender: "M",
  age: 30,
  cost: "$1200",
};
Default.args = {
  labIcon: altos,
  lab: "Los Altos Center Lab",
  itemTotalVal: 1200,
  discountVal: 100,
  grandTotalVal: 2300,
  noOfPatients: 1,
  patients: [patient],
  date: "Tue, Feb 23, 2022",
  time: "07.00 - 08.00 AM",
  addressType: "Home",
  address: "2235 California Street Mountain View California APT#021 - 11023",
};

export const Patients2 = Template.bind({});
var patient1 = {
  name: "Patrick Smith",
  tests: ["COVID RT-PCR Test"],
  testCount: "1 Test",
  eReport: "E-Reports by 12hrs",
  testFor: "Self",
  gender: "M",
  age: 30,
  cost: "$1200",
};
var patient2 = {
  name: "Peter Smith",
  tests: ["Full Body Checkup"],
  testCount: "1 Test",
  eReport: "E-Reports by 12hrs",
  testFor: "Self",
  gender: "M",
  age: 30,
  cost: "$1200",
};
Patients2.args = {
  labIcon: altos,
  lab: "Los Altos Center Lab",
  itemTotalVal: 1200,
  discountVal: 100,
  grandTotalVal: 2300,
  noOfPatients: 2,
  patients: [patient1, patient2],
  date: "Tue, Feb 23, 2022",
  time: "07.00 - 08.00 AM",
  addressType: "Home",
  address: "2235 California Street Mountain View California APT#021 - 11023",
};
