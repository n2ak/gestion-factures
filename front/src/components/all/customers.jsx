import AllRecords from './allRecords';
import { deleteCustomer, fetchCustomers } from '../utils';

const names = ["id","name","email"];
function Customers(props){
    const titres = names.slice();
    titres.push("Action");
    return <AllRecords 
                addTo="/add/customer"
                titres={titres}
                toRows={toRows}
                fetchFunc={fetchCustomers}
                recordTitle={"customer"}
                to="/customer"
                onDelete={deleteCustomer}/>;
}
function toRows(customers){
    if(!(customers instanceof Array) && customers.hasOwnProperty("_embedded") && customers["_embedded"].hasOwnProperty("customers")){
        customers = customers["_embedded"]["customers"];
    }
    return customers.map((customer)=>{
        const row = [];
        names.forEach((n)=>{
            if(customer[n]){
                row.push(customer[n]);
            }else{
                row.push("--");
            }
        })
        return row;
    });
}
export default Customers;