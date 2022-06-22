import Bills from './components/all/bills';





function App() {
  const bills = [{id:3,customerId:4}];
  return (
      <div className="App">
        <Bills  names={["id","customerId","price"]}/>
      </div>

  );
}

export default App;
