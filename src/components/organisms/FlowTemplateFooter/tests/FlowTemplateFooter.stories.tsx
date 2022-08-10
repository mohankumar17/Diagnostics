import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import FlowTemplateFooter from "..";
import { BrowserRouter } from "react-router-dom";

export default {
  title: "Organisms/FlowTemplateFooter",
  component: FlowTemplateFooter,
} as ComponentMeta<typeof FlowTemplateFooter>;

const Template: ComponentStory<typeof FlowTemplateFooter> = () => (
  <BrowserRouter>
    <FlowTemplateFooter testBookingDetails={0} flowButtonText={"Add Patient"} />
  </BrowserRouter>
);

export const TestBookingFlow = Template.bind({});
