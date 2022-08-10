import CustomTabs from "../index";
import { ComponentStory } from "@storybook/react";
import React from "react";
export default {
  title: "molecules/Tabs",
  component: CustomTabs,
};

const Template: ComponentStory<typeof CustomTabs> = (args) => (
  <CustomTabs {...args}></CustomTabs>
);
const stateHandler = () => {
  console.log();
};
export const Sample = Template.bind({});

Sample.args = {
  tabs: [
    {
      value: 0,
      label: "Home",
    },
    {
      value: 1,
      label: "Reports",
    },
    {
      value: 2,
      label: "My Appointments",
    },
  ],
  stateHandler: stateHandler,
  value: 0,
};
