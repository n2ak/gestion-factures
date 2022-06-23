import { useEffect, useState } from 'react';
import { Button,Icon } from 'semantic-ui-react';
import List from '../list';
import { Link} from 'react-router-dom';

function AllRecords(props){
    const [records,setRecords] = useState([]);
    const [error,setError] = useState(null);
    const [loading,setLoading] = useState(true);
    const {fetchFunc,toRows,recordTitle,to,onDelete} = props;
    useEffect(()=>{
        // setRecords([{id:3,customerId:4,productItems:[{id:3,productId:5,quantity:10,price:10,product:{id:3,name:"haaah",price:300}}]}])
        fetchFunc().then((result)=>{
            console.log("fetch result",result)
            setRecords(result)
            setLoading(false);
        }).catch((e)=>{
            setError(e.message);
            setLoading(false);
        });
    },[]);
    // if(records.length===0)return <></>;
    const {titres} = props;
    const rows = toRows(records);
    let records_ = records;
    if(!(records instanceof Array) && records.hasOwnProperty("_embedded") && records["_embedded"].hasOwnProperty(recordTitle+"s")){
        records_ = records["_embedded"][recordTitle+"s"];
    }
    console.log("records",records)
    rows.forEach(function(row,index){
        const buttons = (<>
                            <Link to={to} state={{[recordTitle]:records_[index]}}>
                                <Button animated='fade'  >
                                    <Button.Content visible>
                                        <Icon name='eye' />
                                    </Button.Content>
                                    <Button.Content hidden>View</Button.Content>
                                </Button>
                            </Link>
                            <Button onClick={()=>onDelete(row[0])} animated='fade'>
                                <Button.Content visible>
                                    <Icon name='delete' />
                                </Button.Content>
                                <Button.Content hidden>Delete</Button.Content>
                            </Button>
                        </>);
        row.push(buttons);
        return row;
    });
    return (
    <>
        <List headers={titres} rows={rows} selectable loading={loading} error={error}/>
        <Link to={props.addTo} >
            <Button primary type='submit'>Add</Button>
        </Link>
    </>);
}
export default AllRecords;