import { Form } from 'semantic-ui-react';
import { addCustomer } from '../utils';
import Add from './add';

function AddCustomer(props){
    const fields = (<>
        <Form.Field>
            <label>Customer Name:</label>
            <input placeholder='Name' name='name'/>
        </Form.Field>
        <Form.Field>
            <label>Customer Email:</label>
            <input placeholder='Email' type="email" name='email'/>
        </Form.Field>
    </>)
    return (<Add fields={fields} onSubmit={onSubmit} />);
}
function onSubmit(e){
    const name = e.target.parentNode.name.value;
    const email = e.target.parentNode.email.value;
    return addCustomer(name,email);
}

export default AddCustomer;