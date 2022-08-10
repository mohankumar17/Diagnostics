import React from "react";
import MainPageBanner from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";

import { ThemeProvider } from "@mui/material/styles";
import theme from "../../../theme";

export default {
  title: "Molecules/MainPageBanner",
  component: MainPageBanner,
} as ComponentMeta<typeof MainPageBanner>;

const Template: ComponentStory<typeof MainPageBanner> = () => (
  <ThemeProvider theme={theme}>
    <MainPageBanner />
  </ThemeProvider>
);

export const MainPageBannerComp = Template.bind({});
