import React from "react";
import TestCostTimeInfo from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";

import { ThemeProvider } from "@mui/material/styles";
import theme from "../../../theme";

export default {
  title: "Molecules/TestCostTimeInfo",
  component: TestCostTimeInfo,
} as ComponentMeta<typeof TestCostTimeInfo>;

const Template: ComponentStory<typeof TestCostTimeInfo> = (args) => (
  <ThemeProvider theme={theme}>
    <TestCostTimeInfo {...args} />
  </ThemeProvider>
);

export const TestCostTimeInfoCard = Template.bind({});
TestCostTimeInfoCard.args = {
  cardContents: { price: 1200, time: "24 Hours" },
};
