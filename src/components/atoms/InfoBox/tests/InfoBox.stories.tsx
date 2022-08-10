import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import InfoBox from "..";

export default {
  title: "Atoms/InfoBox",
  component: InfoBox,
} as ComponentMeta<typeof InfoBox>;

const Template: ComponentStory<typeof InfoBox> = (args) => (
  <InfoBox {...args} />
);

export const Default = Template.bind({});
Default.args = {
  info: "If you are showing symptoms of COVID-19 infection",
};
