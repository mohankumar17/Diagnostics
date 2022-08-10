import React from "react";
import MainPageFooter from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";

import { ThemeProvider } from "@mui/material/styles";
import theme from "../../../theme";

export default {
  title: "Molecules/MainPageFooter",
  component: MainPageFooter,
} as ComponentMeta<typeof MainPageFooter>;

const Template: ComponentStory<typeof MainPageFooter> = () => (
  <ThemeProvider theme={theme}>
    <MainPageFooter />
  </ThemeProvider>
);

export const MainPageFooterComp = Template.bind({});
