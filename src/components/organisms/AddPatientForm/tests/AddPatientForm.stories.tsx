import React from "react";
import AddPatientForm from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import { ThemeProvider } from "@mui/material/styles";
import theme from "../../../theme";

export default {
  title: "Organisms/AddPatientForm",
  component: AddPatientForm,
} as ComponentMeta<typeof AddPatientForm>;

const Template: ComponentStory<typeof AddPatientForm> = () => (
  <ThemeProvider theme={theme}>
    <AddPatientForm relation="myself" />
  </ThemeProvider>
);

export const AddPatientFormComp = Template.bind({});
