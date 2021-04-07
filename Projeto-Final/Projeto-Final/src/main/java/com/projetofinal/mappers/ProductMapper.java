package com.projetofinal.mappers;

import com.projetofinal.domains.Product;
import com.projetofinal.requests.ProductRegisterRequest;
import com.projetofinal.responses.ProductDataResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;

public class ProductMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDataResponse convertProductDomainToProductResponse(Product product) {
        ProductDataResponse productDataResponse = modelMapper.map(product, ProductDataResponse.class);
        return productDataResponse;
    }

    public Product convertProductRegisterRequestToEntity(ProductRegisterRequest productRequest) throws ParseException {
        Product productModel = modelMapper.map(productRequest, Product.class);
        return productModel;
    }
//
//    public User convertUserLoginRequestToEntity(UserLoginRequest userRequest) throws ParseException {
//        User userModel = modelMapper.map(userRequest, User.class);
//        return userModel;
//    }
}
