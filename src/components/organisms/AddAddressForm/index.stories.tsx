import React from "react";
import AddAddressForm from "./index";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Organisms/AddAddressForm",
  component: AddAddressForm,
} as ComponentMeta<typeof AddAddressForm>;

const Template: ComponentStory<typeof AddAddressForm> = () => (
  <AddAddressForm />
);

export const Cards = Template.bind({});
