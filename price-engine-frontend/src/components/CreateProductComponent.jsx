import React, { Component } from 'react'
import ProductService from '../services/ProductService';

class CreateProductComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            productName: '',
            unitsPerCarton: '',
            cartonPrice: ''
        }
        this.changeProductNameHandler = this.changeProductNameHandler.bind(this);
        this.changeUnitsPerCartonHandler = this.changeUnitsPerCartonHandler.bind(this);
        this.changeCartonPriceHandler = this.changeCartonPriceHandler.bind(this);
        this.saveOrUpdateProduct = this.saveOrUpdateProduct.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ProductService.getProductById(this.state.id).then( (res) =>{
                let product = res.data;
                this.setState({productName: product.productName,
                    unitsPerCarton: product.unitsPerCarton,
                    cartonPrice : product.cartonPrice
                });
            });
        }        
    }
    saveOrUpdateProduct = (e) => {
        e.preventDefault();
        let product = {productName: this.state.productName, unitsPerCarton: this.state.unitsPerCarton, cartonPrice: this.state.cartonPrice};
        console.log('product => ' + JSON.stringify(product));
        ProductService.createProduct(product).then(res =>{
                this.props.history.push('/products');
            });
    }
    
    changeProductNameHandler= (event) => {
        this.setState({productName: event.target.value});
    }

    changeCartonPriceHandler= (event) => {
        this.setState({cartonPrice: event.target.value});
    }

    changeUnitsPerCartonHandler= (event) => {
        this.setState({unitsPerCarton: event.target.value});
    }

    cancel(){
        this.props.history.push('/products');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Product</h3>
        }else{
            return <h3 className="text-center">Update Product</h3>
        }
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
                                            <input placeholder="Product Name" name="productName" className="form-control" 
                                                value={this.state.productName} onChange={this.changeProductNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Units Per Carton: </label>
                                            <input placeholder="Units Per carton" name="unitsPerCarton" className="form-control" 
                                                value={this.state.unitsPerCarton} onChange={this.changeUnitsPerCartonHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Carton Price: </label>
                                            <input placeholder="Carton Price" name="cartonPrice" className="form-control" 
                                                value={this.state.cartonPrice} onChange={this.changeCartonPriceHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateProduct}>Save</button>
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

export default CreateProductComponent
