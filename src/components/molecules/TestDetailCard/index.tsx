import React from "react";
import { Stack, Box, Typography } from "@mui/material";
import { ReactComponent as share } from "../../../assets/icons/share.svg";
import { ReactComponent as download } from "../../../assets/icons/download.svg";
import { styled } from "@mui/system";
import theme from "../../theme";
import Image from "../../atoms/Image";
import Icon from "../../atoms/Icon";

interface TestDetailProps {
  testDisplayIcon: string;
  testName: string;
  labName: string;
  patientName: string;
  time: string;
}

const BoxCard = styled(Box)({
  maxWidth: "36.4375em",
  minWidth: "fit-content",
  padding: "0.75em 1em",
  border: "0.5px solid",
  borderColor: `${theme.palette.grey[50]}`,
  backgroundColor: `${theme.palette.background.default}`,
  boxShadow: "0px 0px 12px rgba(233, 232, 237, 0.53)",
  borderRadius: "0.5em",
});

const StackContainer = styled(Stack)({
  flexDirection: "row",
  alignItems: "center",
  gap: "1.875em",
});

const IconStackA = styled(Stack)({
  alignItems: "center",
  justifyContent: "center",
});

const IconStackB = styled(Stack)({
  flexDirection: "row",
  gap: "1.5em",
  alignItems: "center",
  justifyContent: "center",
});

const Content = styled(Stack)({
  flexDirection: "row",
  alignItems: "flex-start",
  justifyContent: "space-between",
  width: "32.1875em",
});

const TextStack = styled(Stack)({
  flexDirection: "column",
  gap: "1em",
  alignItems: "flex-start",
});

const StackA = styled(Stack)({
  flexDirection: "column",
  gap: "0.25em",
  alignItems: "flex-start",
});

const StackB = styled(Stack)({
  flexDirection: "row",
  gap: "0.25em",
  alignItems: "flex-start",
});

const TestName = styled(Typography)({
  fontWeight: "500",
  color: `${theme.palette.text.primary}`,
});

const LabName = styled(Typography)({
  color: `${theme.palette.text.primary}`,
});

const RegCapText = styled(Typography)({
  color: `${theme.palette.text.secondary}`,
});

const ReportDetail = ({
  testDisplayIcon,
  testName,
  labName,
  patientName,
  time,
}: TestDetailProps) => {
  return (
    <BoxCard data-testid="testdetail">
      <StackContainer>
        <IconStackA>
          <Image src={testDisplayIcon} />
        </IconStackA>
        <Content>
          <TextStack>
            <StackA>
              <StackB>
                <TestName variant="regularCaption">{testName}</TestName>
                <LabName variant="regularCaption">{labName}</LabName>
              </StackB>
              <RegCapText variant="regularCaption">{patientName}</RegCapText>
            </StackA>
            <RegCapText variant="regularCaption">{time}</RegCapText>
          </TextStack>
          <IconStackB>
            <Icon component={share} />
            <Icon component={download} />
          </IconStackB>
        </Content>
      </StackContainer>
    </BoxCard>
  );
};

export default ReportDetail;
