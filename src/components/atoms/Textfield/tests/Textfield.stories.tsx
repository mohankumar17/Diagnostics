import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import InputField from "../index";

export default {
  title: "Atoms/Textbox",
  component: InputField,
} as ComponentMeta<typeof InputField>;

const Template: ComponentStory<typeof InputField> = (args) => (
  <InputField {...args} />
);

export const InputFieldBar = Template.bind({});
InputFieldBar.args = {
  placeholder: "Patrick Smith",
};
