import React from "react";
import TestInfoCard from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import bodyTest from "../../../../assets/body_test.png";
import { ThemeProvider } from "@mui/material/styles";
import theme from "../../../theme";

export default {
  title: "Molecules/TestInfoCard",
  component: TestInfoCard,
} as ComponentMeta<typeof TestInfoCard>;

const Template: ComponentStory<typeof TestInfoCard> = (args) => (
  <ThemeProvider theme={theme}>
    <TestInfoCard {...args} />
  </ThemeProvider>
);

export const BodyTestCard = Template.bind({});
BodyTestCard.args = {
  imagePath: bodyTest,
  cardHeading: "Full body checkup",
  cardContents: { price: 1299, time: "24 Hrs", count: 42 },
};
