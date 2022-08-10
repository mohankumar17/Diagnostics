import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import ReportDetail from "../index";

export default {
  title: "Molecules/ReportDetail",
  component: ReportDetail,
} as ComponentMeta<typeof ReportDetail>;

const Template: ComponentStory<typeof ReportDetail> = (args) => (
  <ReportDetail {...args} />
);

export const Completed = Template.bind({});
Completed.args = {
  isCompleted: true,
  labName: "Los Altos Center Lab",
  testName: "Covid RTPCR Test",
  dateTime: "02 Feb 2022 | 8.30 AM",
};

export const Upcoming = Template.bind({});
Upcoming.args = {
  isCompleted: false,
  labName: "Los Altos Center Lab",
  testName: "Covid RTPCR Test",
  dateTime: "Pending",
};
