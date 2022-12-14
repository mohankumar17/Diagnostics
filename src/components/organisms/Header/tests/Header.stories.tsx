import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import Header from "../index";

export default {
  title: "Organisms/Header",
  component: Header,
} as ComponentMeta<typeof Header>;

const Template: ComponentStory<typeof Header> = (args) => <Header {...args} />;

export const CustomHeader = Template.bind({});
CustomHeader.args = {
  location: "Mountain view, CA, USA",
};
