import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Header from "../../organisms/Header";
import MyAppointment from "../../organisms/MyAppointment";
import MyReport from "../../organisms/MyReport";
import { styled } from "@mui/system";
import { Stack } from "@mui/material";
import LogoutOrganism from "../../organisms/LoginOrganism";
import MyHomePage from "../../organisms/MyHomePage";
import { useAuth0 } from "@auth0/auth0-react";
import { getUserIdByEmail, postUser } from "../../../services";

const StackContainer = styled(Stack)({
  flexDirection: "column",
});

const HomePage = () => {
  const navigate = useNavigate();
  const [value, setValue] = useState<number>(0);

  const getTabValue = (vals: number) => {
    setValue(vals);
  };
  const [val, setVal] = useState(false);

  const handleChange = () => {
    setVal(!val);
  };

  const { user }: any = useAuth0();
  let currentUserId = 0;
  const [isAdded, setIsAdded] = useState<boolean>(false);
  const userData: {
    email: string;
    name: string;
  } = {
    email: user.email,
    name: user.name,
  };

  const addUser = async () => {
    await postUser(userData);
    setIsAdded(true);
  };

  const getUserId = async () => {
    let id: number = 0;
    id = await getUserIdByEmail(userData.email);
    currentUserId = id;
  };

  if (isAdded) {
    getUserId();
  } else {
    addUser();
  }

  return (
    <>
      {val === true && (
        <>
          <Header
            onClick={handleChange}
            location="Mountain view, CA, USA"
            tabValue={getTabValue}
          />
          <LogoutOrganism />
        </>
      )}
      {val === false && (
        <>
          <Header
            onClick={handleChange}
            location="Mountain view, CA, USA"
            tabValue={getTabValue}
          />
          <StackContainer>
            {value === 0 && (
              <MyHomePage
                covidClick={() =>
                  navigate("/booking", {
                    state: currentUserId,
                  })
                }
              />
            )}
            {value === 1 && <MyReport />}
            {value === 2 && <MyAppointment />}
          </StackContainer>
        </>
      )}
    </>
  );
};

export default HomePage;
