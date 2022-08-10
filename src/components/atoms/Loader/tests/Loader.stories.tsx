import React from "react";
import Loader from "../index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Atoms/Loader",
  component: Loader,
} as ComponentMeta<typeof Loader>;

const Template: ComponentStory<typeof Loader> = () => <Loader />;

export const LoaderComp = Template.bind({});
