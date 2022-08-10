import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import Faq from "../index";

export default {
  title: "Molecules/Faq",
  component: Faq,
} as ComponentMeta<typeof Faq>;

const Template: ComponentStory<typeof Faq> = (args) => <Faq {...args} />;

export const PrimaryCard = Template.bind({});
PrimaryCard.args = {
  label: "How soon can i get the report?",
  content:
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada lacus ex sit amet blandit leo lobortis eget.",
};
