import React from "react";
import { fireEvent, render, screen } from "@testing-library/react";
import SelectAppointmentForm from "..";

describe("Testing the SelectAppointmentForm", () => {
  it("render default SelectAppointmentForm", () => {
    render(
      <SelectAppointmentForm
        month={"January"}
        date={1}
        day={"Monday"}
        time={"6.00am - 7.00am"}
      />,
    );
    const januaryButton = screen.getByTestId("January");
    expect(januaryButton).toBeDefined();

    const februaryButton = screen.getByTestId("February");
    expect(februaryButton).toBeDefined();

    const marchButton = screen.getByTestId("March");
    expect(marchButton).toBeDefined();

    const monthScroll = screen.getByTestId("monthScroll");
    fireEvent.click(monthScroll);

    const aprilButton = screen.getByTestId("April");
    expect(aprilButton).toBeDefined();

    fireEvent.click(monthScroll);

    const mayButton = screen.getByTestId("May");
    expect(mayButton).toBeDefined();

    fireEvent.click(monthScroll);

    const juneButton = screen.getByTestId("June");
    expect(juneButton).toBeDefined();

    fireEvent.click(monthScroll);

    const julyButton = screen.getByTestId("July");
    expect(julyButton).toBeDefined();

    fireEvent.click(monthScroll);

    const augustButton = screen.getByTestId("August");
    expect(augustButton).toBeDefined();

    fireEvent.click(monthScroll);

    const septemberButton = screen.getByTestId("September");
    expect(septemberButton).toBeDefined();

    fireEvent.click(septemberButton);

    fireEvent.click(monthScroll);

    const octoberButton = screen.getByTestId("October");
    expect(octoberButton).toBeDefined();

    fireEvent.click(monthScroll);

    const novemberButton = screen.getByTestId("November");
    expect(novemberButton).toBeDefined();

    fireEvent.click(monthScroll);

    const decemberButton = screen.getByTestId("December");
    expect(decemberButton).toBeDefined();

    fireEvent.click(monthScroll);

    const day1Button = screen.getByTestId("1");
    expect(day1Button).toBeDefined();

    const day2Button = screen.getByTestId("2");
    expect(day2Button).toBeDefined();

    const day3Button = screen.getByTestId("3");
    expect(day3Button).toBeDefined();

    const day4Button = screen.getByTestId("4");
    expect(day4Button).toBeDefined();

    const day5Button = screen.getByTestId("5");
    expect(day5Button).toBeDefined();

    const day6Button = screen.getByTestId("6");
    expect(day6Button).toBeDefined();

    const dayScroll = screen.getByTestId("dayScroll");
    fireEvent.click(dayScroll);

    const day7Button = screen.getByTestId("7");
    expect(day7Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day8Button = screen.getByTestId("8");
    expect(day8Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day9Button = screen.getByTestId("9");
    expect(day9Button).toBeDefined();

    fireEvent.click(day9Button);

    fireEvent.click(dayScroll);

    const day10Button = screen.getByTestId("10");
    expect(day10Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day11Button = screen.getByTestId("11");
    expect(day11Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day12Button = screen.getByTestId("12");
    expect(day12Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day13Button = screen.getByTestId("13");
    expect(day13Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day14Button = screen.getByTestId("14");
    expect(day14Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day15Button = screen.getByTestId("15");
    expect(day15Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day16Button = screen.getByTestId("16");
    expect(day16Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day17Button = screen.getByTestId("17");
    expect(day17Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day18Button = screen.getByTestId("18");
    expect(day18Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day19Button = screen.getByTestId("19");
    expect(day19Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day20Button = screen.getByTestId("20");
    expect(day20Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day21Button = screen.getByTestId("21");
    expect(day21Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day22Button = screen.getByTestId("22");
    expect(day22Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day23Button = screen.getByTestId("23");
    expect(day23Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day24Button = screen.getByTestId("24");
    expect(day24Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day25Button = screen.getByTestId("25");
    expect(day25Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day26Button = screen.getByTestId("26");
    expect(day26Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day27Button = screen.getByTestId("27");
    expect(day27Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day28Button = screen.getByTestId("28");
    expect(day28Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day29Button = screen.getByTestId("29");
    expect(day29Button).toBeDefined();

    fireEvent.click(dayScroll);

    const day30Button = screen.getByTestId("30");
    expect(day30Button).toBeDefined();

    fireEvent.click(dayScroll);

    const time6Button = screen.getByTestId("06.00 - 07.00");
    expect(time6Button).toBeDefined();

    const time7Button = screen.getByTestId("07.00 - 08.00");
    expect(time7Button).toBeDefined();

    const time8Button = screen.getByTestId("08.00 - 09.00");
    expect(time8Button).toBeDefined();

    const time9Button = screen.getByTestId("09.00 - 10.00");
    expect(time9Button).toBeDefined();

    fireEvent.click(time9Button);

    const time10Button = screen.getByTestId("10.00 - 11.00");
    expect(time10Button).toBeDefined();

    const time11Button = screen.getByTestId("11.00 - 12.00");
    expect(time11Button).toBeDefined();

    const time12Button = screen.getByTestId("12.00 - 01.00");
    expect(time12Button).toBeDefined();

    const time13Button = screen.getByTestId("01.00 - 02.00");
    expect(time13Button).toBeDefined();

    const time14Button = screen.getByTestId("02.00 - 03.00");
    expect(time14Button).toBeDefined();

    const time15Button = screen.getByTestId("03.00 - 04.00");
    expect(time15Button).toBeDefined();

    const time16Button = screen.getByTestId("04.00 - 05.00");
    expect(time16Button).toBeDefined();

    const time17Button = screen.getByTestId("05.00 - 06.00");
    expect(time17Button).toBeDefined();
  });
});
