import React, { useState } from "react";
import { Box, Grid, styled } from "@mui/material";
import Image from "../../atoms/Image";
import Tabs from "../../molecules/HomePageTabs/index";
import { tabs } from "./constants";
import TextField from "@mui/material/TextField";
import { ReactComponent as downicon } from "../../../assets/icons/chevron-down.svg";
import { ReactComponent as locationicon } from "../../../assets/icons/map-pin-1.svg";
import { ReactComponent as usericon } from "../../../assets/icons/user-1.svg";
import { ReactComponent as shoppingicon } from "../../../assets/icons/shopping-cart.svg";
import logo from "../../../assets/logoname.png";
import Icon from "../../atoms/Icon";
import theme from "../../theme";

interface Props {
  location: string;
  // eslint-disable-next-line no-unused-vars
  tabValue?: (val: number) => void;
  onClick?: any;
}

const CDiv = styled("div")({
  width: "100%",
  display: "flex",
  justifyContent: "center",
});

const StyledGrid = styled(Grid)({
  [theme.breakpoints.down("xs")]: {
    width: "100%",
    flexDirection: "column",
  },
  [theme.breakpoints.down("sm")]: {
    width: "100%",
    flexDirection: "column",
  },
  [theme.breakpoints.down("md")]: {
    width: "100%",
  },
  [theme.breakpoints.up("lg")]: {
    width: "1186px",
  },
  [theme.breakpoints.up("xl")]: {
    width: "1186px",
  },
});

const Header = ({ location, tabValue, onClick }: Props) => {
  const [value, setValue] = useState<number>(0);
  const stateHandler = (val: number) => {
    setValue(val);
    tabValue && tabValue(val);
  };

  return (
    <CDiv>
      <StyledGrid
        data-testid="header"
        display="flex"
        justifyContent="space-between"
        alignItems="center"
        boxShadow="0px 0px 26px rgba(233, 232, 237, 0.5)"
        minHeight="46px"
      >
        <Box display="flex">
          <Image src={logo}></Image>
        </Box>

        <Box>
          <Tabs tabs={tabs} stateHandler={stateHandler} value={value}></Tabs>
        </Box>

        <Box
          display="flex"
          justifyContent="space-between"
          alignItems="center"
          width="400px"
        >
          <TextField
            variant="standard"
            inputProps={{
              "data-testid": "location",
            }}
            InputProps={{
              startAdornment: (
                <Box marginTop="5px">
                  <Icon component={locationicon}></Icon>
                </Box>
              ),
              endAdornment: (
                <Box marginTop="7px">
                  <Icon component={downicon}></Icon>
                </Box>
              ),
              sx: { fontSize: "14px" },
            }}
            value={location}
          ></TextField>
          <Box sx={{ marginTop: "15px" }}>
            <Icon onClick={onClick} component={usericon}></Icon>
          </Box>
          <Box sx={{ marginTop: "5px" }}>
            <Icon component={shoppingicon}></Icon>
          </Box>
        </Box>
      </StyledGrid>
    </CDiv>
  );
};

export default Header;
