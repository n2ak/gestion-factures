import { Form } from 'semantic-ui-react';
import { addProduct } from '../utils';
import Add from './add';

function AddProduct(props){
    const fields = (<>
        <Form.Field>
            <label>Product Name:</label>
            <input placeholder='Name' name='name'/>
        </Form.Field>
        <Form.Field>
            <label>Product Price:</label>
            <input placeholder='Price' type="number" name='price'/>
        </Form.Field>
    </>)
    return (<Add fields={fields} onSubmit={onSubmit} />);
}
function onSubmit(e){
    const name = e.target.parentNode.name.value;
    const price = e.target.parentNode.price.value;
    return addProduct(name,price);
}

export default AddProduct;