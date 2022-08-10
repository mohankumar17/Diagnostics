import React from "react";
import CovidRTPCR from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Molecules/CovidRTPCR",
  component: CovidRTPCR,
} as ComponentMeta<typeof CovidRTPCR>;

const Template: ComponentStory<typeof CovidRTPCR> = () => <CovidRTPCR />;

export const CovidRTPCRTest = Template.bind({});
