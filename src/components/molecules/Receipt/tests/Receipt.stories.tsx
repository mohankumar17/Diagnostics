import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import Receipt from "..";

export default {
  title: "Molecules/Receipt",
  component: Receipt,
} as ComponentMeta<typeof Receipt>;

const Template: ComponentStory<typeof Receipt> = (args) => (
  <Receipt {...args} />
);

export const Default = Template.bind({});
var patient = { name: "Patrick Smith", tests: ["COVID RT-PCR Test"] };
Default.args = {
  patients: [patient],
  address: "2235 California Street Mountain View California APT..",
  total: 2400,
  instructions:
    "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
};

export const Patient1Tests2 = Template.bind({});
var patient = {
  name: "Patrick Smith",
  tests: ["COVID RT-PCR Test", "full body checkup"],
};
Patient1Tests2.args = {
  patients: [patient],
  address: "2235 California Street Mountain View California APT..",
  total: 2400,
  instructions:
    "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
};

export const Patients2Tests1 = Template.bind({});
var patient1 = {
  name: "Patrick Smith",
  tests: ["COVID RT-PCR Test"],
};
var patient2 = {
  name: "Peter Smith",
  tests: ["full body checkup"],
};
Patients2Tests1.args = {
  patients: [patient1, patient2],
  address: "2235 California Street Mountain View California APT..",
  total: 2400,
  instructions:
    "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
};

export const Patients2Tests2 = Template.bind({});
var patient1 = {
  name: "Patrick Smith",
  tests: ["COVID RT-PCR Test", "full body checkup"],
};
var patient2 = {
  name: "Peter Smith",
  tests: ["COVID RT-PCR Test", "full body checkup"],
};
Patients2Tests2.args = {
  patients: [patient1, patient2],
  address: "2235 California Street Mountain View California APT..",
  total: 2400,
  instructions:
    "Please don't eat or drink anything other than water for  8 -10 hours prior to the appointment.",
};
