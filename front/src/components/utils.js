
const BILLS = "http://localhost:8082/bills";
const CUSTOMERS = "http://localhost:8082/customers";
const INVENTORY = "http://localhost:8082/products";

export async function fetchJson(url){
    const result = await fetch(url, {
        crossDomain: true,
        method: "GET",
    });
    return await result.json();
}
function deleteRecord(url,id){
    return fetch(url+"?id="+id,{
        method:"DELETE"
    });
}
function addRecord(url,obj){
    return fetch(url, {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(obj)
      })
}
//---------------------
export function deleteBill(id){
    console.log("Deleteing Bill",id)
    return deleteRecord(BILLS,id);
}
export function fetchBills(){
    return fetchJson(BILLS);
}
export function addBill(customerId,productItems){
    return addRecord(BILLS,{customerId,productItems});
}
//---------------------
export function deleteCustomer(id){
    console.log("Deleteing Customer",id)
    return deleteRecord(CUSTOMERS,id);
}
export function fetchCustomers(){
    return fetchJson(CUSTOMERS);
}
export function addCustomer(name,email){
    return addRecord(CUSTOMERS,{name,email});
}
//---------------------
export function deleteProduct(id){
    console.log("Deleteing Product",id)
    return deleteRecord(INVENTORY,id);
}
export function fetchProducts(){
    return fetchJson(INVENTORY);
}
export function addProduct(name,price){
    return addRecord(INVENTORY,{name,price});
}