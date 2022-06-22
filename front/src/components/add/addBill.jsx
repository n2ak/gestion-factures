import React, { useState } from 'react';
import { Form ,Button, Label, Container, Segment, Icon} from 'semantic-ui-react';
import { addBill } from '../utils';
import Add from './add';


class AddBill extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            products:[],
            refs:[],
            productIndices:[]
        };
    }
    addProduct(){
        let ref = React.createRef();
        const index = this.state.productIndices.length > 0 ? this.state.productIndices[this.state.productIndices.length-1] + 1 : 0;

        const item = (
            <div key={index} ref={ref}>

                <Segment  >
                    <label>Product Item :</label>
                    <Form.Field inline>
                        <label>Product Id:</label>
                        <input placeholder='Id' type="number" name={'productId'+index}/>
                    </Form.Field>
                    <Form.Field inline>
                        <label>Quantité:</label>
                        <input placeholder='Quantity' type="number" name={'quantity'+index}/>
                    </Form.Field>
                    <Form.Field inline>
                        <label>Price:</label>
                        <input placeholder='Price' type="number" name={'price'+index}/>
                    </Form.Field>
                    <Button onClick={()=>this.deleteProductItem(index)}>
                        <Icon name="delete"></Icon>
                    </Button>
                </Segment>
                <br/>
            </div>
        );
        this.setState({
            products:[...this.state.products,item],
            refs:[...this.state.refs,ref],
            productIndices:[...this.state.productIndices,index]
        });
    }
    
    deleteProductItem(index){
        console.log("deleting",index,this.state.productIndices)
        index = this.state.productIndices.indexOf(index);
        this.setState({
            products:this.state.products.filter((_,i)=>i!=index),
            refs:this.state.refs.filter((_,i)=>i!=index),
            productIndices:this.state.productIndices.filter((_,i)=>i!=index)
        },()=>console.log(this.state.productIndices));
    }
    render(){
        const fields = (<>
            <Form.Field>
                <label>Customer Id:</label>
                <input placeholder='Customer Id' type="number" name='customerId'/>
            </Form.Field>
                {this.state.products}
            <Button onClick={this.addProduct.bind(this)}>
                Add Product Item
            </Button ><br/><br/>
        </>)
        return (<Add fields={fields} onSubmit={this.onSubmit} />);
    }
    onSubmit(e){
        const customerId = e.target.parentNode.customerId.value;
        const values = this.state.refs
            // .filter((r,i)=>!this.state.productsRemoved[i])
            .map(ref=>{
                const inputs = [...ref.current.querySelectorAll('input')];
                const ret = inputs.map(input=>{return input.value;});
                return ret;
            }).map(pi=>{
                return  {
                    "productId":pi[0],
                    "quantity":pi[1],
                    "price":pi[2]
                };
            });
        return addBill(customerId,values);
    }
}

export default AddBill;




/*
import React, { useState } from 'react';
import { Form ,Button, Label, Container, Segment, Icon} from 'semantic-ui-react';
import { addBill } from '../utils';
import Add from './add';


function AddBill(props){
    const [products,setProducts] = useState([]);
    const [refs,setRefs] = useState([]);
    function addProduct(){
        let ref = React.createRef();
        const index = products.length;
        const item = (
            <div key={index} ref={ref}>

                <Segment  >
                    <label>Product Item {index}:</label>
                    <Form.Field inline>
                        <label>Product Id:</label>
                        <input placeholder='Id' type="number" name={'productId'+index}/>
                    </Form.Field>
                    <Form.Field inline>
                        <label>Quantité:</label>
                        <input placeholder='Quantity' type="number" name={'quantity'+index}/>
                    </Form.Field>
                    <Form.Field inline>
                        <label>Price:</label>
                        <input placeholder='Price' type="number" name={'price'+index}/>
                    </Form.Field>
                    <Button onClick={()=>deleteProductItem(index)}>
                        <Icon name="delete"></Icon>
                    </Button>
                </Segment>
                <br/>
            </div>
        );
        products.push(item);
        refs.push(ref);
        setProducts([...products]);
        setRefs([...refs]);
    }
    function deleteProductItem(index){
        // setProducts(products.filter((_,i)=>i==index));
        // setRefs(refs.filter((_,i)=>i==index));
    }
    const fields = (<>

        <Form.Field>
            <label>Customer Id:</label>
            <input placeholder='Customer Id' type="number" name='customerId'/>
        </Form.Field>
        {products}
        <Button onClick={addProduct}>
            Add Product Item
        </Button >
    </>)
    return (<Add fields={fields} onSubmit={(e)=>onSubmit(e,refs)} />);
}
function onSubmit(e,refs){
    const customerId = e.target.parentNode.customerId.value;
    const values = refs.map(ref=>{
        const inputs = [...ref.current.querySelectorAll('input')];
        const ret = inputs.map(input=>{return input.value;});
        return ret;
    });
    const productItems = values.map(pi=>{
        return  {
            "productId":pi[0],
            "quantity":pi[1],
            "price":pi[2]
        };
    });
    return addBill(customerId,productItems);
}

export default AddBill;
*/