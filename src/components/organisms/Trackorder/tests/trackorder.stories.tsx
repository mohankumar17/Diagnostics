import React from "react";
import Trackorder from "../index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Organisms/Trackorder",
  component: Trackorder,
} as ComponentMeta<typeof Trackorder>;

const Template: ComponentStory<typeof Trackorder> = (args) => <Trackorder />;

export const Track = Template.bind({});
Track.args = {};
