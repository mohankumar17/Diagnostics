import React from "react";
import { render } from "@testing-library/react";
import Image from "..";

test("Images rendering", () => {
  render(<Image src={require("../../../../assets/body_test.png")} />);
});
