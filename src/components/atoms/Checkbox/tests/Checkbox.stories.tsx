import React from "react";
import Checkbox from "../index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Atoms/Checkbox",
  component: Checkbox,
} as ComponentMeta<typeof Checkbox>;

const Template: ComponentStory<typeof Checkbox> = () => <Checkbox />;

export const Default = Template.bind({});
