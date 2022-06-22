import { useLocation } from 'react-router-dom';
import { deleteBill } from '../utils';
import ItemCard from './itemCard';
import { Button,Icon } from 'semantic-ui-react';
import { Link} from 'react-router-dom';

function Bill(props){
    const state = useLocation().state;
    if(!state || !state.bill) return <>Error</>
    const {id,customer,productItems} = state.bill;
    const price = productItems.map(pi=>pi.price).reduce((pv,cv)=>pv+cv);
    const productItemsRows =  productItems.map((productItem,index)=>{
        const {id:p_id,productId,quantity,price:p_price,product} = productItem;
        const button = <Link to="/product" state={{product:product}}>
                            <Button animated='fade'  >
                                <Button.Content visible>
                                    <Icon name='eye' />
                                </Button.Content>
                                <Button.Content hidden>View</Button.Content>
                            </Button>
                        </Link>;
        return [p_id,productId,quantity,p_price,button];
    });
    const headers = [
            "ID: "+id,
            "Montant: "+price,
            "Customer Id: "+customer,
            "Customer Name: "+customer,
            "Customer Email: "+customer]
    const list = {titre:"Product Items:",headers:["id","productId","quantity","price","Action"],rows:productItemsRows};
    return <ItemCard id={id} titre="Bill" headers={headers} list={list} onDelete={deleteBill}/>;
}

export default Bill;