import React from "react";
import { Typography, Stack } from "@mui/material";
import covid from "../../../assets/icons/covid.png";
import body from "../../../assets/icons/body.png";
import { styled } from "@mui/system";
import theme from "../../theme";
import TestDetail from "../../molecules/TestDetailCard";

type itemsType = {
  testDisplayIcon: string;
  testName: string;
  labName: string;
  patientName: string;
  time: string;
};

type AppointmentTemplateType = {
  heading: string;
  upcoming: string;
  recent: string;
  upcoming_items: itemsType[];
  recent_items: itemsType[];
};

export const SubTitle = styled(Typography)({
  color: `${theme.palette.text.secondary}`,
});

export const HeadingText = styled(Typography)({
  fontWeight: "700",
  color: `${theme.palette.text.secondary}`,
});

export const StackContainer = styled(Stack)({
  flexDirection: "column",
  alignItems: "flex-start",
  gap: "2.5em",
  marginLeft: "4.5em",
});

export const StackItem = styled(Stack)({
  flexDirection: "column",
  alignItems: "flex-start",
  justifyContent: "flex-start",
  gap: "2.25em",
});

const MDiv = styled("div")({
  [theme.breakpoints.down("xs")]: {
    marginTop: "2.5em",
  },
  [theme.breakpoints.down("sm")]: {
    marginTop: "2.5em",
  },
  [theme.breakpoints.down("md")]: {
    marginTop: "2.5em",
  },
  [theme.breakpoints.up("lg")]: {
    margin: "2.5em 0em 0em 1.6em",
  },
  [theme.breakpoints.up("xl")]: {
    margin: "2.5em 0em 0em 17em",
  },
});

const MyAppointment = () => {
  const testDetails: AppointmentTemplateType = {
    heading: "Appointments",
    upcoming: "Upcoming Tests",
    recent: "Recent Tests",
    upcoming_items: [
      {
        testDisplayIcon: covid,
        testName: "Covid RTPCR",
        labName: "- Los Altos Center Lab",
        patientName: "Patrick Smith",
        time: "Wed 23, 7.00 am to 8.00 am",
      },
    ],
    recent_items: [
      {
        testDisplayIcon: body,
        testName: "Full Body Checkup",
        labName: "- Los Altos Center Lab",
        patientName: "Paul Tyson",
        time: "Fri 17, 7.00 am to 8.00 am",
      },
      {
        testDisplayIcon: covid,
        testName: "Covid RTPCR",
        labName: "- Los Altos Center Lab",
        patientName: "John Brandon",
        time: "Wed 15, 7.00 am to 8.00 am",
      },
    ],
  };

  return (
    <MDiv>
      <StackContainer>
        <HeadingText variant="h1" data-testid="heading-app">
          {testDetails.heading}
        </HeadingText>
        <StackItem>
          <SubTitle variant="subtitle1" data-testid="upcoming-app">
            {testDetails.upcoming}
          </SubTitle>
          {testDetails.upcoming_items.map(
            (eachItem: itemsType, index: number) => (
              <TestDetail key={index} {...eachItem}></TestDetail>
            ),
          )}
        </StackItem>
        <StackItem>
          <SubTitle variant="subtitle1" data-testid="recent-app">
            {testDetails.recent}
          </SubTitle>
          {testDetails.recent_items.map(
            (eachItem: itemsType, index: number) => (
              <TestDetail key={index} {...eachItem}></TestDetail>
            ),
          )}
        </StackItem>
      </StackContainer>
    </MDiv>
  );
};

export default MyAppointment;
