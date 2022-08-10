import React from "react";
import { styled } from "@mui/system";
import { Stack } from "@mui/material";
import Usermolecule from "../../molecules/UserMolecule";
import { ReactComponent as userIcon } from "../../../assets/icons/UserProfile.svg";
import Trackordermolecule from "../../molecules/LogoutMolecule";
import { useAuth0 } from "@auth0/auth0-react";
import { ReactComponent as logouticon } from "../../../assets/icons/log-out.svg";
import { logoutcontent, userNumber , logoutItems} from "../../../assets/constants";

const StackF = styled(Stack)({
  justifyItems: "center",
  alignItems: "center",
});

const StackA = styled(Stack)({
  flexDirection: "column",
  gap: "45px",
  zIndex: 6,
  padding: "67px 55.75px 38px 103px",
});

const StackB = styled(Stack)({
  flexDirection: "column",
  marginLeft: "7.177489vw",
  marginRight: "5.177489vw",
});

const StackC = styled(Stack)({
  flexDirection: "column",
  gap: "32px",
});

const LogoutOrganism = () => {
  const { user, logout } = useAuth0();

  return (
    <StackF>
      <StackA>
        <StackB>
          <Usermolecule
            component={userIcon}
            content1={user?.name}
            content2={user?.email}
            content3={userNumber}
          />
        </StackB>
        <StackC>
          {logoutItems.map((item, index: number) => (
            <Trackordermolecule
              key={index}
              component={item.component}
              content1={item.content1}
              content2={item.content2}
            />
          ))}
          <Trackordermolecule
            onClick={() => logout()}
            component={logouticon}
            content1={logoutcontent}
          ></Trackordermolecule>
        </StackC>
      </StackA>
    </StackF>
  );
};
export default LogoutOrganism;
