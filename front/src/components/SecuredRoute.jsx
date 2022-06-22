import { useKeycloak } from "@react-keycloak/web";

const SecureRoute = ({ children }) => {
    const { keycloak } = useKeycloak();
    if(keycloak.authenticated)
        return children;
    keycloak.login();
    return <></>;
};

export default SecureRoute;