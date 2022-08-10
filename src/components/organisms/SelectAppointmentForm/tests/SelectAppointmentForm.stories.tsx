import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import SelectAppointmentForm from "..";

export default {
  title: "Organisms/SelectAppointmentForm",
  component: SelectAppointmentForm,
} as ComponentMeta<typeof SelectAppointmentForm>;

const Template: ComponentStory<typeof SelectAppointmentForm> = () => (
  <SelectAppointmentForm
    month={"January"}
    date={1}
    day={"Monday"}
    time={"6.00am - 7.00am"}
  />
);

export const Default = Template.bind({});
Default.args = {};
