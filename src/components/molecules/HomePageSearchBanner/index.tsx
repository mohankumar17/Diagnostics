import { styled } from "@mui/material";
import React from "react";
import MainPageBanner from "../../molecules/MainPageBanner";
import SearchBar from "../SearchBar";
import Image from "../../atoms/Image";
import ProgessIndicator from "../../../assets/icons/ProgressIndicator.png";
import theme from "../../theme";

const MW86Div = styled("div")({
  marginTop: "2.5em",
  width: "100%",
  display: "flex",
  justifyContent: "center",
});

const MT2 = styled("div")({
  marginTop: "2em",
});

const MT15 = styled("div")({
  textAlign: "center",
  marginTop: "1.5em",
});

const PDiv = styled("div")({
  [theme.breakpoints.up("xs")]: {
    width: "100%",
  },
  [theme.breakpoints.up("sm")]: {
    width: "100%",
  },
  [theme.breakpoints.up("md")]: {
    width: "100%",
  },
  [theme.breakpoints.up("lg")]: {
    width: "1186px",
  },
  [theme.breakpoints.up("xl")]: {
    width: "1186px",
  },
});

function HomePageSearchBanner() {
  return (
    <MW86Div>
      <PDiv>
        <div>
          <SearchBar data-test-id="searchBar" />
        </div>
        <MT2>
          <MainPageBanner data-test-id="banner" />
        </MT2>
        <MT15>
          <Image src={ProgessIndicator} />
        </MT15>
      </PDiv>
    </MW86Div>
  );
}

export default HomePageSearchBanner;
