import React, { Component } from 'react'
import ProductService from '../services/ProductService'

class ListProductComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                products: []
        }
        this.addProduct = this.addProduct.bind(this);
        this.calculateProductPrice = this.calculateProductPrice.bind(this);
    }

    componentDidMount(){
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data});
        });
    }

    addProduct(){
        this.props.history.push('/add-product/_add');
    }


    calculateProductPrice(){
        this.props.history.push('/calculate-product-price/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Product List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addProduct}> Add Product</button>
                    <button style={{marginLeft: "10px"}} onClick={this.calculateProductPrice} className="btn btn-danger">Calculate Product Price </button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Product Name</th>
                                    <th> Units Per Carton</th>
                                    <th> Carton Price</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.products.map(
                                        product => 
                                        <tr key = {product.id}>
                                             <td> {product.productName} </td>   
                                             <td> {product.unitsPerCarton}</td>
                                             <td> {product.cartonPrice}</td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListProductComponent
