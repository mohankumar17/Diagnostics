import React from "react";
import Icon from "../../atoms/Icon";
import theme from "../../theme";
import { styled } from "@mui/system";
import { Stack, Typography, SvgIconProps, Button } from "@mui/material";

const StackA = styled(Stack)({
  flexDirection: "row",
  gap: "10px",
});

const StackB = styled(Stack)({
  flexDirection: "column",
  gap: "3px",
});

const StackC = styled(Stack)({
  flexDirection: "row",
  alignItems: "start",
  justifyContent: "space-between",
  maxWidth: "45.454545vw",
});

const StackD = styled(Stack)({
  flexDirection: "column",
  gap: "4px",
});

const IconA = styled(Icon)({
  width: "60px",
  height: "60px",
});

const FeatureTypography = styled(Typography)({
  color: `${theme.palette.text.primary}`,
});

const FeatureTypography1 = styled(Typography)({
  color: `${theme.palette.text.disabled}`,
});

const FeatureTypography2 = styled(Typography)({
  color: `${theme.palette.primary.main}`,
  marginTop: "13px",
});

interface FeatureboxProps extends SvgIconProps {
  component?:
    | React.FunctionComponent<
        React.SVGProps<SVGSVGElement> & {
          title?: string;
        }
      >
    ; 
  content1?: string;
  content2?: string;
  content3?: string;
}

const Usermolecule = (props: FeatureboxProps) => {
  return (
    <StackC>
      <StackA data-testid="stack">
        <IconA
          component={props.component}
          inheritViewBox={true}
          fontSize="large"
          sx={{ fill: "none" }}
        ></IconA>
        <StackB>
          <FeatureTypography data-testid="heading" variant="subtitle1">
            {props.content1}
          </FeatureTypography>
          <StackD>
            <FeatureTypography1
              data-testid="nameText"
              variant="overlineRegular"
            >
              {props.content2}
            </FeatureTypography1>
            <FeatureTypography1
              data-testid="expiryText"
              variant="overlineRegular"
            >
              {props.content3}
            </FeatureTypography1>
          </StackD>
        </StackB>
      </StackA>
      <Button>
        <FeatureTypography2 variant="bodyMedium">Edit</FeatureTypography2>
      </Button>
    </StackC>
  );
};
export default Usermolecule;
