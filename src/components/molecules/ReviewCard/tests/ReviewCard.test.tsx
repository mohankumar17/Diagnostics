import React from "react";
import { render, screen } from "@testing-library/react";
import ReviewCard from "..";
import avatar1 from "../../../../assets/avatar1.png";

describe("Testing the ReviewCard", () => {
  it("render default ReviewCard", () => {
    render(
      <ReviewCard
        avatar={avatar1}
        name={"Abby"}
        address={"San Jose, CA"}
        review={
          "“Very friendly and professional. Loved the follow-up and progress calls”"
        }
      />,
    );
    const name = screen.getByTestId("name");
    expect(name.textContent).toBe("Abby");

    const address = screen.getByTestId("address");
    expect(address.textContent).toBe("San Jose, CA");

    const review = screen.getByTestId("review");
    expect(review.textContent).toBe(
      "“Very friendly and professional. Loved the follow-up and progress calls”",
    );
  });
});
