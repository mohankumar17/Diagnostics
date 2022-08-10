import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import Icon from "..";

import PersonOutlineIcon from "@mui/icons-material/PersonOutline";
import { ReactComponent as covid } from "../../../../assets/icons/covid.svg";
import { ReactComponent as user } from "../../../../assets/icons/user.svg";
import { ReactComponent as disableduser } from "../../../../assets/icons/user-1.svg";

export default {
  title: "Atoms/Icon",
  component: Icon,
} as ComponentMeta<typeof Icon>;

const Template: ComponentStory<typeof Icon> = (args) => <Icon {...args} />;

export const Default = Template.bind({});
Default.args = {
  component: user,
};

export const Disabled = Template.bind({});
Disabled.args = {
  component: disableduser,
};

export const LargeIcon = Template.bind({});
LargeIcon.args = {
  component: covid,
  fontSize: "large",
  inheritViewBox: true,
};

export const MUIIcon = Template.bind({});
MUIIcon.args = {
  component: undefined,
  children: <PersonOutlineIcon />,
};

export const MUIIconDisabled = Template.bind({});
MUIIconDisabled.args = {
  component: undefined,
  children: <PersonOutlineIcon />,
  color: "disabled",
};

export const MUIIconSecondary = Template.bind({});
MUIIconSecondary.args = {
  component: undefined,
  children: <PersonOutlineIcon />,
  color: "secondary",
};
