import { Dimmer, Image, Loader, Message, Segment, Table } from 'semantic-ui-react';

function List(props){
    const {headers,rows,selectable,loading,error} = props;
    const listItems = rows.map(function(row,i){
        const c = row.map((item,j)=><Table.Cell key={j} collapsing={(j === row.length -1)}>{item}</Table.Cell>);
        return (
            <Table.Row key={i}>
                {c}
            </Table.Row>
        );
    });
    const errorBar = (
        <Message negative>
            <Message.Header>Error:</Message.Header>
            <p>{error}</p>
        </Message>
    );
    const loadingBar = (
        <Segment>
            <Dimmer active inverted>
                <Loader />
            </Dimmer>
            <Image src='https://react.semantic-ui.com/images/wireframe/short-paragraph.png' />
        </Segment>);
    return (
    <>
        <Table singleLine selectable={selectable}>
            <Table.Header>
                <Table.Row>
                    {headers.map((h,i)=><Table.HeaderCell key={i}>{h}</Table.HeaderCell>)}
                </Table.Row>
            </Table.Header>
            <Table.Body>
                {listItems}
            </Table.Body>
            
        </Table>
        {error ? errorBar  : (loading ? loadingBar : <></>)}
    </>);
}

export default List;