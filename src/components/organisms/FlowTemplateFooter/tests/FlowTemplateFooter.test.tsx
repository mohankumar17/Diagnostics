import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import FlowTemplateFooter from "..";
import { testBookingFlow } from "../../../../assets/constants";
import { MemoryRouter } from "react-router-dom";

test("Footer for Test Booking Flow Render", () => {
  render(<FlowTemplateFooter testBookingDetails={0} />, {
    wrapper: MemoryRouter,
  });

  const cancelButtonTextEl = screen.getByTestId("cancel-btn-text");
  expect(cancelButtonTextEl.textContent).toBe("Cancel");

  const cancelButtonEl = screen.getByTestId("cancel-btn");
  fireEvent.click(cancelButtonEl);
});

test("Test Details", () => {
  for (let eachState = 0; eachState < testBookingFlow.length; eachState++) {
    render(<FlowTemplateFooter testBookingDetails={eachState} />, {
      wrapper: MemoryRouter,
    });
  }
});

test("Flow Button Check", () => {
  render(<FlowTemplateFooter testBookingDetails={0} />, {
    wrapper: MemoryRouter,
  });

  const flowButtonEl = screen.getByTestId("flow-btn");

  for (let eachState = 0; eachState < testBookingFlow.length - 1; eachState++) {
    fireEvent.click(flowButtonEl);
  }
});

test("Home Button Check", () => {
  render(<FlowTemplateFooter testBookingDetails={8} />, {
    wrapper: MemoryRouter,
  });

  const homeButtonEl = screen.getByTestId("home-btn");
  fireEvent.click(homeButtonEl);
});

test("Select Patients Check", () => {
  render(<FlowTemplateFooter testBookingDetails={1} selPatients={3} />, {
    wrapper: MemoryRouter,
  });

  const patSelEl = screen.getByTestId("patient-sel");
  expect(patSelEl.textContent).toBe("3 Patients Selected");
});
