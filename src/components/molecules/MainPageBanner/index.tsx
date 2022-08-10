import React from "react";
import { Stack, Typography } from "@mui/material";
import Image from "../../atoms/Image/index";
import {
  bannerHeading,
  bannerCaption,
  bannerButtonText,
} from "../../../assets/constants";
import familyImg from "../../../assets/family.png";
import { styled } from "@mui/system";
import theme from "../../theme";
import Button from "../../atoms/Button";

const StackA = styled(Stack)({
  flexDirection: "row",
  justifyContent: "space-between",
  alignItems: "center",
  padding: "2.5em 3em",
  borderRadius: "0.75em",
  minWidth: "fit-content",
  backgroundColor: `${theme.palette.primary.dark}`,
  [theme.breakpoints.down("sm")]: {
    padding: "0.5em",
  },
});

const StackB = styled(Stack)({
  flexDirection: "column",
  gap: "2.625em",
  [theme.breakpoints.down("sm")]: {
    gap: "1em",
  },
});

const StackC = styled(Stack)({
  flexDirection: "column",
  gap: "0.25em",
});

const BannerHeading = styled(Typography)({
  color: `${theme.palette.background.default}`,
  letterSpacing: "-0.015em",
  [theme.breakpoints.down("sm")]: {
    fontSize: "1em",
    lineHeight: "1",
  },
});

const BannerCaption = styled(Typography)({
  color: `${theme.palette.background.default}`,
  [theme.breakpoints.down("sm")]: {
    fontSize: "0.65em",
  },
});

const BookNowButton = styled(Button)({
  textTransform: "none",
  backgroundColor: `${theme.palette.background.default}`,
  height: "2em",
  width: "6.75em",
  color: `${theme.palette.primary.dark}`,
  padding: "0.375em 1em",
  justifyContent: "center",
  alignItems: "center",
  "&:hover": {
    backgroundColor: `${theme.palette.primary.light}`,
  },
  [theme.breakpoints.down("sm")]: {
    height: "1em",
    width: "4.75em",
  },
});

const ButtonText = styled(Typography)({
  fontSize: "1em",
  fontWeight: "600",
  letterSpacing: "-0.005em",
  lineHeight: "1.25em",
  [theme.breakpoints.down("sm")]: {
    fontSize: "0.5em",
  },
});

const MainPageBanner = () => {
  return (
    <StackA>
      <StackB>
        <StackC>
          <BannerHeading variant="heading1" data-testid="bannerHeadingTest">
            {bannerHeading}
          </BannerHeading>
          <BannerCaption variant="caption2" data-testid="bannerCaptionTest">
            {bannerCaption}
          </BannerCaption>
        </StackC>

        <BookNowButton variant="contained">
          <ButtonText variant="body1">{bannerButtonText}</ButtonText>
        </BookNowButton>
      </StackB>

      <Stack>
        <Image src={familyImg} />
      </Stack>
    </StackA>
  );
};

export default MainPageBanner;
