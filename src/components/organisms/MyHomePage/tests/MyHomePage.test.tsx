import React from "react";

import "@testing-library/jest-dom/extend-expect";
import { render } from "@testing-library/react";
import MyHomePage from "..";

test("HomePageFAQ Render", async () => {
  render(<MyHomePage />);
});
