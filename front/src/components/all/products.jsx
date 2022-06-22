import AllRecords from './allRecords';
import { deleteProduct, fetchProducts } from '../utils';

const names = ["id","name","price"];
function Products(props){
    const titres = names.slice();
    titres.push("Action");
    return <AllRecords 
                addTo="/add/product"
                titres={titres}
                toRows={toRows}
                fetchFunc={fetchProducts}
                recordTitle={"product"}
                to="/product"
                onDelete={deleteProduct}/>;
}
function toRows(products){
    return products.map((product)=>{
        const row = [];
        names.forEach((n)=>{if(product[n])row.push(product[n]);})
        return row;
    });
}
export default Products;