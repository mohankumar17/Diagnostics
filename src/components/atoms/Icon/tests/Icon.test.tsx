import React from "react";
import renderer from "react-test-renderer";
import Icon from "..";
import PersonOutlineIcon from "@mui/icons-material/PersonOutline";

import { ReactComponent as covid } from "../../../../assets/icons/covid.svg";
import { ReactComponent as reports } from "../../../../assets/icons/reports.svg";

describe("Testing the Icon", () => {
  it("render default Icon", () => {
    const defaultIcon = renderer.create(<Icon component={reports}></Icon>);
    expect(defaultIcon).toBeDefined();
  });

  it("render large Icon", () => {
    const largeIcon = renderer.create(
      <Icon fontSize="large" component={covid} inheritViewBox />,
    );
    expect(largeIcon).toBeDefined();
  });

  it("render MUI Icon", () => {
    const muiIcon = renderer.create(
      <Icon component={undefined}>
        <PersonOutlineIcon />
      </Icon>,
    );
    expect(muiIcon).toBeDefined();
  });

  it("render disabled MUI Icon", () => {
    const disabledMuiIcon = renderer.create(
      <Icon component={undefined} color="disabled">
        <PersonOutlineIcon />
      </Icon>,
    );
    expect(disabledMuiIcon).toBeDefined();
  });

  it("render secondary MUI Icon", () => {
    const secondaryMuiIcon = renderer.create(
      <Icon component={undefined} color="secondary">
        <PersonOutlineIcon />
      </Icon>,
    );
    expect(secondaryMuiIcon).toBeDefined();
  });
});
