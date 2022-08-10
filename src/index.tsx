import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { ThemeProvider as MUIThemeProvider } from "@mui/material/styles";
import { ThemeProvider } from "@emotion/react";
import theme from "./components/theme/index";
import "./index.css";

import properties from "./core-utils/properties";
import { Auth0Provider } from "@auth0/auth0-react";
import { BrowserRouter } from "react-router-dom";
const root = ReactDOM.createRoot(
  document.getElementById("root") as HTMLElement,
);

root.render(
  <Auth0Provider
    domain={properties.auth0Domain}
    clientId={properties.auth0ClientId}
    redirectUri={window.location.origin}
  >
    <MUIThemeProvider theme={theme}>
      <ThemeProvider theme={theme}>
        <BrowserRouter>
          <App />
        </BrowserRouter>
      </ThemeProvider>
    </MUIThemeProvider>
  </Auth0Provider>,
);
