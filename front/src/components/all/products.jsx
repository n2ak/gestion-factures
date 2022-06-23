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
    if(!(products instanceof Array) && products.hasOwnProperty("_embedded") && products["_embedded"].hasOwnProperty("products")){
        products = products["_embedded"]["products"];
    }
    return products.map((product)=>{
        const row = [];
        names.forEach((n)=>{
            if(product[n]){
                row.push(product[n]);
            }else{
                row.push("--");
            }
        })
        return row;
    });
}
export default Products;