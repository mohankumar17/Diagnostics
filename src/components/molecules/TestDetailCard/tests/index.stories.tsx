import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import covid from "../../../../assets/icons/covid.png";
import TestDetail from "../index";

export default {
  title: "Molecules/TestDetail",
  component: TestDetail,
} as ComponentMeta<typeof TestDetail>;

const Template: ComponentStory<typeof TestDetail> = (args) => (
  <TestDetail {...args} />
);

export const PrimaryCard = Template.bind({});
PrimaryCard.args = {
  testDisplayIcon: covid,
  testName: "Covid RTPCR",
  labName: "- Los Altos Center Lab",
  patientName: "Patrick Smith",
  time: "Wed 23, 7.00 am to 8.00 am",
};
