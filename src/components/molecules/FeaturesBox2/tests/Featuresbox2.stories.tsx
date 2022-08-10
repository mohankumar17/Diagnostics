import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import Featurebox2 from "../index";
import {
  noOfTests,
  noOfHomes,
  certified,
  clia,
  reports,
  safe,
} from "../../../../assets/constants";
import { ReactComponent as torch } from "../../../../assets/icons/tests.svg";
import { ReactComponent as home } from "../../../../assets/icons/homes.svg";
import { ReactComponent as labs } from "../../../../assets/icons/lab-technician3.svg";
import { ReactComponent as clias } from "../../../../assets/icons/awards.svg";
import { ReactComponent as report } from "../../../../assets/icons/report.svg";
import { ReactComponent as safes } from "../../../../assets/icons/shields.svg";
export default {
  title: "Molecules/Featurebox2",
  component: Featurebox2,
} as ComponentMeta<typeof Featurebox2>;

const Template: ComponentStory<typeof Featurebox2> = (args) => (
  <Featurebox2 {...args} />
);
export const Torch = Template.bind({});
Torch.args = {
  component: torch,
  content: noOfTests,
};

export const Home = Template.bind({});
Home.args = {
  component: home,
  content: noOfHomes,
};

export const Labs = Template.bind({});
Labs.args = {
  component: labs,
  content: certified,
};

export const Clia = Template.bind({});
Clia.args = {
  component: clias,
  content: clia,
};

export const Reports = Template.bind({});
Reports.args = {
  component: report,
  content: reports,
};

export const SafeAndHygenic = Template.bind({});
SafeAndHygenic.args = {
  component: safes,
  content: safe,
};
