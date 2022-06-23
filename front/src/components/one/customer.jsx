import { useLocation } from 'react-router-dom';
import { deleteCustomer } from '../utils';
import ItemCard from './itemCard';

function Customer(props){
    const state = useLocation().state;
    console.log("state",state);
    if(!state || !state.customer) return <>Error</>
    const {id,email,name} = state.customer;
    const headers = [
            "ID: "+id,
            "Name: "+name,
            "Email: "+email];
    return <ItemCard id={id} titre="Customer" headers={headers} onDelete={deleteCustomer}/>;
}

export default Customer;