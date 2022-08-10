import { Box, Typography } from "@mui/material";
import React, { useState } from "react";
import Image from "../../atoms/Image";
import { styled } from "@mui/system";
import { COLORS } from "../../theme/Colors";
import Button from "../../atoms/Button";
import InputField from "../../molecules/InputField";
import logo from "../../../assets/logoname.png";
import { ReactComponent as apple } from "../../../assets/icons/apple.svg";
import { ReactComponent as facebook } from "../../../assets/icons/facebook-icon.svg";
import { ReactComponent as google } from "../../../assets/icons/google.svg";
import properties from "../../../core-utils/properties";
import { UserService } from "../../../api";
import OtpInput from "react-otp-input";
import Icon from "../../atoms/Icon";
import { useAuth0 } from "@auth0/auth0-react";
import {
  Account,
  Continue,
  EmailIdText,
  EnterOTPRequest,
  FirstName,
  GetOTP,
  Hey,
  LastName,
  LoginConst,
  MobNumber,
  MobileNumberQuestion,
  SignUpWith,
  Verify,
} from "./constants";
import auth0 from "auth0-js";

const OTPStyles: Object = {
  border: "1px solid transparent",
  borderBottom: "1px solid #E9E8ED",
  width: "40px",
  height: "40px",
  backgroundColor: "inherit",
};

const FocusStyles: Object = {
  borderBottom: "1px solid #9F9DA6",
  outline: "none",
};

const Container = styled(Box)({
  display: "flex",
  flexDirection: "column",
  alignItems: "center",
  justifyContent: "flex-start",
  boxShadow: "0px 0px 26px rgba(233, 232, 237, 0.5)",
  background: "#FFFFFF",
  width: "28%",
  height: "74.62%",
  borderRadius: "8px",
});

const Socials = styled(Box)({
  display: "flex",
  justifyContent: "space-evenly",
  alignItems: "center",
  gap: "44px",
  marginTop: "12px",
  marginBottom: "40px",
});
const IconContainer = styled(Box)({
  padding: "8px",
  backgroundColor: `${COLORS.GREY_50}`,
  cursor: "pointer",
});

const Line = styled(Box)({
  width: "21.1%",
  border: `1px solid ${COLORS.GREY_100}`,
});

const MobileNumberContainer = styled(Box)({
  width: "85%",
  display: "flex",
  flexDirection: "column",
  marginTop: "92px",
});

const Question = styled(Typography)({
  color: `${COLORS.TEXT_LOW}`,
  textTransform: "none",
});

const NameText = styled(Typography)({
  color: `${COLORS.TEXT_HIGH}`,
  textTransform: "none",
});

const OtpText = styled(Typography)({
  color: `${COLORS.TEXT_LOW}`,
  textTransform: "none",
  marginTop: "4px",
});

const ButtonText = styled(Typography)({
  color: `${COLORS.BUTTON_TEXT}`,
  textTransform: "none",
});

const SignUpOption = styled(Typography)({
  color: `${COLORS.GREY_300}`,
  textTransform: "none",
  margin: "0px 10px",
});

const LoginText = styled(Typography)({
  color: `${COLORS.TEXT_HIGH}`,
  textTransform: "none",
  fontWeight: "700 !important",
  marginTop: "1px",
});

const ContinueButton = styled(Button)({
  height: "7.72%",
  width: "87.4%",
  padding: "16px 8px",
  borderRadius: "8px",
  marginTop: "5.14%",
  marginBottom: "2.38%",
});
const LoginPage = () => {
  const { loginWithRedirect } = useAuth0();
  const [disabled, setDisabled] = useState<boolean>(true);
  const [disabledOTP, setDisabledOTP] = useState<boolean>(true);
  const [disabledVerify, setDisabledVerify] = useState<boolean>(true);
  const [stage, setStage] = useState<string>("signup");
  const [name, setName] = useState<string>("");
  const [code, setCode] = useState<string>("");
  const handleChange = (
    // eslint-disable-next-line no-unused-vars
    _e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>,
  ) => {
    const firstname = document.getElementById("firstname") as HTMLInputElement;
    const lastname = document.getElementById("lastname") as HTMLInputElement;
    const email = document.getElementById("email") as HTMLInputElement;
    if (
      firstname?.value.length > 0 &&
      lastname?.value.length > 0 &&
      email?.value.length > 0
    ) {
      setDisabled(false);
    } else {
      setDisabled(true);
    }
  };

  const handleContinueClick = () => {
    const firstname = document.getElementById("firstname") as HTMLInputElement;
    setName(firstname.value);
    changeStage();
  };
  const handleOTPChange = () => {
    const mobile = document.getElementById("mobile") as HTMLInputElement;
    if (mobile.value.length === 10) {
      setDisabledOTP(false);
    } else {
      setDisabledOTP(true);
    }
  };
  const loginWithGoogle = () => {
    const webAuth = new auth0.WebAuth({
      domain: properties.auth0Domain,
      clientID: properties.auth0ClientId,
    });

    webAuth.popup.authorize(
      {
        nonce: "diagnostics",
        redirectUri: properties.auth0RedirectURI,
        connection: properties.googleConnection,
        clientId: properties.auth0ClientId,
        domain: properties.auth0Domain,
        scope: "openid profile email",
        responseType: "token",
        owp: true,
      },
      function (err, authResult) {
        if (err) {
          // eslint-disable-next-line no-console
          console.log(err);
        } else {
          const token = authResult.accessToken + "";
          getUser(token);
          changeStage();
        }
      },
    );
  };

  const loginWithFacebook = () => {
    const webAuth = new auth0.WebAuth({
      domain: properties.auth0Domain,
      clientID: properties.auth0ClientId,
    });

    webAuth.popup.authorize(
      {
        nonce: "diagnostics",
        redirectUri: properties.auth0RedirectURI,
        connection: properties.facebookConnection,
        clientId: properties.auth0ClientId,
        domain: properties.auth0Domain,
        scope: "openid profile email",
        responseType: "token",
        owp: true,
      },
      function (err, authResult) {
        if (!err) {
          const token = authResult.accessToken + "";
          getUser(token);
          changeStage();
        } else { 
          // eslint-disable-next-line no-console
           console.log(err);
        } 
        
      },
    );
  };

  const getUser = (token: string) => {
    UserService.getGoogleUser(token)
      .then((res) => {
        const data = res.data;
        setName(data.given_name);
      })
      .catch(() => {
        // eslint-disable-next-line no-console
        console.error("Please contact Administrator!");
      });
  };

  const changeStage = () => {
    if (stage === "signup") {
      setStage("mobile");
    } else if (stage === "mobile") {
      setStage("verify");
    } else {
      setStage("signup");
    }
  };

  const handleOtpChange = (code1 : string) => {
    if (code1.length === 4) {
      setDisabledVerify(false);
    } else {
      setDisabledVerify(true);
    }

    setCode(code1);
  };

  if (stage === "signup") {
    return (
      <Container data-testid="loginscreen">
        <Box marginTop="4.41%" marginBottom="5.88%">
          <Image src={logo}></Image>
        </Box>
        <InputField
          label={FirstName}
          placeholder="eg: Patrick"
          width="85%"
          id="firstname"
          handleChange={handleChange}
        ></InputField>
        <InputField
          label={LastName}
          placeholder="eg: Smith"
          width="85%"
          id="lastname"
          handleChange={handleChange}
        ></InputField>
        <InputField
          label={EmailIdText}
          placeholder="eg: patricksmith@gmail.com"
          width="85%"
          id="email"
          handleChange={handleChange}
        ></InputField>
        <ContinueButton
          disabled={disabled}
          sx={{
            backgroundColor: `${
              disabled ? COLORS.ALPHA_BLUE_100 : COLORS.ALPHA_BLUE_500
            }`,
          }}
          onClick={handleContinueClick}
        >
          <ButtonText variant="bodyMedium" data-testid="continue">
            {Continue}
          </ButtonText>
        </ContinueButton>
        <Box display="flex" alignItems="center" justifyContent={"center"}>
          <Question variant="regularCaption">{Account}</Question>
          <Button
            variant="text"
            onClick={() => {
              loginWithRedirect();
            }}
          >
            <LoginText variant="button">{LoginConst}</LoginText>
          </Button>
        </Box>
        <Box
          display="flex"
          justifyContent="center"
          alignItems="center"
          marginTop="7.53%"
          width="100%"
        >
          <Line></Line>
          <SignUpOption variant="overline">{SignUpWith}</SignUpOption>
          <Line></Line>
        </Box>
        <Socials>
          <IconContainer onClick={loginWithGoogle} data-testid="iconbutton">
            <Icon component={google}></Icon>
          </IconContainer>
          <IconContainer onClick={loginWithFacebook} data-testid="iconbutton">
            <Icon component={facebook}></Icon>
          </IconContainer>
          <IconContainer data-testid="iconbutton">
            <Icon component={apple}></Icon>
          </IconContainer>
        </Socials>
      </Container>
    );
  } else if (stage === "mobile") {
    return (
      <Container data-testid="loginscreen">
        <Box marginTop="24px" marginBottom="32px">
          <Image src={logo}></Image>
        </Box>
        <Box
          display="flex"
          flexDirection="column"
          justifyContent="flex-start"
          width="85%"
        >
          <NameText variant="bodyMedium">{Hey + " " + name}</NameText>
          <OtpText variant="caption">{MobileNumberQuestion}</OtpText>
        </Box>
        <MobileNumberContainer>
          <InputField
            label={MobNumber}
            placeholder="+1 (330) 617-3324"
            width="85%"
            id="mobile"
            handleChange={handleOTPChange}
          ></InputField>
        </MobileNumberContainer>
        <ContinueButton
          disabled={disabledOTP}
          sx={{
            backgroundColor: `${
              disabledOTP ? COLORS.ALPHA_BLUE_100 : COLORS.ALPHA_BLUE_500
            }`,
          }}
          onClick={changeStage}
          data-testid="mobile"
        >
          <ButtonText variant="bodyMedium">{GetOTP}</ButtonText>
        </ContinueButton>
      </Container>
    );
  } else {
    return (
      <Container data-testid="loginscreen">
        <Box marginTop="24px" marginBottom="32px">
          <Image src={logo}></Image>
        </Box>
        <Box
          display="flex"
          flexDirection="column"
          justifyContent="flex-start"
          width="85%"
        >
          <NameText variant="bodyMedium">{Hey + " " + name}</NameText>
          <OtpText variant="caption">{EnterOTPRequest}</OtpText>
        </Box>
        <Box marginTop="16.91%">
          <OtpInput
            value={code}
            onChange={handleOtpChange}
            numInputs={4}
            separator={<span style={{ width: "8px" }}></span>}
            isInputNum={true}
            shouldAutoFocus={true}
            inputStyle={OTPStyles}
            focusStyle={FocusStyles}
          />
        </Box>
        <ContinueButton
          disabled={disabledVerify}
          sx={{
            backgroundColor: `${
              disabledVerify ? COLORS.ALPHA_BLUE_100 : COLORS.ALPHA_BLUE_500
            }`,
          }}
          onClick={changeStage}
          data-testid="verify"
        >
          <ButtonText variant="bodyMedium">{Verify}</ButtonText>
        </ContinueButton>
      </Container>
    );
  }
};

export default LoginPage;
