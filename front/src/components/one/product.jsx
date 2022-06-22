import { useLocation } from 'react-router-dom';
import { deleteProduct } from '../utils';
import ItemCard from './itemCard';

function Product(props){
    const state = useLocation().state;
    if(!state || !state.product) return <>Error</>
    const {id,name,price} = state.product;
    const headers = [
            "ID: "+id,
            "Name: "+name,
            "Price: "+price];
    return <ItemCard id={id} titre="Product" headers={headers} onDelete={deleteProduct}/>;
}

export default Product;