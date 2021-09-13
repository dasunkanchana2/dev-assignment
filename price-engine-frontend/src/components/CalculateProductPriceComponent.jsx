import React, { Component } from 'react'
import ProductService from '../services/ProductService';

class CalculateProductPriceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            products: [],
            calculatedProductPrice: {},
            id: this.props.match.params.id,
            productName: '',
            productQty: '',
        }
        this.changeProductNameHandler = this.changeProductNameHandler.bind(this);
        this.changeProductQtyHandler = this.changeProductQtyHandler.bind(this);
        this.calculateProductPrice = this.calculateProductPrice.bind(this);
    }


    componentDidMount(){
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data});
        });
    }

    calculateProductPrice = (e) => {
        e.preventDefault();
        let product = {productQty: this.state.productQty};
        console.log('product => ' + JSON.stringify(product));
        ProductService.calculateProductPrice(this.state.productName,product).then(res =>{
            this.setState({calculatedProductPrice: res.data});
            });
    }
    
    changeProductNameHandler= (event) => {
        this.setState({productName: event.target.value});
    }

    changeProductQtyHandler= (event) => {
        this.setState({productQty: event.target.value});
    }


    cancel(){
        this.props.history.push('/products');
    }

    getTitle(){
        return <h3 className="text-center">Product Price Calculation</h3>
        
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Product Name: </label>
                                            <select placeholder="Product Name" name="productName" className="form-control" 
                                                value={this.state.productName} onChange={this.changeProductNameHandler}>
                                                {
                                                    this.state.products.map(
                                                        product => 
                                                        <option value={product.productName}>{product.productName}</option>
                                                    )
                                                }
                                            </select>
                                        </div>
                                        <div className = "form-group">
                                            <label> Product Qty: </label>
                                            <input placeholder="Product Qty" name="productQty" className="form-control" 
                                                value={this.state.productQty} onChange={this.changeProductQtyHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Product Price: </label>
                                            <input placeholder="Product Price" name="productPrice" className="form-control" 
                                                value={ this.state.calculatedProductPrice.productPrice }/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.calculateProductPrice}>Calculate</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CalculateProductPriceComponent
