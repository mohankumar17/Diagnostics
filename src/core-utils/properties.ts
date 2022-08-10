const prod = process.env.NODE_ENV === "production";

const getBaseUrl = () => {
  return  "http://zemosodiagnostic.gq/";
};

const getRedirectUrl = () => {
  return prod ? "https://greencommute.ga/" : "http://localhost:3000/";
};

const properties = {
  baseURL: getBaseUrl(),
  auth0Domain: "dev-ze3ptnwe.us.auth0.com",
  auth0ClientId: "uTRq6OLJcLTg6Rww4jVG0TnlaR0VBWZ0",
  auth0RedirectURI: getRedirectUrl(),
  googleConnection: "google-oauth2",
  facebookConnection: "facebook",
  appleConnection: "apple",
};

export default properties;


