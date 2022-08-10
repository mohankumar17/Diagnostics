import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import OrderConfirmation from "..";

export default {
  title: "Molecules/OrderConfirmation",
  component: OrderConfirmation,
} as ComponentMeta<typeof OrderConfirmation>;

const Template: ComponentStory<typeof OrderConfirmation> = (args) => (
  <OrderConfirmation {...args} />
);

export const Default = Template.bind({});
Default.args = {
  instructions:
    "Please don't eat or drink anything other than water for 8 -10 hours prior to the appointment.",
};
