import React from "react";
import { Typography, styled, Grid } from "@mui/material";
import {
  CardiacRiskAssessment,
  ChooseTest,
  fullBodyCheckup,
  Seemore,
  StressAssessment,
  num1299,
  num42,
  time24,
} from "../../../assets/constants";
import TestInfoCard from "../TestInfoCard";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import cardiac from "../../../assets/cardiac.png";
import fullbody from "../../../assets/body_test.png";
import stress from "../../../assets/stress.png";
import Icon from "../../atoms/Icon";

const FlexDiv = styled("div")({
  display: "flex",
});

const FlexSBDiv = styled("div")({
  display: "flex",
  justifyContent: "space-between",
});

const FlexSBDMT32Div = styled("div")({
  marginTop: "2em",
  display: "flex",
});

const MTN35Div = styled("div")({
  marginTop: "-0.21875em",
});

const MLN18Icon = styled(Icon)({
  marginLeft: "-1.25em",
});

const ML105285Div = styled("div")({
  maxWidth: "1186px",
  marginTop: "5em",
});

const MT1 = styled("div")({
  marginTop: "0.9em",
});

const HomePageChooseTest = () => {
  return (
    <ML105285Div>
      <FlexSBDiv>
        <Typography variant="heading1">{ChooseTest}</Typography>
        <MT1>
          <FlexDiv>
            <Typography variant="caption2" color="primary">
              {Seemore}
            </Typography>
            <MTN35Div>
              <Icon color="primary">
                <ChevronRightIcon />
              </Icon>
              <MLN18Icon color="primary">
                <ChevronRightIcon />
              </MLN18Icon>
            </MTN35Div>
          </FlexDiv>
        </MT1>
      </FlexSBDiv>
      <FlexSBDMT32Div>
        <Grid container spacing={4} justifyContent="center">
          <Grid item xs={7} sm={7} md={5} lg={4} xl={4}>
            <TestInfoCard
              data-testid="testInfoCard1"
              imagePath={fullbody}
              cardHeading={fullBodyCheckup}
              cardContents={{
                price: num1299,
                time: time24,
                count: num42,
              }}
            />
          </Grid>
          <Grid item xs={7} sm={7} md={5} lg={4} xl={4}>
            <TestInfoCard
              data-testid="testInfoCard2"
              imagePath={cardiac}
              cardHeading={CardiacRiskAssessment}
              cardContents={{
                price: num1299,
                time: time24,
                count: num42,
              }}
            />
          </Grid>
          <Grid item xs={7} sm={7} md={5} lg={4} xl={4}>
            <TestInfoCard
              data-testid="testInfoCard3"
              imagePath={stress}
              cardHeading={StressAssessment}
              cardContents={{
                price: num1299,
                time: time24,
                count: num42,
              }}
            />
          </Grid>
        </Grid>
      </FlexSBDMT32Div>
    </ML105285Div>
  );
};

export default HomePageChooseTest;
