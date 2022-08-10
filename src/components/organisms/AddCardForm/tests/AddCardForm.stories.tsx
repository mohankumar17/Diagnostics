import React from "react";
import AddCardForm from "../index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Organisms/AddCardForm",
  component: AddCardForm,
} as ComponentMeta<typeof AddCardForm>;

const Template: ComponentStory<typeof AddCardForm> = () => <AddCardForm />;

export const Cards = Template.bind({});
