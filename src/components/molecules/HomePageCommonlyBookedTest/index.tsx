import { Grid, styled, Typography } from "@mui/material";
import React from "react";
import {
  CommonlyBookedTest,
  CompleteBloodCount,
  CovidRTPCR,
  DiabetesTest,
  FullbodyCheck,
  KidneyFunctionTest,
  LipidProfile,
  LiverFunctionTest,
  Seemore,
  ThyroidTest,
} from "../../../assets/constants";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import Testbox from "../../molecules/Testbox";

import { ReactComponent as body } from "../../../assets/icons/body.svg";
import { ReactComponent as covid } from "../../../assets/icons/covid.svg";
import { ReactComponent as liver } from "../../../assets/icons/liver.svg";
import { ReactComponent as blood } from "../../../assets/icons/bloodtest.svg";
import { ReactComponent as diabetes } from "../../../assets/icons/diabetestest.svg";
import { ReactComponent as kidney } from "../../../assets/icons/kidney.svg";
import { ReactComponent as thyroid } from "../../../assets/icons/throid.svg";
import { ReactComponent as lipid } from "../../../assets/icons/lipid.svg";
import ButtonComponent from "../../atoms/Button";
import Icon from "../../atoms/Icon";

interface CommonlyBookedTestProps {
  covidClick?: React.MouseEventHandler<HTMLButtonElement>;
}

const FlexDiv = styled("div")({
  display: "flex",
});

const FlexSBDiv = styled("div")({
  display: "flex",
  justifyContent: "space-between",
});

const MTN35Div = styled("div")({
  marginTop: "-0.21875em",
});

const MLN18Icon = styled(Icon)({
  marginLeft: "-1.25em",
});

const ML92W80Div = styled("div")({
  marginTop: "2.5em",
  display: "flex",
  alignItems: "center",
});

const MT32Div = styled("div")({
  marginTop: "2em",
});

const FlexSBDMB13Div = styled("div")({
  display: "flex",
  justifyContent: "space-between",
  marginBottom: "0.8125em",
});

const PDiv = styled("div")({
  maxWidth: "1186px",
});

const MR10MTN5Div = styled("div")({
  marginLeft: "-0.3125em",
  marginTop: "-0.3125em",
});

const MT1 = styled("div")({
  marginTop: "0.9em",
});

function HomePageCommonlyBookedTest({ covidClick }: CommonlyBookedTestProps) {
  return (
    <ML92W80Div>
      <PDiv>
        <FlexSBDiv>
          <Typography variant="heading1">{CommonlyBookedTest}</Typography>
          <MT1>
            <FlexDiv>
              <Typography variant="captionMedium" color="primary">
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
        <MT32Div>
          <FlexSBDMB13Div>
            <Grid container spacing={4} justifyContent="center">
              <Grid item xs={7} sm={6} md={4} lg={3} xl={3}>
                <Testbox
                  component={body}
                  content={FullbodyCheck}
                  data-testid="testBox1"
                />
              </Grid>
              <Grid item xs={7} sm={6} md={4} lg={3} xl={3}>
                <MR10MTN5Div>
                  <ButtonComponent
                    onClick={covidClick}
                    data-testid="covidClick"
                  >
                    <Testbox
                      component={covid}
                      content={CovidRTPCR}
                      data-testid="testBox2"
                    />
                  </ButtonComponent>
                </MR10MTN5Div>
              </Grid>
              <Grid item xs={7} sm={5} md={4} lg={3} xl={3}>
                <Testbox
                  component={liver}
                  content={LiverFunctionTest}
                  data-testid="testBox3"
                />
              </Grid>
              <Grid item xs={7} sm={5} md={4} lg={3} xl={3}>
                <Testbox
                  component={blood}
                  content={CompleteBloodCount}
                  data-testid="testBox4"
                />
              </Grid>
              <Grid item xs={7} sm={5} md={4} lg={3} xl={3}>
                <Testbox
                  component={diabetes}
                  content={DiabetesTest}
                  data-testid="testBox5"
                />
              </Grid>
              <Grid item xs={7} sm={5} md={4} lg={3} xl={3}>
                <Testbox
                  component={kidney}
                  content={KidneyFunctionTest}
                  data-testid="testBox6"
                />
              </Grid>
              <Grid item xs={7} sm={5} md={4} lg={3} xl={3}>
                <Testbox
                  component={thyroid}
                  content={ThyroidTest}
                  data-testid="testBox7"
                />
              </Grid>
              <Grid item xs={7} sm={5} md={4} lg={3} xl={3}>
                <Testbox
                  component={lipid}
                  content={LipidProfile}
                  data-testid="testBox8"
                />
              </Grid>
            </Grid>
          </FlexSBDMB13Div>
        </MT32Div>
      </PDiv>
    </ML92W80Div>
  );
}

export default HomePageCommonlyBookedTest;
