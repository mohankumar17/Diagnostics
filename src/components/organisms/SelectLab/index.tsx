import React from "react";
import { styled } from "@mui/system";
import Button from "../../atoms/Button";
import { COLORS } from "../../theme/Colors/index";
import { ReactComponent as addicon } from "../../../assets/icons/add.svg";
import { ReactComponent as sortIcon } from "../../../assets/icons/Vector.svg";
import { Stack, Typography } from "@mui/material";
import LabInfoCard2 from "../LabCard/index";
import Icon from "../../atoms/Icon";
import { labAddtest, labSelect, labsort } from "../../../assets/constants";

type Lab = {
  labName: string;
  testPrice: string;
  totalTestPrice: string;
};

interface LabProps {
  // eslint-disable-next-line no-unused-vars
  setLab?: (l: Lab) => void;
}

const NewPatientButton = styled(Button)({
  marginRight: "29px",
});
const NewPatientText = styled(Typography)({
  color: `${COLORS.ALPHA_BLUE_500}`,
  marginTop: "-0.4375em",
});

const StackA = styled(Stack)({
  flexDirection: "column",
  gap: "26px",
  borderRadius: "8px",
  width: "556px",
  padding: "27px 24px",
  borderColor: `${COLORS.GREY_100}`,
  boxShadow: "0px 0px 12px rgba(233, 232, 237, 0.53)",
});

const StackB = styled(Stack)({
  flexDirection: "row",
  alignItems: "end",
  justifyContent: "flex-end",
  width: "583px",
});
const StackC = styled(Stack)({
  flexDirection: "row",
  alignItems: "start",
  justifyContent: "space-between",
  width: "583px",
});

const StackD = styled(Stack)({
  flexDirection: "row",
  alignItems: "center",
  justifyContent: "center",
  marginTop: "-10px",
});

const StackE = styled(Stack)({
  flexDirection: "row",
  marginTop: "0.5em",
});

const StackF = styled(Stack)({
  gap: "1em",
});
const SelectText = styled(Typography)({
  color: `${COLORS.TEXT_HIGH}`,
  textTransform: "none",
});
const Sort = styled(Typography)({
  color: `${COLORS.TEXT_MEDIUM}`,
  textTransform: "none",
  marginRight: "1.8125em",
});

const Selectlab = ({ setLab }: LabProps) => {
  return (
    <StackA>
      <StackB>
        <NewPatientButton>
          <Icon component={addicon} inheritViewBox={true}></Icon>
          <NewPatientText data-testid="text1" variant="bodyMedium">
            {labAddtest}
          </NewPatientText>
        </NewPatientButton>
      </StackB>
      <StackC>
        <SelectText data-testid="text2" variant="bodyMedium">
          {labSelect}
        </SelectText>
        <StackD>
          <StackE>
            <Icon component={sortIcon} inheritViewBox={true}></Icon>
            <Sort data-testid="text3" variant="overline">
              {labsort}
            </Sort>
          </StackE>
        </StackD>
      </StackC>
      <StackF>
        <LabInfoCard2 setLab={setLab}></LabInfoCard2>
        <LabInfoCard2 setLab={setLab}></LabInfoCard2>
      </StackF>
    </StackA>
  );
};

export default Selectlab;
