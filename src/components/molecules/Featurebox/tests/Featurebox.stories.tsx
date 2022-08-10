import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import Featurebox from "../index";
import { ReactComponent as home } from "../../../../assets/icons/house.svg";
import { ReactComponent as doctor } from "../../../../assets/icons/doctors.svg";
import { ReactComponent as torch } from "../../../../assets/icons/torch.svg";
import { ReactComponent as report } from "../../../../assets/icons/graphs.svg";
import {
  testInfoHome,
  testInfoReports,
  testInfoTorch,
  testInfoConsultation,
} from "../../../../assets/constants";
export default {
  title: "Molecules/Featurebox",
  component: Featurebox,
} as ComponentMeta<typeof Featurebox>;

const Template: ComponentStory<typeof Featurebox> = (args) => (
  <Featurebox {...args} />
);

export const Default = Template.bind({});
Default.args = {
  component: home,
  content: testInfoHome,
};

export const Doctors = Template.bind({});
Doctors.args = {
  component: doctor,
  content: testInfoConsultation,
};

export const Torch = Template.bind({});
Torch.args = {
  component: torch,
  content: testInfoTorch,
};

export const Reports = Template.bind({});
Reports.args = {
  component: report,
  content: testInfoReports,
};
