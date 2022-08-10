import { Typography } from "@mui/material";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import React from "react";
import Button from "../index";
import addicon from "../../../../assets/icons/add.svg";
import { COLORS } from "../../../theme/Colors";
import { ReactSVG } from "react-svg";
export default {
  title: "Atoms/Button",
  component: Button,
} as ComponentMeta<typeof Button>;

const Template: ComponentStory<typeof Button> = (args) => <Button {...args} />;

export const PrimaryDisabled = Template.bind({});

PrimaryDisabled.args = {
  variant: "contained",
  style: {
    minHeight: "42px",
    minWidth: "334px",
    padding: "16px 8px",
    backgroundColor: `${COLORS.ALPHA_BLUE_100}`,
    borderRadius: "8px",
  },
  children: <Typography>Continue</Typography>,
  disabled: true,
};

export const PrimaryEnabled = Template.bind({});

PrimaryEnabled.args = {
  variant: "contained",
  style: {
    minHeight: "42px",
    minWidth: "334px",
    padding: "16px 8px",
    backgroundColor: `${COLORS.ALPHA_BLUE_500}`,
    borderRadius: "8px",
  },
  children: <Typography>Continue</Typography>,
};

export const PrimaryText = Template.bind({});

PrimaryText.args = {
  variant: "text",
  children: <Typography>Cancel</Typography>,
  style: {
    color: `${COLORS.ERROR}`,
  },
};

export const IconButton = Template.bind({});
IconButton.args = {
  variant: "text",
  style: {
    minHeight: "42px",
    minWidth: "136px",
    padding: "11px 8px",
    color: `${COLORS.ALPHA_BLUE_500}`,
  },
  children: <Typography>New Patient</Typography>,
  startIcon: <ReactSVG src={addicon}></ReactSVG>,
};
