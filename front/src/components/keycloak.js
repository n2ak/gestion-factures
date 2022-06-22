import Keycloak from "keycloak-js";

const keycloak = new Keycloak({
    url: "http://localhost:8080/auth",
    realm: "factirations-realm",
    clientId: "facturations",
});
keycloak.init({
    onLoad: 'login-required',
    promiseType: 'native'
})
export default keycloak;