import { Button, Form, Segment } from 'semantic-ui-react';

function Add({fields,onSubmit,extra}){

    return (
        <Segment>
            <Form>
                {fields}
                <Button primary type='submit' onClick={(e)=>{
                    onSubmit(e).then((result)=>{
                        alert("Created");
                    }).catch((e)=>{
                        alert("Error : " + e.message)
                    });
                }}>Ajouter</Button>
            </Form>
            {extra}
        </Segment>
  );
}

export default Add;