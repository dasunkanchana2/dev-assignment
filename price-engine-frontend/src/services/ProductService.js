import axios from 'axios';

const GET_ALL_PRODUCTS_URL = "http://localhost:8294/api/v1/price-engine/products";
const ADD_PRODUCT_URL = "http://localhost:8294/api/v1/price-engine/product";
const PRODUCT_PRICE_CALCULATE_URL = "http://localhost:8294/api/v1/price-engine/product/price";

class ProductService {

    getProducts(){
        return axios.get(GET_ALL_PRODUCTS_URL);
    }

    createProduct(product){
        return axios.post(ADD_PRODUCT_URL, product);
    }

    calculateProductPrice(productName,product){
        return axios.post(PRODUCT_PRICE_CALCULATE_URL + '/' + productName, product);
    }

}

export default new ProductService()