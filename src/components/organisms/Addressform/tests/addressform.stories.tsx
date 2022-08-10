import React from "react";
import AddressForm from "../index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Organisms/AddressForm",
  component: AddressForm,
} as ComponentMeta<typeof AddressForm>;

const Template: ComponentStory<typeof AddressForm> = () => <AddressForm />;

export const Cards = Template.bind({});
