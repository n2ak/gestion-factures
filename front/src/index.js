import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import 'semantic-ui-css/semantic.min.css';
import { BrowserRouter as Router,Routes,Route,Link } from 'react-router-dom';
import Bill from './components/one/bill';
import { Container ,Header,Button} from "semantic-ui-react";
import Customer from './components/one/customer';
import Product from './components/one/product';
import Bills from './components/all/bills';
import Customers from './components/all/customers';
import Products from './components/all/products';
import AddCustomer from './components/add/addCustomer';
import AddProduct from './components/add/addProduct';
import AddBill from './components/add/addBill';
import SecureRoute from './components/SecuredRoute';
import keycloak from './components/keycloak';
import { ReactKeycloakProvider } from "@react-keycloak/web";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ReactKeycloakProvider authClient={keycloak}>
    <Router>
      <Container style={{ margin: 20 }}>
        <br/>
        <br/>
        <br/>
        <Header>

          <Link to="/bills"><Button>All bills</Button></Link>
          <Link to="/customers"><Button>All customers</Button></Link>
          <Link to="/products"><Button>All products</Button></Link>
          {/* <br/>
          <br/>
          <Link to="/add/bill"><Button>Add bill</Button></Link>
          <Link to="/add/customer"><Button>Add customer</Button></Link>
          <Link to="/add/product"><Button>Add product</Button></Link> */}
        </Header>
        <Routes>
          
          <Route exact path="/" element={<Products/>}></Route>
          <Route path="/bills" element={
            <SecureRoute>
              <Bills />
            </SecureRoute>
          }></Route>
          <Route path="/customers" element={<Customers />}></Route>
          <Route path="/products" element={<Products />}></Route>
          <Route path="/add" >
            <Route path="/add/product" element={<AddProduct/>} ></Route>
            <Route path="/add/customer" element={<AddCustomer/>} ></Route>
            <Route path="/add/bill" element={<AddBill/>} ></Route>
          </Route>

          <Route path="/customer" element={<Customer/>}></Route>
          <Route path="/product" element={<Product/>}></Route>
          <Route path="/bill" element={<Bill/>}></Route>
        </Routes>
      </Container>
    </Router>
    </ReactKeycloakProvider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
