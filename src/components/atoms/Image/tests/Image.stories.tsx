import React from "react";
import Image from "..";
import { ComponentStory, ComponentMeta } from "@storybook/react";

export default {
  title: "Atoms/Image",
  component: Image,
} as ComponentMeta<typeof Image>;

const Template: ComponentStory<typeof Image> = (args) => <Image {...args} />;

export const BodyTestImg = Template.bind({});
BodyTestImg.args = {
  src: require("../../../../assets/body_test.png"),
};

export const CardiacImg = Template.bind({});
CardiacImg.args = {
  src: require("../../../../assets/cardiac.png"),
};

export const FamilyImg = Template.bind({});
FamilyImg.args = {
  src: require("../../../../assets/family.png"),
};

export const PaymentSuccessImg = Template.bind({});
PaymentSuccessImg.args = {
  src: require("../../../../assets/payment_success.png"),
};

export const StressImg = Template.bind({});
StressImg.args = {
  src: require("../../../../assets/stress.png"),
};

export const GooglePlayImg = Template.bind({});
GooglePlayImg.args = {
  src: require("../../../../assets/google_play.png"),
};

export const AppStoreImg = Template.bind({});
AppStoreImg.args = {
  src: require("../../../../assets/app_store.png"),
};
