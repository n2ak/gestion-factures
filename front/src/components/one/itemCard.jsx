import { Fragment } from 'react';
import { Item,Button,Icon} from 'semantic-ui-react';
import List from '../list';



function ItemCard(props){
    const {id,title,headers,onDelete,list} = props;
    return <>
        <Item.Group divided>
            <Item>
            <Item.Content>
                <h1 >{title}</h1><br/>
                {headers.map((header,index)=><Fragment key={index}><Item.Header >{header}</Item.Header><br/></Fragment>)}
                
                {list ? <><h3>{list.titre}</h3><List headers={list.headers} rows={list.rows}/></> : <></>}
                <Item.Extra>
                    <Button  floated='right' onClick={()=>onDelete(id)}>
                        <Button.Content visible>
                            <Icon name='delete' />
                        </Button.Content>
                        <Button.Content hidden>Delete</Button.Content>
                    </Button>
                </Item.Extra>
            </Item.Content>
            </Item>
        </Item.Group>
    </>;  
}

export default ItemCard;