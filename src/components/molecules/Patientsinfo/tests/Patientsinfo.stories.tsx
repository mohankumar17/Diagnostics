import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import Patientsinfo from "../index";

export default {
  title: "Molecules/PatientInfo",
  component: Patientsinfo,
} as ComponentMeta<typeof Patientsinfo>;

const Template: ComponentStory<typeof Patientsinfo> = (args) => (
  <Patientsinfo {...args} />
);
export const Torch = Template.bind({});
Torch.args = {
  patientInfoDetails: "Self, Male, 30 years",
  patientInfoName: "Patrick Smith",
};
