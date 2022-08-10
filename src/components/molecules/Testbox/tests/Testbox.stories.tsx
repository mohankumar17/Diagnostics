import React from "react";
import { ComponentStory, ComponentMeta } from "@storybook/react";
import Testbox from "../index";
import { ReactComponent as body } from "../../../../assets/icons/body.svg";
import { ReactComponent as covid } from "../../../../assets/icons/covid.svg";
import { ReactComponent as liver } from "../../../../assets/icons/liver.svg";
import { ReactComponent as blood } from "../../../../assets/icons/bloodtest.svg";
import { ReactComponent as diabetes } from "../../../../assets/icons/diabetestest.svg";
import { ReactComponent as kidney } from "../../../../assets/icons/kidney.svg";
import { ReactComponent as thyroid } from "../../../../assets/icons/throid.svg";
import { ReactComponent as lipid } from "../../../../assets/icons/lipid.svg";
import {
  testBoxText,
  testBloodText,
  testCovidText,
  testDiabetesText,
  testKidneyText,
  testLipidText,
  testLiverText,
  testThyroidText,
} from "../../../../assets/constants";

export default {
  title: "Molecules/Testbox",
  component: Testbox,
} as ComponentMeta<typeof Testbox>;

const Template: ComponentStory<typeof Testbox> = (args) => (
  <Testbox {...args} />
);

export const Default = Template.bind({});
Default.args = {
  component: body,
  content: testBoxText,
};

export const Covid = Template.bind({});
Covid.args = {
  component: covid,
  content: testCovidText,
};

export const Liver = Template.bind({});
Liver.args = {
  component: liver,
  content: testLiverText,
};

export const Blood = Template.bind({});
Blood.args = {
  component: blood,
  content: testBloodText,
};

export const Diabetes = Template.bind({});
Diabetes.args = {
  component: diabetes,
  content: testDiabetesText,
};

export const Kidney = Template.bind({});
Kidney.args = {
  component: kidney,
  content: testKidneyText,
};

export const Thyroid = Template.bind({});
Thyroid.args = {
  component: thyroid,
  content: testThyroidText,
};

export const Lipid = Template.bind({});
Lipid.args = {
  component: lipid,
  content: testLipidText,
};
