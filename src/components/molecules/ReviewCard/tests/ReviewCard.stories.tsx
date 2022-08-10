import React from "react";
import { ThemeProvider } from "@mui/material";
import { ComponentStory, ComponentMeta, addDecorator } from "@storybook/react";
import ReviewCard from "..";
import theme from "../../../theme";
import avatar1 from "../../../../assets/avatar1.png";

export default {
  title: "Molecules/ReviewCard",
  component: ReviewCard,
} as ComponentMeta<typeof ReviewCard>;

const Template: ComponentStory<typeof ReviewCard> = (args) => (
  <ReviewCard {...args} />
);

addDecorator((story) => <ThemeProvider theme={theme}>{story()}</ThemeProvider>);

export const Default = Template.bind({});
Default.args = {
  avatar: avatar1,
  name: "Abby",
  address: "San Jose, CA",
  review:
    "Very friendly and professional. Loved the follow-up and progress calls",
};
