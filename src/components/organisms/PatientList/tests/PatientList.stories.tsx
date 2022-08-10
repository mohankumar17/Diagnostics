import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import PatientList from "../index";

const patientList = [
  {
    relation: "myself",
    name: "Paul",
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
export default {
  title: "Organisms/PatientList",
  component: PatientList,
} as ComponentMeta<typeof PatientList>;

const Template: ComponentStory<typeof PatientList> = (args) => (
  <PatientList {...args} />
);

export const CustomHeader = Template.bind({});
CustomHeader.args = {
  list: patientList,
};
