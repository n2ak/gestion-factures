import AllRecords from './allRecords';
import { deleteBill, fetchBills } from '../utils';

const names = ["id","customerId","price"];
function Bills(props){
    const titres = names.slice();
    titres.push("Action");
    return <AllRecords 
                addTo="/add/bill"
                titres={titres} 
                toRows={toRows} 
                fetchFunc={fetchBills} 
                recordTitle={"bill"} 
                to="/bill" 
                onDelete={deleteBill}/>;
}
function toRows(bills){
    return bills.map((bill)=>{
        const row = [];
        names.forEach((n)=>{if(bill[n])row.push(bill[n]);})
        const price = bill.productItems.map(pi=>pi.price).reduce((pv,cv)=>pv+cv);
        row.push(price);
        return row;
    });
}
export default Bills;