import React from "react";
import { ThemeProvider } from "@mui/material";
import { ComponentStory, ComponentMeta, addDecorator } from "@storybook/react";
import CreditCard from "..";
import theme from "../../../theme";

export default {
  title: "Molecules/CreditCard",
  component: CreditCard,
} as ComponentMeta<typeof CreditCard>;

const Template: ComponentStory<typeof CreditCard> = (args) => (
  <CreditCard {...args} />
);

addDecorator((story) => <ThemeProvider theme={theme}>{story()}</ThemeProvider>);

export const Default = Template.bind({});
Default.args = {
  sample: "Sample",
  cardNumber: "1244 1234 1345 3255",
  cardHolder: "Yessie",
  expires: "02/25",
};
