import React from "react";
import { render, screen } from "@testing-library/react";
import InfoBox from "..";

describe("Testing the InfoBox", () => {
  it("render default InfoBox", () => {
    render(
      <InfoBox
        info={"To check if you have an active COVID-19 infection"}
      ></InfoBox>,
    );
    const info = screen.getByTestId("info");
    expect(info.textContent).toBe(
      "To check if you have an active COVID-19 infection",
    );
  });
});
