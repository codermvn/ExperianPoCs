import "./AppStyle.css";

import { useState } from "react";

function Product() {
  const [productName, setProductName] = useState("");
  const [productPrice, setProductPrice] = useState("");
  const [company, setCompany] = useState("");
  const [inventory, setInventory] = useState("");
  const [message, setMessage] = useState("");

  let handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let res = await fetch("http://localhost:8085/addProduct", {      // http://order-svc:8085/addProduct
        method: "POST",
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
          body: JSON.stringify({
            productName: productName,
            productPrice: productPrice,
            company: company,
            inventory: inventory
        }),
      });
      
      let resJson = await res.json();
      
      if (res.status === 200) {
        setProductName("");
        setProductPrice("");
        setCompany("");
        setInventory("");
        setMessage("Product created successfully with productId = " + resJson.productId +
                    ", productName = " + resJson.productName + 
                    ", productPrice = " + resJson.productPrice +
                    ", Company = " + resJson.company +
                    ", Inventory = " + resJson.inventory);
        console.log(resJson);       
        console.log(resJson.productId);
        console.log(resJson.productName);
        console.log(resJson.productPrice);
        console.log(resJson.company);
        console.log(resJson.inventory); 
      } else {
        setMessage("Some error occured");
      }
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={productName}
          placeholder="productName"
          onChange={(e) => setProductName(e.target.value)}
        />
        <input
          type="text"
          value={productPrice}
          placeholder="productPrice"
          onChange={(e) => setProductPrice(e.target.value)}
        />
        <input
          type="text"
          value={company}
          placeholder="company"
          onChange={(e) => setCompany(e.target.value)}
        />        
        <input
          type="text"
          value={inventory}
          placeholder="inventory"
          onChange={(e) => setInventory(e.target.value)}
        />

        <button type="submit">Create</button>

        <div className="message">{message ? <p>{message}</p> : null}</div>
      </form>
    </div>
  );
}

export default Product;
