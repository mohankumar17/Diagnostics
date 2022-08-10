import React from "react";
import { Stack, Typography, Grid } from "@mui/material";
import { styled } from "@mui/system";
import theme from "../../theme";
import { ReactComponent as home } from "../../../assets/icons/house.svg";
import { ReactComponent as doctor } from "../../../assets/icons/doctors.svg";
import { ReactComponent as torch } from "../../../assets/icons/torch.svg";
import { ReactComponent as report } from "../../../assets/icons/graphs.svg";

import {
  covidTestHeading,
  testInfoHome,
  testInfoReports,
  testInfoTorch,
  testInfoConsultation,
  TestCostTimeDetails,
  CovidRTPCRInfo,
  packageBenefits,
} from "../../../assets/constants";
import Feauturebox from "../Featurebox";
import TestCostTimeInfo from "../TestCostTimeInfo";
import InfoBox from "../../atoms/InfoBox";

const StackContainer = styled(Stack)({
  flexDirection: "column",
  alignItems: "flex-start",
  gap: "2.25em",
  maxWidth: "36.4375em",
  minWidth: "fit-content",
  backgroundColor: `${theme.palette.background.default}`,
  boxShadow: "0px 0px 26px rgba(233, 232, 237, 0.5)",
  borderRadius: "0.5em",
  padding: "1.5em 0.75em",
  [theme.breakpoints.down("sm")]: {
    padding: "0.1em",
  },
});

const StackA = styled(Stack)({
  flexDirection: "column",
  alignItems: "flex-start",
  gap: "1.5em",
});

const FeatureboxGrid = styled(Grid)({
  flexDirection: "row",
  alignItems: "center",
  justifyContent: "space-between",
  gap: "0.5em",
});

const InfoText = styled(Typography)({
  color: `${theme.palette.text.secondary}`,
});

const PackageHeading = styled(Typography)({
  color: `${theme.palette.text.disabled}`,
});

const List = styled("ul")({
  paddingLeft: "0.75em",
  maxWidth: "35em",
  minWidth: "fit-content",
  margin: "0",
});
const ListItem = styled("li")({
  marginBottom: "0.5em",
});

const Package = styled(Stack)({
  flexDirection: "column",
  gap: "0.5em",
});

const Benefits = styled(Grid)({
  flexDirection: "row",
  gap: "1em",
  alignItems: "center",
  justifyContent: "space-between",
});

const CovidRTPCR = () => {
  const { packHeading, packItems } = packageBenefits;
  const featureBoxItems = [
    {
      component: home,
      content: testInfoHome,
    },
    {
      component: torch,
      content: testInfoTorch,
    },
    {
      component: doctor,
      content: testInfoConsultation,
    },
    {
      component: report,
      content: testInfoReports,
    },
  ];
  return (
    <StackContainer>
      <Typography variant="subtitle1" data-testid="testHeading">
        {covidTestHeading}
      </Typography>
      <StackA>
        <FeatureboxGrid container>
          {featureBoxItems.map((eachItem, index: number) => (
            <Grid item xs={4} md={2} key={index}>
              <Feauturebox
                component={eachItem.component}
                content={eachItem.content}
              />
            </Grid>
          ))}
        </FeatureboxGrid>
        <TestCostTimeInfo cardContents={TestCostTimeDetails} />
        <List>
          {CovidRTPCRInfo.map((eachItem: string, index: number) => (
            <ListItem key={index}>
              <InfoText variant="overlineRegular">{eachItem}</InfoText>
            </ListItem>
          ))}
        </List>
        <Package>
          <PackageHeading variant="caption" data-testid="packageHeading">
            {packHeading}
          </PackageHeading>
          <Benefits container>
            {packItems.map((eachItem: string, index: number) => (
              <Grid item xs={6} md={3} key={index}>
                <InfoBox key={index} info={eachItem} />
              </Grid>
            ))}
          </Benefits>
        </Package>
      </StackA>
    </StackContainer>
  );
};

export default CovidRTPCR;
