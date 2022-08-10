import React from "react";
import CardDetail from "../index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Organisms/CardDetail",
  component: CardDetail,
} as ComponentMeta<typeof CardDetail>;

const Template: ComponentStory<typeof CardDetail> = (args) => (
  <CardDetail {...args} />
);

export const Primary = Template.bind({});
