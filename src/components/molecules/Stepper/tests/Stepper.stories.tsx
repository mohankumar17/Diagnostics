import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import Stepper from "../index";

export default {
  title: "Molecules/Stepper",
  component: Stepper,
} as ComponentMeta<typeof Stepper>;

const Template: ComponentStory<typeof Stepper> = (args) => (
  <Stepper {...args} />
);

export const PrimaryCard = Template.bind({});
PrimaryCard.args = {
  steps: ["Home", "COVID RTCPR", "Add Patient"],
  activeStep: 0,
};
