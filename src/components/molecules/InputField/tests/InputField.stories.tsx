import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import Faq from "../index";

export default {
  title: "Molecules/InputField",
  component: Faq,
} as ComponentMeta<typeof Faq>;

const Template: ComponentStory<typeof Faq> = (args) => <Faq {...args} />;
const handleChange = () => {};
export const PrimaryCard = Template.bind({});
PrimaryCard.args = {
  label: "First Name",
  placeholder: "eg: Patrick",
  handleChange: handleChange,
  id: "1",
};
